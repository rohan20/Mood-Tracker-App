package com.example.rohantaneja.moodtracker.util;

import com.example.rohantaneja.moodtracker.R;

/**
 * Created by rohantaneja on 10/02/18.
 */

public class Constants {

    public static final int NUMBER_OF_MOODS = 5;
    public static final int NUMBER_OF_DAYS = 7;

    // TODO: 17/09/18 Convert the following static constants to interfaces

    public static final int MOOD_IMAGE_SAD = R.drawable.smiley_sad;
    public static final int MOOD_IMAGE_DISAPPOINTED = R.drawable.smiley_disappointed;
    public static final int MOOD_IMAGE_NORMAL = R.drawable.smiley_normal;
    public static final int MOOD_IMAGE_HAPPY = R.drawable.smiley_happy;
    public static final int MOOD_IMAGE_SUPER_HAPPY = R.drawable.smiley_super_happy;

    public static final int MOOD_COLOR_DEFAULT = android.R.color.transparent;
    public static final int MOOD_COLOR_SAD = R.color.faded_red;
    public static final int MOOD_COLOR_DISAPPOINTED = R.color.warm_grey;
    public static final int MOOD_COLOR_NORMAL = R.color.cornflower_blue_65;
    public static final int MOOD_COLOR_HAPPY = R.color.light_sage;
    public static final int MOOD_COLOR_SUPER_HAPPY = R.color.banana_yellow;

    public static final int MOOD_ID_DEFAULT = -1;
    public static final int MOOD_ID_SAD = 0;
    public static final int MOOD_ID_DISAPPOINTED = 1;
    public static final int MOOD_ID_NORMAL = 2;
    public static final int MOOD_ID_HAPPY = 3;
    public static final int MOOD_ID_SUPER_HAPPY = 4;

    public static final String MOOD_SAD = "Sad";
    public static final String MOOD_DISAPPOINTED = "Disappointed";
    public static final String MOOD_NORMAL = "Normal";
    public static final String MOOD_HAPPY = "Happy";
    public static final String MOOD_SUPER_HAPPY = "Super Happy";

    //for setting the width of moods in mood history
    public static final double MOOD_SAD_MULTIPLIER = 0.2;
    public static final double MOOD_DISAPPOINTED_MULTIPLIER = 0.4;
    public static final double MOOD_NORMAL_MULTIPLIER = 0.6;
    public static final double MOOD_HAPPY_MULTIPLIER = 0.8;
    public static final double MOOD_SUPER_HAPPY_MULTIPLIER = 1;

    public interface BUNDLE_KEY {
        String KEY_IMAGE = "image";
        String KEY_BACKGROUND = "background";
    }

    //SharedPref keys for mood messages
    public interface PREFS_MOOD_MESSAGE {
        String KEY_DEFAULT = null;
        String KEY_DAY_0 = "MOOD_MESSAGE_TODAY";
        String KEY_DAY_1 = "MOOD_MESSAGE_YESTERDAY";
        String KEY_DAY_2 = "MOOD_MESSAGE_TWO_DAYS_AGO";
        String KEY_DAY_3 = "MOOD_MESSAGE_THREE_DAYS_AGO";
        String KEY_DAY_4 = "MOOD_MESSAGE_FOUR_DAYS_AGO";
        String KEY_DAY_5 = "MOOD_MESSAGE_FIVE_DAYS_AGO";
        String KEY_DAY_6 = "MOOD_MESSAGE_SIX_DAYS_AGO";
    }

    //SharedPref keys for mood ids
    public interface PREFS_MOOD_ID {
        int KEY_DEFAULT = MOOD_ID_DEFAULT;
        String KEY_DAY_0 = "MOOD_ID_TODAY";
        String KEY_DAY_1 = "MOOD_ID_YESTERDAY";
        String KEY_DAY_2 = "MOOD_ID_TWO_DAYS_AGO";
        String KEY_DAY_3 = "MOOD_ID_THREE_DAYS_AGO";
        String KEY_DAY_4 = "MOOD_ID_FOUR_DAYS_AGO";
        String KEY_DAY_5 = "MOOD_ID_FIVE_DAYS_AGO";
        String KEY_DAY_6 = "MOOD_ID_SIX_DAYS_AGO";
    }

}
