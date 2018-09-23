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
        // TODO: 21/09/18 Implement swapping of mood ids

        SharedPreferenceUtils prefsUtils = SharedPreferenceUtils.getInstance(context);

        //fetch latest values from shared preferences
        String messageDay0 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_0, null);
        String messageDay1 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_1, null);
        String messageDay2 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_2, null);
        String messageDay3 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_3, null);
        String messageDay4 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_4, null);
        String messageDay5 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_5, null);
        String messageDay6 = prefsUtils.getStringValue(Constants.PREFS_MOOD_MESSAGE.KEY_DAY_6, null);

        //getting rid of day 7 message and incrementing all others by 1 day
        messageDay6 = messageDay5;
        messageDay5 = messageDay4;
        messageDay4 = messageDay3;
        messageDay3 = messageDay2;
        messageDay2 = messageDay1;
        messageDay1 = messageDay0;
        messageDay0 = null;

        //update values in shared preferences
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
