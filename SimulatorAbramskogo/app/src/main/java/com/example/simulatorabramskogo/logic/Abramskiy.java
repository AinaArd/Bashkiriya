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

    public Abramskiy() {
        List<Integer> listOfInfo = (new Downloader()).getListOfInfo();
        markers = listOfInfo.get(0);
        sleep = listOfInfo.get(1);
        mood = listOfInfo.get(2);
        authority = listOfInfo.get(3);
    }

    public static Abramskiy getInstance() {
        if (instance == null) {
            instance = new Abramskiy();
        }
        return instance;
    }


    public void setSleep(Integer sleep) {
        if (sleep > 100) {
            this.sleep = 100;
        } else {
            this.sleep = 100;
        }
    }

    public void setMood(Integer mood) {
        if (mood > 100) {
            this.mood = 100;
        } else {
            this.mood = mood;
        }
    }

    public void setAuthority(Integer authority) {
        if (authority > 100) {
            this.authority = 100;
        } else {
            this.authority = authority;
        }
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
        if (sleep > 100) {
            sleep = 100;
        }
    }

    public void addMood(Integer moodPoints) {
        mood += moodPoints;
        if (mood > 100) {
            mood = 100;
        }
    }

    public void addAuthority(Integer authorityPoints) {
        authority += authorityPoints;
        if (authority > 100) {
            authority = 100;
        }
    }

    public void addMarkers(Integer markerPoints) {
        markers += markerPoints;
    }


    public void newGame() {
        Downloader d = new Downloader();
        d.newGame();
        instance = new Abramskiy();
    }
}
