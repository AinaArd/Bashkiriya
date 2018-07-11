package com.example.simulatorabramskogo.logic;

import java.util.ArrayList;
import java.util.List;

public class Abramskiy {
    private Integer sleep;
    private Integer mood;
    private Integer authority;
    private Integer markers;
    private List<Observer> observers;

    public Abramskiy() {
        sleep = 50;
        mood = 50;
        authority = 50;
        markers = 20;
        observers = new ArrayList<>();
        observers.add(new AchievementsManager(this));
    }

    public void beAtTime() {
        update(20, -10, 0, 10);
    }

    private void update(int markerPoints, int sleepPoints, int moodPoints, int authorityPoints) {
        if (markers + markerPoints < 0) {
            System.out.println("Sorry, out of markers");
        } else if (sleep + sleepPoints <= 0 || mood + moodPoints <= 0 || authority + authorityPoints <= 0) {
            System.out.println("Game over");
        } else {
            sleep += sleepPoints;
            mood += moodPoints;
            authority += authorityPoints;
            markers += markerPoints;
            notifyObservers();
            printCurrentState();
        }
    }

    private void notifyObservers() {
        for (Observer o: observers) {
            o.update();
        }
    }


    private void printCurrentState() {
        System.out.println("Sleep: " + sleep + "\n"
                          + "Mood: " + mood + "\n"
                          + "Authority: " + authority + "\n"
                          + "Markers: " + markers);
    }

    public Integer getMarkers() {
        return markers;
    }
}
