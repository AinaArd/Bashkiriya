package com.example.simulatorabramskogo.logic;

public class Action {
    private int id;
    private static String name;
    private Integer markerPoints;
    private Integer sleepPoints;
    private Integer moodPoints;
    private Integer authorityPoints;
    private Abramskiy abramskiy;

    public Action(Abramskiy abramskiy, String name, int id, Integer markerPoints, Integer sleepPoints, Integer moodPoints, Integer authorityPoints) {
        this.abramskiy = abramskiy;
        this.id = id;
        this.name = name;
        this.markerPoints = markerPoints;
        this.sleepPoints = sleepPoints;
        this.moodPoints = moodPoints;
        this.authorityPoints = authorityPoints;
    }

    public int getId() {
        return id;
    }

    public void perform() {
        if (abramskiy.getMarkers() + markerPoints < 0) {
            System.out.println("Sorry, out of markers");
        } else if (abramskiy.getSleep() + sleepPoints <= 0 || abramskiy.getMood() + moodPoints <= 0 || abramskiy.getAuthority() + authorityPoints <= 0) {
            System.out.println("Game over");
        } else {
            abramskiy.addSleep(sleepPoints);
            abramskiy.addMood(moodPoints);
            abramskiy.addAuthority(authorityPoints);
            abramskiy.addMarkers(markerPoints);
            abramskiy.notifyObservers();
            abramskiy.printCurrentState();
        }
    }

    public static String getName() {
        return name;
    }
}
