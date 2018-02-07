package com.example.rohantaneja.moodtracker;

import android.graphics.Point;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;

public class MoodHistoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);

        View view = findViewById(R.id.dummy_view);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                display.getRealSize(size);
            }
        } catch (NoSuchMethodError err) {
            display.getSize(size);
        }
        int width = size.x;
        int height = size.y;

        //setting view's width and height dynamically
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(width / 4, height / 2);
        view.setLayoutParams(layoutParams);
    }
}
