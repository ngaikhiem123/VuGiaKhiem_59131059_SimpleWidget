package vn.edu.ntu.giakhiem.vugiakhiem_59131059_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtDay, edtSoThich;
    RadioGroup rdgGioiTinh;
    Button btnXN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvent();
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
                String sGioiTinh = getGioiTinh();
                String sSoThich = getSoThich();

                String sKQ = sName + "\n" + sGioiTinh + "\nSở Thích: " + sSoThich;
                Toast.makeText(getApplicationContext(), sKQ, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getName (){
        String s = edtName.getText().toString();
        if (s.matches("")) s = "Chưa rõ họ tên";
        return s;
    }

    private String getGioiTinh (){
        int selectedBtn = rdgGioiTinh.getCheckedRadioButtonId();
        return "Giới tính: " + ((Button) findViewById(selectedBtn)).getText().toString();
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
