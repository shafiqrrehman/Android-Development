package com.wayn.fragmentscommunication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(String data) {

        FragmentManager manager = getSupportFragmentManager();
        TextFragment f2 = (TextFragment) manager.findFragmentById(R.id.fragment2);
        f2.changeText(data);
    }
}
