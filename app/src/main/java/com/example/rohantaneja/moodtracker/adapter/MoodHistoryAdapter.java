package com.example.rohantaneja.moodtracker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rohantaneja.moodtracker.R;
import com.example.rohantaneja.moodtracker.adapter.viewholder.MoodHistoryViewHolder;
import com.example.rohantaneja.moodtracker.model.Mood;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohantaneja on 10/02/18.
 */
public class MoodHistoryAdapter extends RecyclerView.Adapter<MoodHistoryViewHolder> {

    private Context context;
    private List<Mood> moodsList;

    private double parentWidth;
    private double parentHeight;

    public MoodHistoryAdapter(Context context) {
        this.context = context;
    }

    public void updateMoodsList(ArrayList<Mood> moodsList) {
        this.moodsList = moodsList;
        notifyDataSetChanged();
    }

    public void setParentDimensions(double parentWidth, double parentHeight) {
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;
    }

    @Override
    public MoodHistoryViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mood_history_item, parent, false);

        return new MoodHistoryViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(MoodHistoryViewHolder holder, int position) {
        holder.bindData(position, moodsList.get(position), parentHeight, parentWidth);
    }

    @Override
    public int getItemCount() {
        return moodsList == null ? 0 : moodsList.size();
    }
}