package com.example.simulatorabramskogo.logic;

import java.util.ArrayList;
import java.util.List;

public class Abramskiy {
    private Integer sleep;
    private Integer mood;
    private Integer authority;
    private Integer markers;
    private List<Action> actions;
    private List<Observer> observers;

    public Abramskiy() {
        sleep = 50;
        mood = 50;
        authority = 50;
        markers = 20;
        actions = loadActions();
        observers = new ArrayList<>();
        observers.add(new AchievementsManager(this));
    }

    private List<Action> loadActions() {
        //ToDo loading actions
        return null;
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


    public void printCurrentState() {
        System.out.println("Sleep: " + sleep + "\n"
                          + "Mood: " + mood + "\n"
                          + "Authority: " + authority + "\n"
                          + "Markers: " + markers);
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
}
