package com.example.simulatorabramskogo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.simulatorabramskogo.R;

public class StartActivity extends AppCompatActivity implements MyListener {

    public static boolean checkIfFirstTime = true;
    Button buttonStart;
    ImageView imageViewAbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);

        buttonStart = findViewById(R.id.buttonStart);
        imageViewAbr = findViewById(R.id.imageViewAbr);

            if(checkIfFirstTime = true){
                DescriptionDialog descriptionDialog = new DescriptionDialog();
                descriptionDialog.show(getSupportFragmentManager(),"dialog");
                checkIfFirstTime = false;
            }

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, Navigation.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void mListener() {

    }
}
