package com.example.simulatorabramskogo.activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.logic.Action;
import com.example.simulatorabramskogo.logic.Downloader;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ${Aina} on 12.07.2018.
 */
public class ListAdapter extends RecyclerView.Adapter{

    Downloader d = new Downloader();
    List<Action> tasks;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
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

        }

        public void bindView(int position){
            d.getListOfTasks();
            textView.setText(tasks.indexOf(position));
//            imageView.setImageResource();
        }
    }
}
