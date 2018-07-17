package com.example.simulatorabramskogo.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.logic.Abramskiy;

/**
 * Created by ${Aina} on 16.07.2018.
 */
public class GameOverDialog extends DialogFragment {
    public android.app.Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        super.onCreateDialog(saveInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_game_over, null);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());

        adb.setTitle("Ты проиграл!").setMessage("Не хочешь попробовать еще раз?").
                setView(view)
                .setPositiveButton("Да! Я еще отыграюсь!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO обнулить все показатели, откатиться к началу
                        Abramskiy abramskiy = new Abramskiy();

                    }
                })
                .setNegativeButton("Нет...Я в печали", (dialog, which) -> dismiss());
        return adb.show();
    }
}
