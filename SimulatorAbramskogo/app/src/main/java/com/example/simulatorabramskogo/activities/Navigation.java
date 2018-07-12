package com.example.simulatorabramskogo.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TaskStackBuilder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.activities.fragments.AchievementsFragment;
import com.example.simulatorabramskogo.activities.fragments.TasksFragment;
import com.example.simulatorabramskogo.logic.Abramskiy;

public class Navigation extends AppCompatActivity {
    private Abramskiy abramskiy;
    private int currentPressedButton = -1;
    private TextView mTextMessage;
    ImageView profilePicAdr;
    TextView sleep;
    TextView mood;
    TextView authority;

    TextView markers;
    ProgressBar progressBarSleep;
    ProgressBar progressBarMood;
    ProgressBar progressBarAuthority;

    FrameLayout frameLayout;
    TasksFragment fragmentTask;
    AchievementsFragment fragmentAchievements;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            /*switch (item.getItemId()) {
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
            return false;*/

            if (item.getItemId() == currentPressedButton) {
                return false;
            } else if (item.getItemId() == R.id.profile) {
                return true;
            } else if (item.getItemId() == R.id.tasks) {
                // TODO go to tasks activity
                setFragment(fragmentTask);
                return true;
            } else if (item.getItemId() == R.id.achievements) {
                // TODO go to achievements activity
                setFragment(fragmentAchievements);
                return true;
            }
            return false;
        }

    };


    private void setFragment(Fragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        abramskiy = Abramskiy.getInstance();
        sleep = findViewById(R.id.textViewSleep);
        mood = findViewById(R.id.textViewMood);
        authority = findViewById(R.id.textViewAuthority);

        markers = findViewById(R.id.textViewMarkers);
        markers.setText(String.valueOf(abramskiy.getMarkers()));

        progressBarSleep = (ProgressBar) findViewById(R.id.progressBarSleep);
        progressBarSleep.setProgress(abramskiy.getSleep());

        progressBarMood = (ProgressBar) findViewById(R.id.progressBarMood);
        progressBarMood.setProgress(abramskiy.getMood());

        progressBarAuthority = (ProgressBar) findViewById(R.id.progressBarAuthority);
        progressBarAuthority.setProgress(abramskiy.getAuthority());

        frameLayout = findViewById(R.id.framelayout);
        fragmentTask = new TasksFragment();
        fragmentAchievements = new AchievementsFragment();


        profilePicAdr = findViewById(R.id.imageViewAbr);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}


