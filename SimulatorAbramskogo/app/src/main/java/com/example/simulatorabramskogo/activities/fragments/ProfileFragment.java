package com.example.simulatorabramskogo.activities.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.activities.GameOverDialog;
import com.example.simulatorabramskogo.logic.Abramskiy;
import com.example.simulatorabramskogo.logic.Observer;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements Observer {
    ImageView profilePicAdr;
    TextView sleep;
    TextView mood;
    TextView authority;

    TextView markers;
    ProgressBar progressBarSleep;
    ProgressBar progressBarMood;
    ProgressBar progressBarAuthority;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        sleep = view.findViewById(R.id.textViewSleep);
        mood = view.findViewById(R.id.textViewMood);
        authority = view.findViewById(R.id.textViewAuthority);

        markers = view.findViewById(R.id.textViewMarkers);


        progressBarSleep = (ProgressBar) view.findViewById(R.id.progressBarSleep);
        progressBarMood = (ProgressBar) view.findViewById(R.id.progressBarMood);
        progressBarAuthority = (ProgressBar) view.findViewById(R.id.progressBarAuthority);
        profilePicAdr = view.findViewById(R.id.imageViewAbr);

        update( Abramskiy.getInstance().getSleep(), Abramskiy.getInstance().getMood(), Abramskiy.getInstance().getAuthority(), Abramskiy.getInstance().getMarkers());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        update(Abramskiy.getInstance().getSleep(), Abramskiy.getInstance().getMood(), Abramskiy.getInstance().getAuthority(), Abramskiy.getInstance().getMarkers());

    }

    @Override
    public void update(Integer sleep, Integer mood, Integer authority, Integer markers) {
        this.markers.setText(String.valueOf(markers));
        checkProgressBars();
        progressBarSleep.setProgress(sleep);
        progressBarMood.setProgress(mood);
        progressBarAuthority.setProgress(authority);
    }



    public void checkProgressBars(){
        if(progressBarSleep.getProgress() > 100 || progressBarMood.getProgress() > 100 || progressBarAuthority.getProgress() > 100){
            progressBarSleep.setProgress(100);
            progressBarMood.setProgress(100);
            progressBarAuthority.setProgress(100);
        }
    }
}
