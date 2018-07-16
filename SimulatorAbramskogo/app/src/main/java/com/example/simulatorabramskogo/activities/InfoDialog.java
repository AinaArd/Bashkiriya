package com.example.simulatorabramskogo.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.logic.Abramskiy;
import com.example.simulatorabramskogo.logic.AchievementsManager;
import com.example.simulatorabramskogo.logic.Action;

/**
 * Created by ${Aina} on 15.07.2018.
 */
public class InfoDialog extends DialogFragment {

    //    MyListener listener;
    TextView sleep;
    TextView mood;
    TextView authority;
    TextView markers;
    Action action;


    public void setAction(Action action) {
        this.action = action;
    }

    TextView sleepPoints;
    TextView moodPoints;
    TextView authorityPoints;
    TextView markerPoints;


    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_info, null);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        sleep = view.findViewById(R.id.textViewSleep1);
        mood = view.findViewById(R.id.textViewMood1);
        authority = view.findViewById(R.id.textViewAuthority1);
        markers = view.findViewById(R.id.textViewMarkers1);

        sleepPoints = view.findViewById(R.id.textViewSleepPoints);
        sleepPoints.setText(action.getSleepPoints()+"");
        moodPoints = view.findViewById(R.id.textViewMoodPoints);
        moodPoints.setText(action.getMoodPoints()+"");
        authorityPoints = view.findViewById(R.id.textViewAuthorityPoints);
        authorityPoints.setText(action.getAuthorityPoints()+"");
        markerPoints = view.findViewById(R.id.textViewMarkerPoints);
        markerPoints.setText(action.getMarkerPoints()+"");


        adb.setTitle("Подробнее").setView(view)
                .setPositiveButton("Взять", (dialog, which) -> {
                            action.perform();
                        }
                ).setNegativeButton("Не брать", (dialog, which) -> {
            dismiss();
        });
        return adb.create();

    }

//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof StartActivity) {
//            listener = (MyListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragment1DataListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        listener = null;
//    }
//
//    public void show(FragmentManager fragmentManager, String dialog) {
//    }
}
