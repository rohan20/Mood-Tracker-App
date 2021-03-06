package com.example.rohantaneja.moodtracker.adapter.viewholder;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.rohantaneja.moodtracker.BaseActivity;
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
    private Context context;

    public MoodHistoryViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        moodBackgroundView = itemView.findViewById(R.id.mood_background_view);
        moodDayTextView = itemView.findViewById(R.id.day_text_view);
        moodMessageImageButton = itemView.findViewById(R.id.message_image_button);
    }

    public void bindData(int position, Mood mood, double parentHeight, double parentWidth) {

        int moodId = mood.getMoodId();

        double moodWidthMultiplier = (((BaseActivity) context).getMoodWidthMultiplierFromMoodId(moodId));
        moodBackgroundView.setBackgroundResource(((BaseActivity) context).getMoodColorIdFromMoodId(moodId));
        moodBackgroundView.setLayoutParams(new ConstraintLayout.LayoutParams((int) (parentWidth * moodWidthMultiplier), (int) parentHeight / Constants.NUMBER_OF_DAYS));

        //set mood date
        String dayText = context.getString(((BaseActivity) context).getDayTextIdFromIndex(position));
        moodDayTextView.setText(dayText);

        //set mood message
        if (mood.getMoodMessage() == null) {
            moodMessageImageButton.setVisibility(View.GONE);
        } else {

            final String snackbarMoodText = ((BaseActivity) context).getMoodNameFromMoodId(moodId) + ": " + mood.getMoodMessage();

            moodMessageImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(moodMessageImageButton, snackbarMoodText, Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }
}
