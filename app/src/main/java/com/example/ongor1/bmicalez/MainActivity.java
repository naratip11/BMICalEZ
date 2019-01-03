package com.example.ongor1.bmicalez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_cal = (Button)findViewById(R.id.button_cal);
        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calBMI();
            }
        });
    }
    private void calBMI(){
        EditText textw = (EditText)findViewById(R.id.editText_wight);
        EditText texth = (EditText)findViewById(R.id.editText2_hight);

        double w = Double.parseDouble(textw. getText().toString());
        double h = Double.parseDouble(texth. getText().toString());

        h = h/100; //cm ---> m

        double bmi = w/(h*h);

        DecimalFormat decFormat = new DecimalFormat("##.##");
        String msg = "ค่า BMI คือ: "+ decFormat.format(bmi) + "\n";
        msg += "ลักษณะรูปร่างตือซ ";

        if (bmi >= 40) msg += "อ้วนเกิ๊น";
        else if(bmi >= 35) msg += "อ้วนจริง";
        else if(bmi >= 28.5) msg += "อ้วนจัง";
        else if(bmi >= 23.5) msg += "น้ำหนักเกิน";
        else if(bmi >= 18.5) msg += "ปกติ";
        else msg += "ต่ำเก๊น";

        Toast.makeText(getBaseContext(),msg, Toast.LENGTH_LONG).show();
    }
}
