package com.example.radi.example.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.radi.example.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RightTabFragment extends Fragment {

    OnRightTabHitListener mCallback;

    public interface OnRightTabHitListener {
        public void onRightTabSelected();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            try {
                mCallback = (OnRightTabHitListener) activity;
            }
            catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnHeadlineSelectedListener");
            }
        }

    }

    public RightTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.fragment_right_tab, container, false);
        Button hitButton = (Button) view.findViewById(R.id.btnHitRightTab);
        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRightTabHit(v);
            }
        });

        return view;
    }

    public void onRightTabHit(View view) {
        mCallback.onRightTabSelected();
    }
}
