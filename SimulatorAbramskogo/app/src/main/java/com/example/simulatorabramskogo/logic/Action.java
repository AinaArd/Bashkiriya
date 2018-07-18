package com.example.simulatorabramskogo.logic;

public class Action {
    private int id;
    private  String name;
    private Integer markerPoints;
    private Integer sleepPoints;
    private Integer moodPoints;
    private Integer authorityPoints;
    private Abramskiy abramskiy;

    public Action(int id, String name, Integer sleepPoints, Integer moodPoints, Integer authorityPoints,  Integer markerPoints) {
        this.abramskiy = Abramskiy.getInstance();
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
            abramskiy.addSleep(sleepPoints);
            abramskiy.addMood(moodPoints);
            abramskiy.addAuthority(authorityPoints);
            abramskiy.addMarkers(markerPoints);
    }

    public String getName() {
        return name;
    }

    public Integer getMarkerPoints() {
        return markerPoints;
    }

    public Integer getSleepPoints() {
        return sleepPoints;
    }

    public Integer getMoodPoints() {
        return moodPoints;
    }

    public Integer getAuthorityPoints() {
        return authorityPoints;
    }
}
