package com.example.simulatorabramskogo.logic;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Downloader {
    private String resources = "app\\src\\main\\java\\com\\example\\simulatorabramskogo\\logic\\files\\resources.txt";
    private String achievements = "app\\src\\main\\java\\com\\example\\simulatorabramskogo\\logic\\files\\achs.txt";
    private String tasks = "app\\src\\main\\java\\com\\example\\simulatorabramskogo\\logic\\files\\tasks.txt";

    public void download(int sleep, int mood, int authority, int markers, Achievement achievement) {
        File dest = new File(Environment.getExternalStorageDirectory().toString() + resources);
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

    public List<Achievement> getListOfAchievements() {
        List<Achievement> listOfAchs = new ArrayList<>();
        File file = new File(Environment.getExternalStorageDirectory().toString() + achievements);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split("\\|");
                System.out.println(Arrays.toString(parts));
                listOfAchs.add(new Achievement(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2])));
                line = br.readLine();
            }
            fis.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfAchs;
    }

    public List<Action> getListOfTasks() {
        List<Action> listOfTasks = new ArrayList<>();
        File file = new File(Environment.getExternalStorageDirectory().toString() + tasks);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split("\\|");
                System.out.println(Arrays.toString(parts));
                listOfTasks.add(new Action(Abramskiy.getInstance(),
                        parts[5], Integer.parseInt(parts[0]), Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                line = br.readLine();
            }
            fis.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfTasks;
    }

}
