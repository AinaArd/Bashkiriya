package com.example.simulatorabramskogo.logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Downloader {
    private String resources = "app\\src\\main\\java\\com\\example\\simulatorabramskogo\\logic\\resources.txt";
    private String achievements = "app\\src\\main\\java\\com\\example\\simulatorabramskogo\\logic\\achievements.txt";
    private String tasks = "app\\src\\main\\java\\com\\example\\simulatorabramskogo\\logic\\tasks.txt";

    public void download(int sleep, int mood, int authority, int markers, Achievement achievement) {
        File dest = new File(resources);
        FileWriter fw = null;
        try {
            fw = new FileWriter(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write(sleep + "\n");
            fw.write(mood + "\n");
            fw.write(authority + "\n");
            fw.write(markers + "\n");
            fw.write(achievement.getId() + " " + achievement.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
