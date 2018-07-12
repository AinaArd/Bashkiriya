package com.example.simulatorabramskogo.activities;

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

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.activities.fragments.AchievementsFragment;
import com.example.simulatorabramskogo.activities.fragments.ProfileFragment;
import com.example.simulatorabramskogo.activities.fragments.TasksFragment;
import com.example.simulatorabramskogo.logic.Abramskiy;

public class Navigation extends AppCompatActivity {

    private int currentPressedButton = -1;
    private TextView mTextMessage;


    FrameLayout frameLayout;
    TasksFragment fragmentTask;
    AchievementsFragment fragmentAchievements;
    ProfileFragment fragmentProfile;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (item.getItemId() == currentPressedButton) {
                return false;
            } else if (item.getItemId() == R.id.profile) {
                setFragment(fragmentProfile);
                return true;
            } else if (item.getItemId() == R.id.tasks) {
                setFragment(fragmentTask);
                return true;
            } else if (item.getItemId() == R.id.achievements) {
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


        frameLayout = findViewById(R.id.framelayout);
        fragmentTask = new TasksFragment();
        fragmentAchievements = new AchievementsFragment();
        fragmentProfile = new ProfileFragment();


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}


