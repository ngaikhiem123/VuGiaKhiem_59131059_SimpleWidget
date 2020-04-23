package vn.edu.ntu.giakhiem.vugiakhiem_59131059_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtDay, edtSoThich;
    RadioGroup rdgGioiTinh;
    Button btnXN;
    DatePickerDialog.OnDateSetListener birthDay;
    DatePickerDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvent();
        makeDatePicker();
        addDateEvent();
    }

    private void addViews() {
        edtName = findViewById(R.id.edtName);
        edtDay = findViewById(R.id.edtDay);
        rdgGioiTinh = findViewById(R.id.rdgGioiTinh);
        edtSoThich = findViewById(R.id.edtSoThich);
        btnXN = findViewById(R.id.btnXN);
    }

    private void addEvent() {
        btnXN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName = getName();
                String sDay = getDay();
                String sGioiTinh = getGioiTinh();
                String sSoThich = getSoThich();

                String sKQ = sName + "\nNgày sinh: " + sDay + "\nGiới tính:" + sGioiTinh + "\nSở Thích: " + sSoThich;
                Toast.makeText(getApplicationContext(), sKQ, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getName() {
        String s = edtName.getText().toString();
        if (s.matches("")) s = "Chưa rõ họ tên";
        return s;
    }

    private String getDay() {
        String s = edtDay.getText().toString();
        if (s.matches("")) s = "Chưa rõ";
        return s;
    }

    private void makeDatePicker() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        birthDay = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                String s = day + "/" + (month + 1) + "/" + year;
                edtDay.setText(s);
                dialog.updateDate(year, month, day);
            }
        };

        dialog = new DatePickerDialog(MainActivity.this, birthDay, year, month, day);
    }

    private void addDateEvent() {
        edtDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    private String getGioiTinh() {
        int selectedBtn = rdgGioiTinh.getCheckedRadioButtonId();
        return ((Button) findViewById(selectedBtn)).getText().toString();
    }

    private String getSoThich() {
        String s, s1 = getCheckedBox(), s2 = edtSoThich.getText().toString();

        if (!s1.matches("") && !s2.matches(""))
            return s1 + "; " + s2;
        else if (s1.matches("") && s2.matches(""))
            return "chưa rõ";
        else return s1 + s2;
    }

    private String getCheckedBox() {
        ViewGroup viewgroup = (ViewGroup) findViewById(R.id.mainLayout);
        String s = "";
        boolean kt = false;
        for (int i = 0; i < viewgroup.getChildCount(); i++) {
            View v1 = viewgroup.getChildAt(i);
            if (v1 instanceof CheckBox)
                if (((CheckBox) v1).isChecked())
                    if (kt)
                        s += "; " + ((CheckBox) v1).getText().toString();
                    else {
                        s += ((CheckBox) v1).getText().toString();
                        kt = true;
                    }
        }
        return s;
    }
}
