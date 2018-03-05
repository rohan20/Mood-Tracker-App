package com.example.rohantaneja.moodtracker.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rohantaneja.moodtracker.BaseActivity;
import com.example.rohantaneja.moodtracker.ui.MoodFragment;
import com.example.rohantaneja.moodtracker.util.Constants;

/**
 * Created by rohantaneja on 05/02/18.
 */

public class MoodPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public MoodPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = (BaseActivity) context;

    }

    @Override
    public MoodFragment getItem(int position) {
        return MoodFragment.newInstance(
                ((BaseActivity) context).getMoodResIdFromViewpagerPosition(position),
                ((BaseActivity) context).getMoodColorIdFromMoodId(position)
        );
    }

    @Override
    public int getCount() {
        return Constants.NUMBER_OF_MOODS;
    }
}
