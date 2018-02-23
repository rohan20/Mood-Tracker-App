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
import com.example.rohantaneja.moodtracker.ui.MoodHistoryActivity;

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
    }

    @Override
    public MoodHistoryViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mood_history_item, parent, false);

        MoodHistoryViewHolder viewHolder = new MoodHistoryViewHolder(v);
        viewHolder.setTotalItems(getItemCount());

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MoodHistoryViewHolder holder, int position) {
        Mood moodItem = items.get(position);
        holder.bindData(moodItem, parentHeight, parentWidth);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }
}