package com.example.rohantaneja.moodtracker;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    ImageButton ibMoodMessage;
    ImageButton ibMoodHistory;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibMoodMessage = findViewById(R.id.ib_mood_message);
        ibMoodHistory = findViewById(R.id.ib_mood_history);
        viewPager = findViewById(R.id.viewpager_mood);

        viewPager.setAdapter(new MoodPagerAdapter(getSupportFragmentManager()));
        //set default mood to happy
        viewPager.setCurrentItem(3);

        ibMoodMessage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_mood_message:
                addMoodMessage();
                break;

            case R.id.ib_mood_history:

                break;
        }
    }

    private void addMoodMessage() {
        showToast(getString(R.string.add_mood_message));
        //create alert for adding message
        showAlertToAddMessage();
    }

    private void showAlertToAddMessage() {

        //create custom layout with editText for mood message
        //postiive button = Set Mood
        //negative button = Cancel
        //if empty mood message, proceed with empty message

    }
}
