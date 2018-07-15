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
    private List<Action> actions;
    private List<Observer> observers;

    private Abramskiy() {
        sleep = 50;
        mood = 50;
        authority = 50;
        markers = 20;
        observers = new ArrayList<>();
        observers.add(new AchievementsManager(this));
        observers.add(new ProfileFragment());
    }

    public static Abramskiy getInstance() {
        if (instance == null) {
            instance = new Abramskiy();
        }
        return instance;
    }

    public void performAction(int id) {
        Action action = findActionById(id);
        action.perform();
    }

    private Action findActionById(int id) {
        for (Action action: actions) {
            if (action.getId() == id) {
                return action;
            }
        }
        return null;
    }


    public void notifyObservers() {
        for (Observer o: observers) {
            o.update();
        }
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

    public List<Action> getActions() {
        return actions;
    }
}
