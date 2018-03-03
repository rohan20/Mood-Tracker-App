package com.example.rohantaneja.moodtracker.adapter.viewholder;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohantaneja.moodtracker.R;
import com.example.rohantaneja.moodtracker.model.Mood;
import com.example.rohantaneja.moodtracker.util.Constants;

/**
 * Created by rohantaneja on 10/02/18.
 */

public class MoodHistoryViewHolder extends RecyclerView.ViewHolder {

    private View moodBackgroundView;
    private TextView moodDayTextView;
    private ImageButton moodMessageImageButton;
    private int numOfMoods;
    private Context context;

    public MoodHistoryViewHolder(View itemView, int numOfMoods) {
        super(itemView);
        moodBackgroundView = itemView.findViewById(R.id.mood_background_view);
        moodDayTextView = itemView.findViewById(R.id.day_text_view);
        moodMessageImageButton = itemView.findViewById(R.id.message_image_button);
        this.numOfMoods = numOfMoods;
    }

    public void bindData(Context context, int moodItemPosition, final Mood mood, double parentHeight, double parentWidth) {
        this.context = context;

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
        moodBackgroundView.setLayoutParams(new ConstraintLayout.LayoutParams((int) (parentWidth * moodWidthMultiplier), (int) parentHeight / numOfMoods));

        String moodDayText = "";

        //set mood date
        switch (moodItemPosition) {
            case 0:
                moodDayText = "Today";
                break;

            case 1:
                moodDayText = "One day ago";
                break;

            case 2:
                moodDayText = "Two days ago";
                break;

            case 3:
                moodDayText = "Three days ago";
                break;

            case 4:
                moodDayText = "Four days ago";
                break;

            case 5:
                moodDayText = "Five days ago";
                break;

            case 6:
                moodDayText = "Six days ago";
                break;

        }

        moodDayTextView.setText(moodDayText);

        if (mood.getMoodMessage().isEmpty()) {
            moodMessageImageButton.setVisibility(View.GONE);
        } else {
            moodMessageImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(moodMessageImageButton, mood.getMoodName() + ": " + mood.getMoodMessage(), Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }
}
