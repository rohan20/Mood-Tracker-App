package com.example.rohantaneja.moodtracker.ui;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rohantaneja.moodtracker.R;
import com.example.rohantaneja.moodtracker.util.Constants;


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

        View v = inflater.inflate(R.layout.fragment_mood, container, false);

        if (getArguments() != null) {
            ImageView moodImageView = v.findViewById(R.id.iv_mood);
            moodImageView.setImageResource(getArguments().getInt(Constants.BUNDLE_KEY.KEY_IMAGE));
            ConstraintLayout constraintLayout = v.findViewById(R.id.cl_parent);
            constraintLayout.setBackgroundResource(getArguments().getInt(Constants.BUNDLE_KEY.KEY_BACKGROUND));
        }

        return v;
    }

    public static MoodFragment newInstance(int moodImageResId, int moodBackgroundId) {
        MoodFragment moodFragment = new MoodFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.BUNDLE_KEY.KEY_IMAGE, moodImageResId);
        bundle.putInt(Constants.BUNDLE_KEY.KEY_BACKGROUND, moodBackgroundId);
        moodFragment.setArguments(bundle);
        return moodFragment;
    }

}
