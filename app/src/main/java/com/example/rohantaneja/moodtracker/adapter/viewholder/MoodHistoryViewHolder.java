package com.example.rohantaneja.moodtracker.adapter.viewholder;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.rohantaneja.moodtracker.R;
import com.example.rohantaneja.moodtracker.model.Mood;
import com.example.rohantaneja.moodtracker.util.Constants;

/**
 * Created by rohantaneja on 10/02/18.
 */

public class MoodHistoryViewHolder extends RecyclerView.ViewHolder {

    private View moodBackgroundView;

    public MoodHistoryViewHolder(View itemView) {
        super(itemView);
        moodBackgroundView = itemView.findViewById(R.id.mood_background_view);
    }

    public void bindData(Mood mood, double parentHeight, double parentWidth) {
        //todo set layout parents of each item according to the parent's width and mood of the item

        int moodColor = 0;
        double moodWidthMultiplier = 0;

        switch (mood.getMoodId()) {
            case Constants.MOOD_ID_SAD:
                moodColor = Constants.MOOD_COLOR_SAD;
                moodWidthMultiplier = Constants.MOOD_SAD_MULTIPLIER;
                break;

            case Constants.MOOD_ID_DISAPPOINTED:
                moodColor = Constants.MOOD_COLOR_DISAPPOINTED;
                moodWidthMultiplier = Constants.MOOD_DISAPPOINTED_MULTIPLIER;
                break;

            case Constants.MOOD_ID_NORMAL:
                moodColor = Constants.MOOD_COLOR_NORMAL;
                moodWidthMultiplier = Constants.MOOD_NORMAL_MULTIPLIER;
                break;

            case Constants.MOOD_ID_HAPPY:
                moodColor = Constants.MOOD_COLOR_HAPPY;
                moodWidthMultiplier = Constants.MOOD_HAPPY_MULTIPLIER;
                break;

            case Constants.MOOD_ID_SUPER_HAPPY:
                moodColor = Constants.MOOD_COLOR_SUPER_HAPPY;
                moodWidthMultiplier = Constants.MOOD_SUPER_HAPPY_MULTIPLIER;
                break;
        }

        moodBackgroundView.setBackgroundResource(moodColor);
        moodBackgroundView.setLayoutParams(new ConstraintLayout.LayoutParams((int) (parentWidth * moodWidthMultiplier), (int) parentHeight / Constants.NUMBER_OF_MOODS));
    }
}
