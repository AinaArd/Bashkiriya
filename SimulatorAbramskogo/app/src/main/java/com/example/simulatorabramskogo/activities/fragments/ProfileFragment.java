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
import com.example.simulatorabramskogo.logic.Abramskiy;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    private Abramskiy abramskiy;
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

        abramskiy = Abramskiy.getInstance();
        sleep = view.findViewById(R.id.textViewSleep);
        mood = view.findViewById(R.id.textViewMood);
        authority = view.findViewById(R.id.textViewAuthority);

        markers = view.findViewById(R.id.textViewMarkers);
        markers.setText(String.valueOf(abramskiy.getMarkers()));

        progressBarSleep = (ProgressBar) view.findViewById(R.id.progressBarSleep);
        progressBarSleep.setProgress(abramskiy.getSleep());

        progressBarMood = (ProgressBar) view.findViewById(R.id.progressBarMood);
        progressBarMood.setProgress(abramskiy.getMood());

        progressBarAuthority = (ProgressBar) view.findViewById(R.id.progressBarAuthority);
        progressBarAuthority.setProgress(abramskiy.getAuthority());

        profilePicAdr = view.findViewById(R.id.imageViewAbr);

        return view;
    }

}
