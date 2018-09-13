package com.example.rohantaneja.moodtracker.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohantaneja.moodtracker.BaseActivity;
import com.example.rohantaneja.moodtracker.R;
import com.example.rohantaneja.moodtracker.adapter.MoodHistoryAdapter;

public class MoodHistoryActivity extends BaseActivity {

    private RecyclerView moodsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);

        if (getActionBar() != null)
            getActionBar().setDisplayHomeAsUpEnabled(true);

        // TODO: 24/02/18 Reset the messages at midnight i.e. remove "7 days ago" message and update the rest

        moodsRecyclerView = findViewById(R.id.rv_moods_of_the_week);

        final Button recordCurrentMoodButton = findViewById(R.id.record_current_mood_button);
        final TextView emptyStateTextView = findViewById(R.id.empty_state_message_text_view);
        final ImageView emptyStateImageView = findViewById(R.id.empty_state_icon_image_view);

        final ConstraintLayout parentLayout = findViewById(R.id.parent_layout);

        parentLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                if (getMoodsList().size() == 0) {
                    moodsRecyclerView.setVisibility(View.GONE);
                } else {
                    parentLayout.setBackgroundColor(ContextCompat.getColor(MoodHistoryActivity.this, android.R.color.white));
                    recordCurrentMoodButton.setVisibility(View.GONE);
                    emptyStateTextView.setVisibility(View.GONE);
                    emptyStateImageView.setVisibility(View.GONE);
                }

                MoodHistoryAdapter moodHistoryAdapter = new MoodHistoryAdapter(MoodHistoryActivity.this);
                moodsRecyclerView.setAdapter(moodHistoryAdapter);
                moodHistoryAdapter.updateMoodsList(getMoodsList());
                moodHistoryAdapter.setParentDimensions(parentLayout.getMeasuredWidth(), parentLayout.getMeasuredHeight());
                parentLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        recordCurrentMoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
