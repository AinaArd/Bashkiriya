package com.example.simulatorabramskogo.activities.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.activities.InfoDialog;












import com.example.simulatorabramskogo.activities.TaskAdapter;
import com.example.simulatorabramskogo.database.DBHelper;
import com.example.simulatorabramskogo.database.Downloader;
import com.example.simulatorabramskogo.logic.Abramskiy;
import com.example.simulatorabramskogo.logic.Action;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TasksFragment extends Fragment implements TaskAdapter.TaskDialogInterface{
    List<Action> listOfTasks;
    RecyclerView recyclerView;
    TaskAdapter.TaskDialogInterface taskDialogInterface;

    public TasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        listOfTasks = (new Downloader(this.getContext())).getListOfActions();

        View view = inflater.inflate(R.layout.fragment_tasks,container,false);
        recyclerView = view.findViewById(R.id.recycleView);

        TaskAdapter taskAdapter = new TaskAdapter(taskDialogInterface, listOfTasks);
        recyclerView.setAdapter(taskAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void show() {
        InfoDialog infoDialog = (InfoDialog) InfoDialog.instantiate(getActivity(),"InfoDialog");
        infoDialog.show(getFragmentManager(), "dialog");
    }
}
