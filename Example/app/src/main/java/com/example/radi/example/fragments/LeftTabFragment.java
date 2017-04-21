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
public class LeftTabFragment extends Fragment {

    OnLeftTabHitListener mCallback;

    public interface OnLeftTabHitListener {
        public void onLeftTabSelected();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            try {
                mCallback = (OnLeftTabHitListener) activity;
            }
            catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnHeadlineSelectedListener");
            }
        }
    }

    public LeftTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_left_tab, container, false);
        Button hitButton = (Button) view.findViewById(R.id.btnHitLeftTab);
        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLeftTabHit(v);
            }
        });

        return view;
    }

    public void onLeftTabHit(View view) {
        mCallback.onLeftTabSelected();
    }
}
