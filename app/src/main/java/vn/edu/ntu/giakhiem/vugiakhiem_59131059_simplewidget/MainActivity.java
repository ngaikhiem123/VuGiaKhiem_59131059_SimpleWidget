package vn.edu.ntu.giakhiem.vugiakhiem_59131059_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName,edtDay;
    RadioGroup rdgGioiTinh;

    Button btnXN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvent();
    }

    private void addViews(){
        edtName = findViewById(R.id.edtName);
        edtDay = findViewById(R.id.edtDay);
        rdgGioiTinh = findViewById(R.id.rdgGioiTinh);
        btnXN = findViewById(R.id.btnXN);
    }
    private void addEvent(){
        btnXN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName = edtName.getText().toString();
                if (sName.matches("")) sName = "Chưa rõ họ tên";

                int selectedBtn = rdgGioiTinh.getCheckedRadioButtonId();
                String sGioiTinh = "Giới tính: " + ((Button)findViewById(selectedBtn)).getText().toString();

                //String sCheckbox = getCheckedBox((LinearLayout)findViewById(R.id.mainLayout));
                String sKQ = sName + "\n" + sGioiTinh;
                Toast.makeText(getApplicationContext(),sKQ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getCheckedBox(LinearLayout linearLayout){
        String s = "";
        for (int i = 0 ; i < linearLayout.getChildCount(); i++){
            View v= linearLayout.getChildAt(i);
            if (((CheckBox)v).isChecked()) s +=((CheckBox) v).getText().toString();
        }
        return s;
    }
}
