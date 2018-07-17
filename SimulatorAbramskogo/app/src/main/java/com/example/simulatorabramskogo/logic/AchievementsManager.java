package com.example.simulatorabramskogo.logic;

import android.app.Application;
import android.util.Log;

import com.example.simulatorabramskogo.database.Downloader;

import java.util.ArrayList;
import java.util.List;

public class AchievementsManager {
    private static AchievementsManager instance;
    private List<Achievement> achievements;
    private Achievement currentAchievement;
    private Achievement nextAchievement;

    private AchievementsManager() {
        achievements = (new Downloader()).getListOfAchievements();
        Log.d("SIZE", String.valueOf(achievements.size()));
        nextAchievement = achievements.get(0);
    }

    public static AchievementsManager getInstance() {
        if (instance == null) {
            instance = new AchievementsManager();
        }
        return instance;
    }

    public void update() {
        currentAchievement = nextAchievement;
        nextAchievement = getNextAchievement(nextAchievement);

    }

//    public void update(Integer sleep, Integer mood, Integer authority, Integer markers) {
//        if (Abramskiy.getInstance().getMarkers() >= nextAchievement.getMarkers()) {
//            currentAchievement = nextAchievement;
//            nextAchievement = getNextAchievement(nextAchievement);
//            //TODO dialog about next achievement
//            System.out.println("You achieved: " + currentAchievement.getName());
//            if (nextAchievement == null) {
//                //TODO dialog about winning
//            }
//        }
//    }

    public Achievement getNextAchievement() {
        return nextAchievement;
    }

    public Achievement getNextAchievement(Achievement a) {
        for (Achievement achievement : achievements) {
            if (achievement.getId() == a.getId() + 1) {
                return achievement;
            }
        }
        return null;
    }

    public Achievement getCurrentAchievement() {
        return currentAchievement;
    }

    public void setNextAchievement(Achievement nextAchievement) {
        this.nextAchievement = nextAchievement;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }
}
