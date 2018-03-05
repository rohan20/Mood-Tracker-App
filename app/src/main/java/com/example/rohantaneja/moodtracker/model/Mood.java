package com.example.rohantaneja.moodtracker.model;

/**
 * Created by rohantaneja on 09/02/18.
 */

public class Mood {

    private int moodId;
    private String moodMessage;

    public Mood(int moodId, String moodMessage) {
        this.moodId = moodId;
        this.moodMessage = moodMessage;
    }

    public int getMoodId() {
        return moodId;
    }

    public String getMoodMessage() {
        return moodMessage;
    }

    public void setMoodId(int moodId) {
        this.moodId = moodId;
    }

    public void setMoodMessage(String moodMessage) {
        this.moodMessage = moodMessage;
    }
}
