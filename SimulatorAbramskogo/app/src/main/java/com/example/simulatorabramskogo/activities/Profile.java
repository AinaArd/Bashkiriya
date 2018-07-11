package com.example.simulatorabramskogo.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;

public class Profile extends AppCompatActivity {

    private TextView mTextMessage;
    ImageView profilePicAdr;
    TextView sleep;
    TextView mood;
    TextView authority;
    ProgressBar progressBarSleep;
    ProgressBar progressBarMood;
    ProgressBar progressBarAuthoruty;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.profile:
                    mTextMessage.setText("Профиль");
                    return true;
                case R.id.tasks:
                    mTextMessage.setText("Задания");
                    return true;
                case R.id.achievements:
                    mTextMessage.setText("Достижения");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sleep = findViewById(R.id.textViewSleep);
        mood = findViewById(R.id.textViewMood);
        authority = findViewById(R.id.textViewAuthority);

        progressBarSleep = (ProgressBar) findViewById(R.id.progressBarSleep);
        progressBarMood = (ProgressBar) findViewById(R.id.progressBarMood);
        progressBarAuthoruty = (ProgressBar) findViewById(R.id.progressBarAuthority);


        profilePicAdr = findViewById(R.id.imageViewAbr);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }




}
