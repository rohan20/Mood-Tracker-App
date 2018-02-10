package com.example.rohantaneja.moodtracker.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rohantaneja.moodtracker.R;
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
                moodBackgroundId = R.color.faded_red;
                break;

            case 1:
                moodImageResId = Constants.MOOD_IMAGE_DISAPPOINTED;
                moodBackgroundId = R.color.warm_grey;
                break;

            case 2:
                moodImageResId = Constants.MOOD_IMAGE_NORMAL;
                moodBackgroundId = R.color.cornflower_blue_65;
                break;

            case 3:
                moodImageResId = Constants.MOOD_IMAGE_HAPPY;
                moodBackgroundId = R.color.light_sage;
                break;

            default:
                moodImageResId = Constants.MOOD_IMAGE_SUPER_HAPPY;
                moodBackgroundId = R.color.banana_yellow;
        }

        return MoodFragment.newInstance(moodImageResId, moodBackgroundId);
    }

    @Override
    public int getCount() {
        return Constants.NUMBER_OF_MOODS;
    }
}
