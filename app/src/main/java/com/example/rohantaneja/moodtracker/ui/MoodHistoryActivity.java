package com.example.rohantaneja.moodtracker.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewTreeObserver;

import com.example.rohantaneja.moodtracker.BaseActivity;
import com.example.rohantaneja.moodtracker.R;
import com.example.rohantaneja.moodtracker.adapter.MoodHistoryAdapter;

public class MoodHistoryActivity extends BaseActivity {

    private RecyclerView moodsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);

        moodsRecyclerView = findViewById(R.id.rv_moods_of_the_week);
        final ConstraintLayout parentLayout = findViewById(R.id.parent_layout);

        parentLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                MoodHistoryAdapter moodHistoryAdapter = new MoodHistoryAdapter(getMoodsList(), MoodHistoryActivity.this);
                moodsRecyclerView.setAdapter(moodHistoryAdapter);
                moodHistoryAdapter.setParentDimensions(parentLayout.getMeasuredWidth(), parentLayout.getMeasuredHeight());
                parentLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

}
