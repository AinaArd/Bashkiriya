package com.example.simulatorabramskogo.logic;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.simulatorabramskogo.R;

/**
 * Created by ${Aina} on 16.07.2018.
 */
public class AchievementDialog extends DialogFragment {
    public android.app.Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        super.onCreateDialog(saveInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_achievement,null);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());

        adb.setView(view)
                .setPositiveButton("Классно!", (dialog, which) -> dismiss());
        return adb.show();
    }
}
