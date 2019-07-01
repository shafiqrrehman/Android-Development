package com.wayn.intenttests;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.launchMap)
    Button launchMap;

    @BindView(R.id.launchMarket)
    Button launchMArket;

    @BindView(R.id.launchEmail)
    Button launchEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.launchMap, R.id.launchMarket, R.id.launchEmail})
    public void buttonClicked(View v){

        int id = v.getId();
        Intent intent = null, chooser = null;
        String[] to = {"abc@gmail.com", "xyz@gmail.com"};

        if (id == R.id.launchMap) {

            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:24.8607, 67.0011"));
            startActivity(intent);

        } else if (id == R.id.launchMarket) {

            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.ninjakiwi.bloonstd6"));
            chooser = Intent.createChooser(intent, "Launch Market");
            startActivity(chooser);

        } else if (id == R.id.launchEmail) {

            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Sent from App.");
            intent.putExtra(Intent.EXTRA_TEXT, "Hi, update your account. and plz subscribe...");
            intent.setType("message/rfc822");
            startActivity(intent);

        }
    }

}
