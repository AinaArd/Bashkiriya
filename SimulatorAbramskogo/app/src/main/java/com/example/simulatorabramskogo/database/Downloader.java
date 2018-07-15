package com.example.simulatorabramskogo.database;

import android.content.Context;
import android.database.Cursor;

import com.example.simulatorabramskogo.logic.Achievement;
import com.example.simulatorabramskogo.logic.Action;

import java.util.ArrayList;
import java.util.List;

public class Downloader {
    DBHelper helper;

    public Downloader(Context context) {
        this.helper = new DBHelper(context);
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
}