package com.example.simulatorabramskogo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements MyListener {

    Button buttonDesc;
    Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);

        buttonStart = findViewById(R.id.buttonStart);


        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, Profile.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void mListener() {

    }
}
