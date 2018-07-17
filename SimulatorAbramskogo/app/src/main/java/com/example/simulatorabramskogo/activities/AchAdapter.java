package com.example.simulatorabramskogo.activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.logic.Achievement;

import java.util.List;

/**
 * Created by ${Aina} on 13.07.2018.
 */
public class AchAdapter extends RecyclerView.Adapter {
    List<Achievement> achievements;

    public AchAdapter(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ach,parent,false);
        return new AchAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((AchAdapter.ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return achievements.size();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;

        public ListViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.textViewAch);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // TODO what happens after clicking on achievement?
        }

        public void bindView(int position){
            textView.setText(getAchievementById(position).getName());
        }

        public Achievement getAchievementById(int id){
            for(Achievement achievement : achievements){
                if (achievement.getId()- 1 == id) {
                    return achievement;
                }
            }
            return new Achievement(-1, "null", 0, false);
        }
    }
}
