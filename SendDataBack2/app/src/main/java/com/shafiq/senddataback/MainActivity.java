package com.shafiq.senddataback;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edNum1;
    private EditText edNum2;
    private Button btOpen;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvresult);
        edNum1 = findViewById(R.id.edNum1);
        edNum2 = findViewById(R.id.edNum2);
        btOpen = findViewById(R.id.btOpen);
        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityTwo();
            }
        });
    }

    private void openActivityTwo() {

        if (edNum1.getText().toString().equals("") || edNum2.getText().toString().equals("")) {
            Toast.makeText(this, "Plz,  Enter Numbers", Toast.LENGTH_SHORT).show();
        } else {

            int number1 = Integer.parseInt(edNum1.getText().toString());
            int number2 = Integer.parseInt(edNum2.getText().toString());

            Intent i = new Intent(this, ActivityTwo.class);
            i.putExtra("number1", number1);
            i.putExtra("number2", number2);
            startActivityForResult(i, 200);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200) {

            if (resultCode == RESULT_OK) {

                int result = data.getIntExtra("result", 0);
                tvResult.setText("" + result);
            }
            if (resultCode == RESULT_CANCELED) {

                tvResult.setText("Nothing Selected");
            }
        }
    }
}
