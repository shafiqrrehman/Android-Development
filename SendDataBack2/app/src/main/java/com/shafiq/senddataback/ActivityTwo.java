package com.shafiq.senddataback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    private TextView tvNumbers;
    private Button btAdd;
    private Button btSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        setTitle("Activity 2");

        Intent i = getIntent();

        final int number1 = i.getIntExtra("number1", 0);
        final int number2 = i.getIntExtra("number2", 0);

        tvNumbers = findViewById(R.id.tvNumbers);
        tvNumbers.setText("Numbers: " + number1 + ", " + number2);

        btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = number1 + number2;

                Intent i = new Intent();
                i.putExtra("result", result);

                setResult(RESULT_OK, i);
                finish();
            }
        });

        btSub = findViewById(R.id.btSub);
        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = number1 - number2;

                Intent i = new Intent();
                i.putExtra("result", result);

                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
