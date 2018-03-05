package com.example.rohantaneja.moodtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rohantaneja.moodtracker.model.Mood;
import com.example.rohantaneja.moodtracker.util.Constants;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Mood> getMoodsList() {
        ArrayList<Mood> moodsList = new ArrayList<>();

        moodsList.add(
                new Mood(Constants.MOOD_ID_NORMAL,
                        getString(R.string.score_70)

                ));

        moodsList.add(
                new Mood(Constants.MOOD_ID_SAD,
                        ""
                ));

        moodsList.add(
                new Mood(Constants.MOOD_ID_DISAPPOINTED,
                        getString(R.string.score_60)
                ));

        moodsList.add(
                new Mood(Constants.MOOD_ID_HAPPY,
                        getString(R.string.score_80)
                ));

        moodsList.add(
                new Mood(Constants.MOOD_ID_SUPER_HAPPY,
                        getString(R.string.score_90)
                ));

        moodsList.add(
                new Mood(Constants.MOOD_ID_NORMAL,
                        ""
                ));

        moodsList.add(
                new Mood(Constants.MOOD_ID_SUPER_HAPPY,
                        getString(R.string.score_90)
                ));

        return moodsList;
    }

    public String getMoodNameFromMoodId(int moodId) {
        switch (moodId) {
            case Constants.MOOD_ID_SAD:
                return Constants.MOOD_SAD;
            case Constants.MOOD_ID_DISAPPOINTED:
                return Constants.MOOD_DISAPPOINTED;
            case Constants.MOOD_ID_HAPPY:
                return Constants.MOOD_HAPPY;
            case Constants.MOOD_ID_SUPER_HAPPY:
                return Constants.MOOD_SUPER_HAPPY;

            //return "Normal" by default
            default:
                return Constants.MOOD_NORMAL;
        }
    }

    public int getMoodResIdFromMoodId(int moodId) {
        switch (moodId) {
            case Constants.MOOD_ID_SAD:
                return Constants.MOOD_IMAGE_SAD;
            case Constants.MOOD_ID_DISAPPOINTED:
                return Constants.MOOD_IMAGE_DISAPPOINTED;
            case Constants.MOOD_ID_HAPPY:
                return Constants.MOOD_IMAGE_HAPPY;
            case Constants.MOOD_ID_SUPER_HAPPY:
                return Constants.MOOD_IMAGE_SUPER_HAPPY;

            //return "Normal" by default
            default:
                return Constants.MOOD_IMAGE_NORMAL;
        }
    }

    public int getMoodResIdFromViewpagerPosition(int viewpagerPosition) {
        switch (viewpagerPosition) {
            case 0:
                return Constants.MOOD_IMAGE_SAD;
            case 1:
                return Constants.MOOD_IMAGE_DISAPPOINTED;
            case 3:
                return Constants.MOOD_IMAGE_HAPPY;
            case 4:
                return Constants.MOOD_IMAGE_SUPER_HAPPY;

            //return "Normal" by default
            default:
                return Constants.MOOD_IMAGE_NORMAL;
        }
    }

    public int getMoodColorIdFromMoodId(int moodId) {
        switch (moodId) {
            case Constants.MOOD_ID_SAD:
                return Constants.MOOD_COLOR_SAD;
            case Constants.MOOD_ID_DISAPPOINTED:
                return Constants.MOOD_COLOR_DISAPPOINTED;
            case Constants.MOOD_ID_HAPPY:
                return Constants.MOOD_COLOR_HAPPY;
            case Constants.MOOD_ID_SUPER_HAPPY:
                return Constants.MOOD_COLOR_SUPER_HAPPY;

            //return "Normal" by default
            default:
                return Constants.MOOD_COLOR_NORMAL;
        }
    }

    public int getMoodColorIdFromViewpagerPosition(int viewpagerPosition) {
        switch (viewpagerPosition) {
            case 0:
                return Constants.MOOD_COLOR_SAD;
            case 1:
                return Constants.MOOD_COLOR_DISAPPOINTED;
            case 3:
                return Constants.MOOD_COLOR_HAPPY;
            case 4:
                return Constants.MOOD_COLOR_SUPER_HAPPY;

            //return "Normal" by default
            default:
                return Constants.MOOD_COLOR_NORMAL;
        }
    }

    public double getMoodWidthMultiplierFromMoodId(int moodId) {
        switch (moodId) {
            case Constants.MOOD_ID_SAD:
                return Constants.MOOD_SAD_MULTIPLIER;
            case Constants.MOOD_ID_DISAPPOINTED:
                return Constants.MOOD_DISAPPOINTED_MULTIPLIER;
            case Constants.MOOD_ID_HAPPY:
                return Constants.MOOD_HAPPY_MULTIPLIER;
            case Constants.MOOD_ID_SUPER_HAPPY:
                return Constants.MOOD_SUPER_HAPPY_MULTIPLIER;

            //return multiplier for "Normal" by default
            default:
                return Constants.MOOD_NORMAL_MULTIPLIER;
        }
    }
}
