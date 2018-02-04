package com.example.rohantaneja.moodtracker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoodFragment extends Fragment {


    public MoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mood, container, false);
    }

    public static MoodFragment newInstance(int moodImageResId, int moodBackgroundId) {
        MoodFragment moodFragment = new MoodFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("image", moodImageResId);
        bundle.putInt("background", moodBackgroundId);
        moodFragment.setArguments(bundle);
        return moodFragment;
    }

}
