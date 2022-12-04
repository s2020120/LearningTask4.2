package com.example.learningtask42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int gr1, gr2, FGrade, MidTrm, EndTrm;
    String Remark;
    EditText et1, et2;
    Button btnCompute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCompute = (Button) findViewById(R.id.button1);

        btnCompute.setOnClickListener(this);

            }
    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Computing....", Toast.LENGTH_SHORT).show();
        compute();
    }

    public void compute() {
        et1 = (EditText) findViewById(R.id.editTextNumber1);
        et2 = (EditText) findViewById(R.id.editTextNumber2);

        if (et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty()) {
            gr1 = 0;
            gr2 = 0;

        } else {

            gr1 = Integer.parseInt(et1.getText().toString());
            gr2 = Integer.parseInt(et2.getText().toString());
        }
        MidTrm = (int) (gr1 * 0.5);
        EndTrm = (int) (gr2 * 0.5);
        FGrade = MidTrm + EndTrm;

        if(FGrade >=95){
            Remark ="A";
        }else if (FGrade >=90){
            Remark = "B";
        } else if (FGrade>=85){
            Remark = "C";
        } else if (FGrade >=80){
            Remark = "D";
        } else if (FGrade >=75){
            Remark = "E";
        }else {
            Remark = "F";
        }

        switch (Remark) {
            case "A":
            case "B":
            case "C":
            case "D":
            case "E":
                String resultgrade = String.valueOf(FGrade);
                Bundle args = new Bundle();
                args.putString("result", Remark);
                args.putString("result2", resultgrade);


                Intent intent = new Intent(MainActivity.this, Passed.class);
                intent.putExtras(args);
                startActivity(intent);
                break;

            case "F":
                resultgrade = String.valueOf(FGrade);
                Bundle args2 = new Bundle();
                args2.putString("result", Remark);
                args2.putString("result2", resultgrade);

                Intent intent2 = new Intent(MainActivity.this, Failed.class);
                intent2.putExtras(args2);
                startActivity(intent2);
                break;
        }
    }
}