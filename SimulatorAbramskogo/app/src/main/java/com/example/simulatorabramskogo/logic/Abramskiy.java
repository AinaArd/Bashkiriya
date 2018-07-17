package com.example.simulatorabramskogo.logic;

import android.content.Context;
import android.util.Log;

import com.example.simulatorabramskogo.activities.Navigation;
import com.example.simulatorabramskogo.activities.fragments.ProfileFragment;
import com.example.simulatorabramskogo.database.DBHelper;
import com.example.simulatorabramskogo.database.Downloader;

import java.util.ArrayList;
import java.util.List;

public class Abramskiy {
    private static Abramskiy instance;
    private Integer sleep;
    private Integer mood;
    private Integer authority;
    private Integer markers;
    private List<Observer> observers;

    public Abramskiy() {
        List<Integer> listOfInfo = (new Downloader()).getListOfInfo();
        markers = listOfInfo.get(0);
        sleep = listOfInfo.get(1);
        mood = listOfInfo.get(2);
        authority = listOfInfo.get(3);
        observers = new ArrayList<>();
        observers.add(new AchievementsManager());
    }

    public static Abramskiy getInstance() {
        if (instance == null) {
            instance = new Abramskiy();
        }
        return instance;
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(sleep, mood, authority, markers);
        }
    }

    public void setSleep(Integer sleep) {
        this.sleep = sleep;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public void setMarkers(Integer markers) {
        this.markers = markers;
    }

    public Integer getMarkers() {
        return markers;
    }

    public Integer getSleep() {
        return sleep;
    }

    public Integer getMood() {
        return mood;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void addSleep(Integer sleepPoints) {
        sleep += sleepPoints;
    }

    public void addMood(Integer moodPoints) {
        mood += moodPoints;
    }

    public void addAuthority(Integer authorityPoints) {
        authority += authorityPoints;
    }

    public void addMarkers(Integer markerPoints) {
        markers += markerPoints;
    }

    public AchievementsManager getAchievementsManager() {
        for (Observer observer : observers) {
            if (observer instanceof AchievementsManager) {
                return (AchievementsManager) observer;
            }
        }
        return null;
    }

}
