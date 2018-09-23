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
import com.example.rohantaneja.moodtracker.model.Mood;
import com.example.rohantaneja.moodtracker.util.Constants;
import com.example.rohantaneja.moodtracker.util.SharedPreferenceUtils;

import java.util.ArrayList;

public class MoodHistoryActivity extends BaseActivity implements View.OnClickListener {

    private ConstraintLayout parentLayout;
    private RecyclerView moodsRecyclerView;

    private Button recordCurrentMoodButton;
    private TextView emptyStateTextView;
    private ImageView emptyStateImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);

        initUI();
    }

    private void initUI() {
        if (getActionBar() != null)
            getActionBar().setDisplayHomeAsUpEnabled(true);

        // TODO: 24/02/18 Reset the messages at midnight i.e. remove "7 days ago" message and update the rest

        parentLayout = findViewById(R.id.parent_layout);
        moodsRecyclerView = findViewById(R.id.rv_moods_of_the_week);

        recordCurrentMoodButton = findViewById(R.id.record_current_mood_button);
        emptyStateTextView = findViewById(R.id.empty_state_message_text_view);
        emptyStateImageView = findViewById(R.id.empty_state_icon_image_view);

        parentLayout.getViewTreeObserver().addOnGlobalLayoutListener(parentLayoutTreeObserver);

        recordCurrentMoodButton.setOnClickListener(this);
    }

    private ViewTreeObserver.OnGlobalLayoutListener parentLayoutTreeObserver = new ViewTreeObserver.OnGlobalLayoutListener() {
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
            moodHistoryAdapter.updateMoodsList(getMoodsFromSharedPreferences());
            moodHistoryAdapter.setParentDimensions(parentLayout.getMeasuredWidth(), parentLayout.getMeasuredHeight());
            parentLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.record_current_mood_button:
                finish();
                break;
        }
    }

    private ArrayList<Mood> getMoodsFromSharedPreferences() {
        ArrayList<Mood> moodsList = new ArrayList<>();

        SharedPreferenceUtils sharedPrefsUtil = SharedPreferenceUtils.getInstance(this);

        moodsList.add(new Mood(sharedPrefsUtil.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_0, 0), sharedPrefsUtil.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_0, null)));
        moodsList.add(new Mood(sharedPrefsUtil.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_1, 0), sharedPrefsUtil.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_1, null)));
        moodsList.add(new Mood(sharedPrefsUtil.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_2, 0), sharedPrefsUtil.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_2, null)));
        moodsList.add(new Mood(sharedPrefsUtil.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_3, 0), sharedPrefsUtil.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_3, null)));
        moodsList.add(new Mood(sharedPrefsUtil.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_4, 0), sharedPrefsUtil.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_4, null)));
        moodsList.add(new Mood(sharedPrefsUtil.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_5, 0), sharedPrefsUtil.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_5, null)));
        moodsList.add(new Mood(sharedPrefsUtil.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_6, 0), sharedPrefsUtil.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_6, null)));

        return moodsList;
    }

}
