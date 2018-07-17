package com.example.simulatorabramskogo.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.database.Downloader;

public class StartActivity extends AppCompatActivity implements MyListener {
    private static Context context;
    Button buttonStart;
    ImageView imageViewAbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);
        context = getApplicationContext();
        buttonStart = findViewById(R.id.buttonStart);
        imageViewAbr = findViewById(R.id.imageViewAbr);



        buttonStart.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, Navigation.class);
            startActivity(intent);
        });
    }

    public static Context getContext() {
        return context;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if ((new Downloader()).checkIfFirstTime()){
            DescriptionDialog descriptionDialog = new DescriptionDialog();
            descriptionDialog.show(getSupportFragmentManager(),"dialog");
            (new Downloader()).notFirstTime();
        }
    }

    @Override
    public void mListener() {

    }
}
