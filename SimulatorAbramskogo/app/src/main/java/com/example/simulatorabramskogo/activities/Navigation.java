package com.example.simulatorabramskogo.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.activities.fragments.AchievementsFragment;
import com.example.simulatorabramskogo.activities.fragments.PagerFragment;
import com.example.simulatorabramskogo.activities.fragments.ProfileFragment;
import com.example.simulatorabramskogo.activities.fragments.TasksFragment;
import com.example.simulatorabramskogo.database.DBHelper;
import com.example.simulatorabramskogo.database.Downloader;
import com.example.simulatorabramskogo.logic.Abramskiy;

public class Navigation extends AppCompatActivity {

    private TextView mTextMessage;

    LinearLayout frameLayout;
    TasksFragment fragmentTask;
    PagerFragment fragmentAchievements;
    ProfileFragment fragmentProfile;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (item.getItemId() == R.id.profile) {
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
        fragmentAchievements = new PagerFragment();
        fragmentProfile = new ProfileFragment();

        setFragment(fragmentProfile);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onStop() {
        Downloader downloader = new Downloader(this);
        downloader.saveInfo(Abramskiy.getInstance());
        super.onStop();
    }

}


