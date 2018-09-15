package com.example.rohantaneja.moodtracker.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.rohantaneja.moodtracker.BaseActivity;
import com.example.rohantaneja.moodtracker.adapter.MoodPagerAdapter;
import com.example.rohantaneja.moodtracker.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    ImageButton ibMoodMessage;
    ImageButton ibMoodHistory;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 05/03/18 Show coach marks for add mood and view mood history for the first time

        ibMoodMessage = findViewById(R.id.ib_mood_message);
        ibMoodHistory = findViewById(R.id.ib_mood_history);
        viewPager = findViewById(R.id.viewpager_mood);

        viewPager.setAdapter(new MoodPagerAdapter(MainActivity.this, getSupportFragmentManager()));
        //set default mood to happy
        viewPager.setCurrentItem(3);

        ibMoodMessage.setOnClickListener(this);
        ibMoodHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_mood_message:
                addMoodMessage();
                break;

            case R.id.ib_mood_history:
                viewMoodHistory();
                break;
        }
    }

    private void viewMoodHistory() {
        // TODO: 06/03/18 Add transition while launching mood history activity
        Intent i = new Intent(this, MoodHistoryActivity.class);
        startActivity(i);
    }

    private void addMoodMessage() {
        // TODO: 24/02/18 Implement this method and save the message in SharedPrefs or use an ORM
        // TODO: 04/03/18 Add default mood message for no mood selected for today
        //create alert for adding message
        showAlertToAddMessage();
    }

    private void showAlertToAddMessage() {

        //create custom layout with editText for mood message
        //positive button = Set Mood
        //negative button = Cancel
        //if empty mood message, proceed with empty message

        EditText inputEditText = new EditText(MainActivity.this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        inputEditText.setHint("Enter mood message");
        //add margins to EditText
        inputEditText.setLayoutParams(layoutParams);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Mood selected: " + getMoodNameFromMoodId(viewPager.getCurrentItem()))
                .setView(inputEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO: 05/03/18 Show coach marks on set mood button when the user navigates back from an empty mood history screen
    }
}
