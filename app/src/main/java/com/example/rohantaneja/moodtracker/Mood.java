package com.example.rohantaneja.moodtracker;

/**
 * Created by rohantaneja on 09/02/18.
 */

public class Mood {

    private String moodName;
    private int moodId;
    private int moodResId;

    public String getMoodName() {
        return moodName;
    }

    public int getMoodId() {
        return moodId;
    }

    public int getMoodResId() {
        return moodResId;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    public void setMoodId(int moodId) {
        this.moodId = moodId;
    }

    public void setMoodResId(int moodResId) {
        this.moodResId = moodResId;
    }
}
