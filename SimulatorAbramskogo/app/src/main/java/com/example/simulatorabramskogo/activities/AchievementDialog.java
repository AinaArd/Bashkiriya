package com.example.simulatorabramskogo.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.logic.Achievement;

/**
 * Created by ${Aina} on 16.07.2018.
 */
public class AchievementDialog extends DialogFragment {

    Achievement achievement;
    TextView markers;
    TextView congrats;

    public android.app.Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        super.onCreateDialog(saveInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_achievement,null);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        markers = view.findViewById(R.id.markersText);
        markers.setText(String.valueOf(achievement.getMarkers()));
        congrats = view.findViewById(R.id.congrats);
        congrats.setText(achievement.getName());
        adb.setTitle("Новое достижение!")
                .setView(view)
                .setPositiveButton("Ok", (dialog, which) -> dismiss());
        return adb.show();
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }
}
