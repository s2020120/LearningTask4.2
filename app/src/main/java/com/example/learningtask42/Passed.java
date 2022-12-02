package com.example.learningtask42;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Passed extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            Bundle extras = getIntent().getExtras();
            String Result = extras.getString("result");
            String Result2 = extras.getString("result2");
            setContentView(R.layout.passed_layout);

            Button btnReturn;
        btnReturn = (Button) findViewById(R.id.btn_return);
        TextView tvResult= (TextView) findViewById(R.id.txt_result);
        TextView tvResult2= (TextView) findViewById(R.id.txt_result2);
            tvResult.setText(Result);
            tvResult2.setText(Result2);
            btnReturn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Passed.this, MainActivity.class);
            startActivity(intent);
        }
    }
