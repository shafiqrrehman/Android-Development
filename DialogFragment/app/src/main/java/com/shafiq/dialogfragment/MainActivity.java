package com.shafiq.dialogfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.Communicator {

    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.showBtn);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getSupportFragmentManager();
                MyDialogFragment frag = new MyDialogFragment();
                frag.show(manager, "MyDialog");
            }
        });
    }

    @Override
    public void respond(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
