package com.example.rohantaneja.moodtracker.adapter.viewholder;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.rohantaneja.moodtracker.R;
import com.example.rohantaneja.moodtracker.model.Mood;

/**
 * Created by rohantaneja on 10/02/18.
 */

public class MoodHistoryViewHolder extends RecyclerView.ViewHolder {

    private View moodBackgroundView;
    private ConstraintLayout parentConstraintLayout;

    public MoodHistoryViewHolder(View itemView) {
        super(itemView);
        parentConstraintLayout = itemView.findViewById(R.id.parent_constraint_layout);
        moodBackgroundView = itemView.findViewById(R.id.mood_background_view);
    }

    public void bindData(Mood mood, double parentHeight, double parentWidth) {
        //todo set layout parents of each item according to the parent's width and mood of the item
        parentConstraintLayout.setLayoutParams(new ConstraintLayout.LayoutParams((int) parentWidth / 2, (int) parentHeight / 2));
    }
}
