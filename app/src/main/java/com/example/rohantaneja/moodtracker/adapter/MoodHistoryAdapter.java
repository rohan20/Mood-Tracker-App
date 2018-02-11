package com.example.rohantaneja.moodtracker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rohantaneja.moodtracker.model.Mood;
import com.example.rohantaneja.moodtracker.adapter.viewholder.MoodHistoryViewHolder;
import com.example.rohantaneja.moodtracker.R;

import java.util.List;

/**
 * Created by rohantaneja on 10/02/18.
 */
public class MoodHistoryAdapter extends RecyclerView.Adapter<MoodHistoryViewHolder> {

    private Context context;
    private List<Mood> items;

    private double parentWidth;
    private double parentHeight;

    public MoodHistoryAdapter(List<Mood> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public void setParentDimensions(double parentWidth, double parentHeight) {
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;

        Log.e("parentDimensions", "Width: " + parentWidth + ", Height: " + parentHeight);
    }

    @Override
    public MoodHistoryViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mood_history_item, parent, false);
        return new MoodHistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MoodHistoryViewHolder holder, int position) {
        Mood moodItem = items.get(position);
        //todo pass parent dimensions to view holder
        holder.bindData(moodItem);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }
}