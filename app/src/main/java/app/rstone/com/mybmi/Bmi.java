package app.rstone.com.mybmi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bmi extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        final Context ctx = Bmi.this;
        final EditText height = findViewById(R.id.height);
        final EditText weight = findViewById(R.id.weight);
        final TextView result = findViewById(R.id.bmi_result);
        class BmiCalc{
            double height, weight, bmi;
            String result;
            public void exeBmi() {
                bmi = (weight) / (height * height / 10000);
                if (bmi < 18.5) {
                    result = "저체중";
                } else if (18.5 <= bmi && bmi < 23) {
                    result = "정상";
                } else if (23 <= bmi && bmi < 25) {
                    result = "비만 전단계";
                } else if (25 <= bmi && bmi < 30) {
                    result = "1단계 비만";
                } else if (30 <= bmi && bmi < 35) {
                    result = "2단계 비만";
                } else {
                    result = "3단계 비만";
                }
            }
        }
        final BmiCalc b = new BmiCalc();
        findViewById(R.id.bmi_btn).setOnClickListener(
                (View v)->{
                    b.height = Double.parseDouble(height.getText().toString());
                    b.weight = Double.parseDouble(weight.getText().toString());
                    b.exeBmi();
                    result.setText("BMI : "+(Math.floor(b.bmi*100))/100+ ", 판정 : " +b.result);
                }
        );
    }
}
/*
new View.OnClickListener() {
@Override
public void onClick(View v) {
        EditText height = findViewById(R.id.height);
        EditText weight = findViewById(R.id.weight);
        b.setHeight(Double.parseDouble(height.getText().toString()));
        b.setWeight(Double.parseDouble(weight.getText().toString()));
        b.exeBmi();
        TextView result = findViewById(R.id.bmi_result);
        result.setText("BMI : "+(Math.floor(b.getBmi()*100))/100+ ", 판정 : " +b.getResult());
        }
        }*/
