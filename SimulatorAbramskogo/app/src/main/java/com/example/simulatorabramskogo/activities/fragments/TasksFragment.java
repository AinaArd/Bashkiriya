package com.example.simulatorabramskogo.activities.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.activities.GameOverDialog;
import com.example.simulatorabramskogo.activities.InfoDialog;
import com.example.simulatorabramskogo.activities.TaskAdapter;
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

    public TasksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        listOfTasks = (new Downloader()).getListOfActions();

        View view = inflater.inflate(R.layout.fragment_tasks,container,false);
        recyclerView = view.findViewById(R.id.recycleView);

        TaskAdapter taskAdapter = new TaskAdapter(this, listOfTasks);
        recyclerView.setAdapter(taskAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        checkIfGameIsOver();

        return view;
    }

    public Action getTaskById(int id) {
        for (Action action : listOfTasks) {
            if (action.getId() - 1 == id) {
                return action;
            }
        }
        return new Action(-1, "null", 0, 0, 0, 0);
    }

    @Override
    public void show(int id) {
        InfoDialog infoDialog = new InfoDialog();
        infoDialog.setAction(getTaskById(id));
        infoDialog.show(getFragmentManager(), "info");
    }

    public void checkIfGameIsOver(){
        if(Abramskiy.getInstance().getSleep() == 0 || Abramskiy.getInstance().getMood() == 0 || Abramskiy.getInstance().getAuthority() == 0 || Abramskiy.getInstance().getMarkers() == 0){
            GameOverDialog gameOverDialog = new GameOverDialog();
            gameOverDialog.show(getFragmentManager(),"game over");
        }
    }
}
