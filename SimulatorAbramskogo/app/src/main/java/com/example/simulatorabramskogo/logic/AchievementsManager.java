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
        Downloader d = new Downloader();
        achievements = d.getListOfAchievements();
        Log.d("SIZE", String.valueOf(achievements.size()));
        currentAchievement = d.getCurrentAchievement();
        nextAchievement = getNextAchievement(currentAchievement);
    }

    public static AchievementsManager getInstance() {
        if (instance == null) {
            instance = new AchievementsManager();
        }
        return instance;
    }

    public void update() {
        nextAchievement.setAchieved(true);
        currentAchievement = nextAchievement;
        nextAchievement = getNextAchievement(nextAchievement);

    }

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

    public void newGame() {
        instance = new AchievementsManager();
    }
}
