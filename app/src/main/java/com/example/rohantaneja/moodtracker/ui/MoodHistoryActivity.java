package com.example.rohantaneja.moodtracker.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.ViewTreeObserver;

import com.example.rohantaneja.moodtracker.BaseActivity;
import com.example.rohantaneja.moodtracker.R;
import com.example.rohantaneja.moodtracker.adapter.MoodHistoryAdapter;
import com.example.rohantaneja.moodtracker.model.Mood;

import java.util.ArrayList;

public class MoodHistoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);

        final ConstraintLayout parentLayout = findViewById(R.id.parent_layout);

        ViewTreeObserver viewTreeObserver = parentLayout.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                MoodHistoryAdapter moodHistoryAdapter = new MoodHistoryAdapter(new ArrayList<Mood>(), MoodHistoryActivity.this);
                moodHistoryAdapter.setParentDimensions(parentLayout.getMeasuredWidth(), parentLayout.getMeasuredHeight());
            }
        });

    }
}
