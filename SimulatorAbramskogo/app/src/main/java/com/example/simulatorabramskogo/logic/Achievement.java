package com.example.simulatorabramskogo.logic;


public class Achievement {
    private int id;
    private String name;
    private Integer markers;
    private boolean achieved;

    public Achievement(int id, String name, Integer markers, boolean achieved) {
        this.id = id;
        this.name = name;
        this.markers = markers;
        this.achieved = achieved;
    }

    public boolean getStatus() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    public int getId() {
        return id;
    }

    public Integer getMarkers() {
        return markers;
    }

    public String getName() {
        return name;
    }

}
