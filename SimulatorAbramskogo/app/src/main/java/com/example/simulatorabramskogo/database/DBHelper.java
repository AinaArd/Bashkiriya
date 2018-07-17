package com.example.simulatorabramskogo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.simulatorabramskogo.logic.Abramskiy;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "myDB", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table actions("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "sleepPoints integer,"
                + "moodPoints integer,"
                + "authorityPoints integer,"
                + "markerPoints integer"
                + ");");
        sqLiteDatabase.execSQL("create table achievements("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "markers integer,"
                + "achieved integer" +
                ");");

        sqLiteDatabase.execSQL("create table memory("
                + "id integer primary key autoincrement,"
                + "markers integer,"
                + "sleep integer,"
                + "mood integer,"
                + "authority integer,"
                + "achievement integer," +
                "firsttime integer" +
                ");");

        loadActions(sqLiteDatabase);
        loadAchievements(sqLiteDatabase);
        loadInfo(sqLiteDatabase);
    }


    private void loadInfo(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("insert into memory(markers, sleep, mood, authority, achievement, firsttime) values (20, 50, 50, 50, 1, 1)");
    }

    private void loadAchievements(SQLiteDatabase db) {
        insertAchievement("'Выспаться', 60, 0", db);
        insertAchievement("'Стать куратором первой группы', 400, 0", db);
        insertAchievement("'Не опоздать на пару', 600, 0", db);
        insertAchievement("'Выпустить бакалавров', 800, 0", db);
        insertAchievement("'Попасть на календарь КФУ', 1000, 0", db);
        insertAchievement("'Стать лучшим молодым преподавателем', 1500, 0", db);

    }

    private void insertAchievement(String values, SQLiteDatabase db) {
        String s = "insert into achievements(name, markers, achieved) values";
        db.execSQL(s + "(" + values + ")");
    }

    private void loadActions(SQLiteDatabase db) {
        insertAction("'Сказать \"брик\" вместо break', 0, 0, -10, 20", db);
        insertAction("'Выпить цикорий', 10, 10, 0, -10", db);
        insertAction("'Провести лекцию', -10, 0, 20, 40", db);
        insertAction("'Объяснить студентам старый мем', 0, 15, 15,-10", db);
        insertAction("'Задать проект', 0, 20, 0, -15", db);
        insertAction("'Перенести дедлайн', 25, 10, -5, -10", db);
        insertAction("'Проверить контрольную', -15, -15, 20, 30", db);
        insertAction("'Поспорить с Колей', 0, -10, 10, -15", db);
        insertAction("'Провести консультацию в ВК', 10, 0, -10, 10", db);
        insertAction("'Кинуть маркером', 10, 10, -10, -20", db);
        insertAction("'Спеть песню на музвечере', -20, 10, 25, 0", db);
        insertAction("'Провести презентацию проектов в один день с экзаменом', 10, 10, -30, 15", db);
        insertAction("'Провести пару на английском языке', -10, 5, 15, 10", db);
        insertAction("'Провести рефлекцию', 0, 10, 10, -5", db);
        insertAction("'Сфотографироваться со всеми выпускниками', 0, 10, 10, -5", db);
        insertAction("'Объяснить студентам разницу между \"программистом\" и \"разработчиком\"', 0, 0, 20, -10", db);

    }

    private void insertAction(String values, SQLiteDatabase db) {
        String s = "insert into actions(name, sleepPoints, moodPoints, authorityPoints, markerPoints) values";
        db.execSQL(s + "(" + values + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
