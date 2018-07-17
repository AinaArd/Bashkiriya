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
import com.example.simulatorabramskogo.logic.Abramskiy;
import com.example.simulatorabramskogo.logic.Achievement;
import com.example.simulatorabramskogo.logic.AchievementsManager;
import com.example.simulatorabramskogo.logic.Observer;


import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AchievementsFragment extends Fragment implements Observer {
    List<Achievement> listOfAchievements;
    RecyclerView recyclerView;

    Achievement currentAchievement;
    Achievement nextAchievement;

    public AchievementsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Downloader downloader = new Downloader();
        listOfAchievements = downloader.getListOfAchievements();
        View view = inflater.inflate(R.layout.fragment_achievements, container, false);
        recyclerView = view.findViewById(R.id.recycleViewAch);

        AchAdapter achAdapter = new AchAdapter(listOfAchievements);
        recyclerView.setAdapter(achAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        
        update(Abramskiy.getInstance().getSleep(), Abramskiy.getInstance().getMood(), Abramskiy.getInstance().getAuthority(), Abramskiy.getInstance().getMarkers());

        return view;
    }


    @Override
    public void update(Integer sleep, Integer mood, Integer authority, Integer markers) {
        if (Abramskiy.getInstance().getMarkers() >= AchievementsManager.getInstance().getNextAchievement().getMarkers()) {
            AchievementsManager.getInstance().setNextAchievement(currentAchievement);
            nextAchievement = AchievementsManager.getInstance().getNextAchievement(nextAchievement);
            //ToDo update
        }
    }

}
