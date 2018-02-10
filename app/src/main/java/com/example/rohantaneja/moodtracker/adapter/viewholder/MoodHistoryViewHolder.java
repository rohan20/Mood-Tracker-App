package com.example.rohantaneja.moodtracker.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.rohantaneja.moodtracker.R;
import com.example.rohantaneja.moodtracker.model.Mood;

/**
 * Created by rohantaneja on 10/02/18.
 */

public class MoodHistoryViewHolder extends RecyclerView.ViewHolder {

    private View moodBackgroundView;

    public MoodHistoryViewHolder(View itemView) {
        super(itemView);
        moodBackgroundView = itemView.findViewById(R.id.mood_background_view);
    }

    public void bindData(Mood mood) {

    }
}
