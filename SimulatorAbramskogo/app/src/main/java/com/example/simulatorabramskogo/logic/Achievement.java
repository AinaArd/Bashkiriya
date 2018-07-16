package com.example.simulatorabramskogo.logic;


public class Achievement {
    private int id;
    private String name;
    private Integer markers;

    public Achievement(int id, String name, Integer markers) {
        this.id = id;
        this.name = name;
        this.markers = markers;
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
