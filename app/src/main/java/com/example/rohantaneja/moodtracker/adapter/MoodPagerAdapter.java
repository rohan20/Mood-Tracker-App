package com.example.rohantaneja.moodtracker.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rohantaneja.moodtracker.ui.MoodFragment;
import com.example.rohantaneja.moodtracker.util.Constants;

/**
 * Created by rohantaneja on 05/02/18.
 */

public class MoodPagerAdapter extends FragmentPagerAdapter {

    public MoodPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public MoodFragment getItem(int position) {

        int moodImageResId;
        int moodBackgroundId;

        switch (position) {

            case 0:
                moodImageResId = Constants.MOOD_IMAGE_SAD;
                moodBackgroundId = Constants.MOOD_COLOR_SAD;
                break;

            case 1:
                moodImageResId = Constants.MOOD_IMAGE_DISAPPOINTED;
                moodBackgroundId = Constants.MOOD_COLOR_DISAPPOINTED;
                break;

            case 2:
                moodImageResId = Constants.MOOD_IMAGE_NORMAL;
                moodBackgroundId = Constants.MOOD_COLOR_NORMAL;
                break;

            case 3:
                moodImageResId = Constants.MOOD_IMAGE_HAPPY;
                moodBackgroundId = Constants.MOOD_COLOR_HAPPY;
                break;

            default:
                moodImageResId = Constants.MOOD_IMAGE_SUPER_HAPPY;
                moodBackgroundId = Constants.MOOD_COLOR_SUPER_HAPPY;
        }

        return MoodFragment.newInstance(moodImageResId, moodBackgroundId);
    }

    @Override
    public int getCount() {
        return Constants.NUMBER_OF_MOODS;
    }
}
