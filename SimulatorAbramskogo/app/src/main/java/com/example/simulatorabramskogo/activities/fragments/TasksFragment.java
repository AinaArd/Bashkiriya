package com.example.simulatorabramskogo.activities.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.activities.ListAdapter;
import com.example.simulatorabramskogo.logic.Action;
import com.example.simulatorabramskogo.logic.Downloader;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TasksFragment extends Fragment {

    Downloader downloader = new Downloader();
    List<Action> listOfTasks = downloader.getListOfTasks();
    RecyclerView recyclerView;
    public TasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tasks,container,false);
        recyclerView = view.findViewById(R.id.recycleView);

        ListAdapter listAdapter = new ListAdapter(listOfTasks);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

}
