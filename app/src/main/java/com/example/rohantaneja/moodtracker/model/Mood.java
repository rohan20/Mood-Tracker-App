package com.example.rohantaneja.moodtracker.model;

/**
 * Created by rohantaneja on 09/02/18.
 */

public class Mood {

    private int moodId;
    private String moodName;
    private int moodResId;
    private int moodColorId;
    private String moodMessage;

    public Mood(int moodId, String moodName, int moodResId, int moodColorId, String moodMessage) {
        this.moodId = moodId;
        this.moodName = moodName;
        this.moodResId = moodResId;
        this.moodColorId = moodColorId;
        this.moodMessage = moodMessage;
    }

    public String getMoodName() {
        return moodName;
    }

    public int getMoodId() {
        return moodId;
    }

    public int getMoodResId() {
        return moodResId;
    }

    public int getMoodColorId() {
        return moodColorId;
    }

    public String getMoodMessage() {
        return moodMessage;
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

    public void setMoodColorId(int moodColorId) {
        this.moodColorId = moodColorId;
    }

    public void setMoodMessage(String moodMessage) {
        this.moodMessage = moodMessage;
    }
}
