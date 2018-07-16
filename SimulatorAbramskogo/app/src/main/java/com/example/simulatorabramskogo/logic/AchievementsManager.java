package com.example.simulatorabramskogo.logic;

import java.util.ArrayList;
import java.util.List;

public class AchievementsManager implements Observer {
    private Abramskiy abramskiy;
    private List<Achievement> achievements;
    private Achievement currentAchievement;
    private Achievement nextAchievement;

    public AchievementsManager(Abramskiy abramskiy) {
        this.abramskiy = abramskiy;
        achievements = new ArrayList<>();
        achievements.add(new Achievement(1, "name", 1));
        currentAchievement = achievements.get(0);
        nextAchievement = achievements.get(0);
    }

    @Override
    public void update(Integer sleep, Integer mood, Integer authority, Integer markers) {
        if (abramskiy.getMarkers() >= nextAchievement.getMarkers()) {
            currentAchievement = nextAchievement;
            nextAchievement = getNextAchievement();
            //TODO dialog about next achievement
            System.out.println("You achieved: " + currentAchievement.getName());
            if (nextAchievement == null) {
                //TODO dialog about winning
            }
        }
    }

    public Achievement getNextAchievement() {
        for (Achievement achievement : achievements) {
            if (achievement.getId() == currentAchievement.getId() + 1) {
                return achievement;
            }
        }
        return null;
    }

    public Achievement getCurrentAchievement() {
        return currentAchievement;
    }
}
