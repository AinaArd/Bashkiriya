package com.example.simulatorabramskogo.activities.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.activities.AchAdapter;
import com.example.simulatorabramskogo.database.Downloader;
import com.example.simulatorabramskogo.logic.Achievement;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AchievementsFragment extends Fragment {
    List<Achievement> listOfAchievements;
    RecyclerView recyclerView;

    public AchievementsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Downloader downloader = new Downloader(this.getContext());
        listOfAchievements = downloader.getListOfAchievements();
        View view = inflater.inflate(R.layout.fragment_achievements,container,false);
        recyclerView = view.findViewById(R.id.recycleViewAch);

        AchAdapter achAdapter = new AchAdapter(listOfAchievements);
        recyclerView.setAdapter(achAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    /* static final String achNumber = "number of achievement";

    TextView textView;

    Downloader d = new Downloader();
    List<Achievement> achievements = d.getListOfAchievements();

    public static AchievementsFragment newInstance(int i) {
        Bundle args = new Bundle();
//        args.putInt(achNumber,getIdInEachAch());
        AchievementsFragment fragment = new AchievementsFragment();
//        fragment.setArguments(args);
        return fragment;
    }

    public AchievementsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_achievements, container, false);
        textView.setText(getAchievement());
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(
                new PagerAdapter(getFragmentManager(), (List<Achievement>) AchievementsFragment.this));

        return view;
    }

    public int getIdInEachAch() {
        for (Achievement ach : achievements) {
            int id = ach.getId();
            return id;
        }
        return 0;
    }

    public String getAchievement() {
        for (Achievement achievement : achievements) {
            String ach = achievement.getName();
            return ach;
        }
        return "None available achievements";
    }*/
}
