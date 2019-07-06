package com.shafiq.intentdatapassing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    private TextView txtView;
    private TextView txtView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        txtView = findViewById(R.id.textViewText);
        txtView2 = findViewById(R.id.textViewNumber);

        String value1 = getIntent().getStringExtra(MainActivity.EXTRA_TEXT);
        txtView.setText(value1);

        int value2 = getIntent().getIntExtra(MainActivity.EXTRA_NUMBER, 0);
        txtView2.setText("" + value2);
    }
}
