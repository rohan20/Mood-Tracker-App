package com.example.rohantaneja.moodtracker.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewTreeObserver;

import com.example.rohantaneja.moodtracker.BaseActivity;
import com.example.rohantaneja.moodtracker.R;

public class MoodHistoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);

        final View view = findViewById(R.id.dummy_view);
        final ConstraintLayout parentLayout = findViewById(R.id.parent_layout);

        ViewTreeObserver viewTreeObserver = parentLayout.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //setting view's width and height dynamically
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(parentLayout.getMeasuredWidth() / 4, parentLayout.getMeasuredHeight() / 7);
                view.setLayoutParams(layoutParams);
            }
        });
    }
}
