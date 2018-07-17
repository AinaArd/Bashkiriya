package com.example.simulatorabramskogo.activities.fragments;

import java.util.List;
import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.database.Downloader;
import com.example.simulatorabramskogo.logic.Abramskiy;
import com.example.simulatorabramskogo.logic.Achievement;
import com.example.simulatorabramskogo.logic.AchievementsManager;

import java.util.Random;

public class PageFragment extends Fragment {
    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    AchievementsManager manager;
    Achievement next;
    TextView textAch;
    ImageView imageView;
    TextView status;
    TextView pointsLeft;
    int pageNumber;

    public static Fragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, null);
        manager = AchievementsManager.getInstance();
        next = manager.getAchievements().get(pageNumber);

        textAch = (TextView) view.findViewById(R.id.textAch);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        status = (TextView) view.findViewById(R.id.textStatus);
        pointsLeft = (TextView) view.findViewById(R.id.textPointsLeft);

        textAch.setText(next.getName());
        pointsLeft.setText("Чтобы получить достижение, наберите еще " + (next.getMarkers() - Abramskiy.getInstance().getMarkers()) + " фломастеров");


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        next = manager.getAchievements().get(pageNumber);
        if (Abramskiy.getInstance().getMarkers()>=next.getMarkers()) next.setAchieved(true);
        update();
    }

    public void update() {
        if (next.getStatus()) {

            imageView.setImageResource(R.drawable.ach_1);
            status.setText("Достигнуто!");
            pointsLeft.setText("");
        } else {
            pointsLeft.setText("Чтобы получить достижение, наберите еще " + (next.getMarkers() - Abramskiy.getInstance().getMarkers()) + " фломастеров");
        }
    }
}
