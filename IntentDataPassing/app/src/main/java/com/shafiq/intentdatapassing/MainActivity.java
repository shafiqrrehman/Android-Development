package com.shafiq.intentdatapassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "EXTRA_NUMBER";

    private Button btn;
    private EditText text;
    private EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.stringText);
        number = findViewById(R.id.numberText);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    private void openActivity2() {

        String txt = text.getText().toString();
        int num = Integer.parseInt(number.getText().toString());

        Intent intent = new Intent(this, ActivityTwo.class);
        intent.putExtra(EXTRA_TEXT, txt);
        intent.putExtra(EXTRA_NUMBER, num);
        startActivity(intent);
    }
}
