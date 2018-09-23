package com.example.rohantaneja.moodtracker.ui;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.rohantaneja.moodtracker.BaseActivity;
import com.example.rohantaneja.moodtracker.R;
import com.example.rohantaneja.moodtracker.adapter.MoodPagerAdapter;
import com.example.rohantaneja.moodtracker.adapter.receiver.AlarmReceiver;
import com.example.rohantaneja.moodtracker.util.Constants;
import com.example.rohantaneja.moodtracker.util.SharedPreferenceUtils;

import java.util.Calendar;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    ImageButton ibMoodMessage;
    ImageButton ibMoodHistory;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 05/03/18 Show coach marks for add mood and view mood history for the first time

        initUI();
        initMoodHistory();
    }

    private void initUI() {
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
                prepareDialogForMoodMessage();
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

    private void prepareDialogForMoodMessage() {
        //Create input edit text and container linear layout for margins
        EditText inputEditText = new EditText(MainActivity.this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        layoutParams.topMargin = 16;
        layoutParams.leftMargin = 48;
        layoutParams.rightMargin = 48;

        inputEditText.setHint("Enter mood message");
        inputEditText.setLayoutParams(layoutParams);

        LinearLayout inputLinearLayout = new LinearLayout(this);
        inputLinearLayout.addView(inputEditText);

        showDialogForMoodMessage(inputLinearLayout, inputEditText);
    }

    private void showDialogForMoodMessage(LinearLayout inputLayout, final EditText inputEditText) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Mood selected: " + getMoodNameFromMoodId(viewPager.getCurrentItem()))
                .setView(inputLayout)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        saveMoodMessage(inputEditText.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private void saveMoodMessage(String moodMessage) {
        SharedPreferenceUtils sharedPrefsUtil = SharedPreferenceUtils.getInstance(this);
        sharedPrefsUtil.setValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_0, moodMessage);
        sharedPrefsUtil.setValue(Constants.PREFS_MOOD_ID.KEY_DAY_0, viewPager.getCurrentItem());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO: 05/03/18 Show coach marks on set mood button when the user navigates back from an empty mood history screen
    }

    private void initMoodHistory() {
        initAlarmManager();
    }

    private void initAlarmManager() {

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent alarmPendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 58);

        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmPendingIntent);
        }
    }

}
