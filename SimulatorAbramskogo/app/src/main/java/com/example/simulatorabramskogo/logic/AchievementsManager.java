package com.example.simulatorabramskogo.logic;

import java.util.LinkedList;
import java.util.List;

public class AchievementsManager implements Observer {
    private Abramskiy abramskiy;
    private List<Achievement> achievemets;
    private Achievement currentAchievement;
    private Achievement nextAchievement;

    public AchievementsManager(Abramskiy abramskiy) {
        this.abramskiy = abramskiy;
        achievemets = new LinkedList<>();
        loadAchievements();

        achievemets.add(new Achievement(1, "a1", 30));
        achievemets.add(new Achievement(2, "a2", 50));

        nextAchievement = achievemets.get(0);
    }

    private void loadAchievements() {
        //TODO loading list of achievements from txt
    }

    @Override
    public void update() {
        if (abramskiy.getMarkers() >= nextAchievement.getMarkers()) {
            currentAchievement = nextAchievement;
            nextAchievement = getNextAchievement();
            System.out.println("You achieved: " + currentAchievement.getName());
            if (nextAchievement == null) {
                System.out.println("YOU WIN!");
            }
        }
    }

    private Achievement getNextAchievement() {
        for (Achievement achievement: achievemets) {
            if (achievement.getId() == currentAchievement.getId() + 1) {
                return achievement;
            }
        }
        return null;
    }
}
