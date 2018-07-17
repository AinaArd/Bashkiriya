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

        checkIfGameIsOver();

        return view;
    }

    @Override
    public void update(Integer sleep, Integer mood, Integer authority, Integer markers) {
        this.markers.setText(String.valueOf(markers));
        progressBarSleep.setProgress(sleep);
        progressBarMood.setProgress(mood);
        progressBarAuthority.setProgress(authority);
    }

    public void checkIfGameIsOver(){
        if(Abramskiy.getInstance().getSleep() == 0 || Abramskiy.getInstance().getMood() == 0 || Abramskiy.getInstance().getAuthority() == 0 || Abramskiy.getInstance().getMarkers() == 0){
            GameOverDialog gameOverDialog = new GameOverDialog();
            gameOverDialog.show(getFragmentManager(),"game over");
        }
    }
}
