package com.example.simulatorabramskogo.activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.logic.Action;

import java.util.List;

/**
 * Created by ${Aina} on 12.07.2018.
 */
public class TaskAdapter extends RecyclerView.Adapter implements MyListener, View.OnClickListener{

    TaskDialogInterface tasksListener;
    List<Action> tasks;

    public TaskAdapter(TaskDialogInterface tasksListener, List<Action> tasks) {
        this.tasksListener = tasksListener;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_task,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @Override
    public void mListener() {}

    @Override
    public void onClick(View v) {
        tasksListener.show();
    }

    public interface TaskDialogInterface {
        void show();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;
        private ImageView imageView;

        public ListViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.textView1);
            imageView = itemView.findViewById(R.id.imageView1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // TODO what happens after clicking on a task?



        }

        public void bindView(int position){
            textView.setText(getTaskById(position).getName());
        }

        public Action getTaskById(int id){
            for(Action action : tasks){
                if (action.getId() - 1 == id) {
                    return action;
                }
            }
            return new Action(-1, "null", 0, 0, 0, 0);
        }
    }
}
