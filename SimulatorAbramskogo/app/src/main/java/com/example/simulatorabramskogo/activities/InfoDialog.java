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


    TextView sleepPoints;
    TextView moodPoints;
    TextView authorityPoints;
    TextView markerPoints;

    private int sleepP;
    private int moodP;
    private int authorityP;
    private int markersP;

    public void setSleepP(int sleepP) {
        this.sleepP = sleepP;
    }

    public void setMoodP(int moodP) {
        this.moodP = moodP;
    }

    public void setAuthorityP(int authorityP) {
        this.authorityP = authorityP;
    }

    public void setMarkersP(int markersP) {
        this.markersP = markersP;
    }

    public TextView getSleep() {
        return sleep;
    }

    public TextView getMood() {
        return mood;
    }

    public TextView getAuthority() {
        return authority;
    }

    public TextView getMarkers() {
        return markers;
    }

    public TextView getSleepPoints() {
        return sleepPoints;
    }

    public TextView getMoodPoints() {
        return moodPoints;
    }

    public TextView getAuthorityPoints() {
        return authorityPoints;
    }

    public TextView getMarkerPoints() {
        return markerPoints;
    }

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
        sleepPoints.setText(sleepP+"");
        moodPoints = view.findViewById(R.id.textViewMoodPoints);
        authorityPoints = view.findViewById(R.id.textViewAuthorityPoints);
        markerPoints = view.findViewById(R.id.textViewMarkerPoints);


        adb.setTitle("Подробнее").setView(view)
                .setPositiveButton("Взять", (dialog, which) -> {
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
