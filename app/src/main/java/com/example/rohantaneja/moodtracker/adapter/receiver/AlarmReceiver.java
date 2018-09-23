package com.example.rohantaneja.moodtracker.adapter.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.rohantaneja.moodtracker.util.Constants;
import com.example.rohantaneja.moodtracker.util.SharedPreferenceUtils;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferenceUtils prefsUtils = SharedPreferenceUtils.getInstance(context);

        //fetch latest values from shared preferences
        int colorDay0 = prefsUtils.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_0, Constants.PREFS_MOOD_ID.KEY_DEFAULT);
        int colorDay1 = prefsUtils.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_1, Constants.PREFS_MOOD_ID.KEY_DEFAULT);
        int colorDay2 = prefsUtils.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_2, Constants.PREFS_MOOD_ID.KEY_DEFAULT);
        int colorDay3 = prefsUtils.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_3, Constants.PREFS_MOOD_ID.KEY_DEFAULT);
        int colorDay4 = prefsUtils.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_4, Constants.PREFS_MOOD_ID.KEY_DEFAULT);
        int colorDay5 = prefsUtils.getIntValue(Constants.PREFS_MOOD_ID.KEY_DAY_5, Constants.PREFS_MOOD_ID.KEY_DEFAULT);

        String messageDay0 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_0, Constants.PREFS_MOOD_MESSAGE.KEY_DEFAULT);
        String messageDay1 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_1, Constants.PREFS_MOOD_MESSAGE.KEY_DEFAULT);
        String messageDay2 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_2, Constants.PREFS_MOOD_MESSAGE.KEY_DEFAULT);
        String messageDay3 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_3, Constants.PREFS_MOOD_MESSAGE.KEY_DEFAULT);
        String messageDay4 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_4, Constants.PREFS_MOOD_MESSAGE.KEY_DEFAULT);
        String messageDay5 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_5, Constants.PREFS_MOOD_MESSAGE.KEY_DEFAULT);

        //get rid of day 6 message and incrementing all others by 1 day
        int colorDay6 = colorDay5;
        colorDay5 = colorDay4;
        colorDay4 = colorDay3;
        colorDay3 = colorDay2;
        colorDay2 = colorDay1;
        colorDay1 = colorDay0;
        colorDay0 = Constants.PREFS_MOOD_ID.KEY_DEFAULT;

        String messageDay6 = messageDay5;
        messageDay5 = messageDay4;
        messageDay4 = messageDay3;
        messageDay3 = messageDay2;
        messageDay2 = messageDay1;
        messageDay1 = messageDay0;
        messageDay0 = Constants.PREFS_MOOD_MESSAGE.KEY_DEFAULT;

        //update values in shared preferences
        prefsUtils.setValue(Constants.PREFS_MOOD_ID.KEY_DAY_0, colorDay0);
        prefsUtils.setValue(Constants.PREFS_MOOD_ID.KEY_DAY_1, colorDay1);
        prefsUtils.setValue(Constants.PREFS_MOOD_ID.KEY_DAY_2, colorDay2);
        prefsUtils.setValue(Constants.PREFS_MOOD_ID.KEY_DAY_3, colorDay3);
        prefsUtils.setValue(Constants.PREFS_MOOD_ID.KEY_DAY_4, colorDay4);
        prefsUtils.setValue(Constants.PREFS_MOOD_ID.KEY_DAY_5, colorDay5);
        prefsUtils.setValue(Constants.PREFS_MOOD_ID.KEY_DAY_6, colorDay6);

        prefsUtils.setValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_0, messageDay0);
        prefsUtils.setValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_1, messageDay1);
        prefsUtils.setValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_2, messageDay2);
        prefsUtils.setValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_3, messageDay3);
        prefsUtils.setValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_4, messageDay4);
        prefsUtils.setValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_5, messageDay5);
        prefsUtils.setValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_6, messageDay6);

        Log.d("AlarmReceiver", "Values Swapped!");
    }
}
