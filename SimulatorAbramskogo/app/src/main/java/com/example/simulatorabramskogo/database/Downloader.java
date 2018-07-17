package com.example.simulatorabramskogo.database;

import android.content.Context;
import android.database.Cursor;

import com.example.simulatorabramskogo.activities.StartActivity;
import com.example.simulatorabramskogo.logic.Abramskiy;
import com.example.simulatorabramskogo.logic.Achievement;
import com.example.simulatorabramskogo.logic.Action;

import java.util.ArrayList;
import java.util.List;

public class Downloader {
    DBHelper helper;

    public Downloader() {
        this.helper = new DBHelper(StartActivity.getContext());
    }

    public List<Action> getListOfActions() {
        List<Action> actions = new ArrayList<>();
        Cursor cursor = helper.getReadableDatabase().query("actions", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idColIndex = cursor.getColumnIndex("id");
            int nameColIndex = cursor.getColumnIndex("name");
            int sleepColIndex = cursor.getColumnIndex("sleepPoints");
            int moodColIndex = cursor.getColumnIndex("moodPoints");
            int authorityColIndex = cursor.getColumnIndex("authorityPoints");
            int markerColIndex = cursor.getColumnIndex("markerPoints");

            do {
                actions.add(new Action(cursor.getInt(idColIndex),
                        cursor.getString(nameColIndex),
                        cursor.getInt(sleepColIndex),
                        cursor.getInt(moodColIndex),
                        cursor.getInt(authorityColIndex),
                        cursor.getInt(markerColIndex)
                ));
            } while (cursor.moveToNext());
        } else {
            cursor.close();
        }

        return actions;
    }

    public List<Achievement> getListOfAchievements() {
        List<Achievement> achievements = new ArrayList<>();

        Cursor cursor = helper.getReadableDatabase().query("achievements", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idColIndex = cursor.getColumnIndex("id");
            int nameColIndex = cursor.getColumnIndex("name");
            int markerColIndex = cursor.getColumnIndex("markers");

            do {
                achievements.add(new Achievement(cursor.getInt(idColIndex),
                        cursor.getString(nameColIndex),
                        cursor.getInt(markerColIndex)
                ));
            } while (cursor.moveToNext());

        }
        return achievements;
    }

    public void saveInfo(Abramskiy abramskiy) {
        helper.getReadableDatabase().execSQL("delete from memory");
        helper.getReadableDatabase().execSQL("insert into memory(markers, sleep, mood, authority, achievement) " +
                "values (" +
                abramskiy.getMarkers() + "," +
                abramskiy.getSleep() + "," +
                abramskiy.getMarkers() + "," +
                abramskiy.getAuthority() + "," +
                abramskiy.getAchievementsManager().getCurrentAchievement().getId() + ")");
    }

    public List<Integer> getListOfInfo() {
        List<Integer> list = new ArrayList<>();
        Cursor cursor = helper.getReadableDatabase().query("memory", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            list.add(cursor.getInt(cursor.getColumnIndex("markers")));
            list.add(cursor.getInt(cursor.getColumnIndex("sleep")));
            list.add(cursor.getInt(cursor.getColumnIndex("mood")));
            list.add(cursor.getInt(cursor.getColumnIndex("authority")));
        }
        return list;
    }

    public boolean checkIfFirstTime() {
        Cursor cursor = helper.getReadableDatabase().query("memory", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int bool = cursor.getInt(cursor.getColumnIndex("firsttime"));
            return bool == 1;
        }
        return false;
    }

    public void notFirstTime() {
        helper.getReadableDatabase().execSQL("update memory set firsttime=0 where id=1");
    }
}

