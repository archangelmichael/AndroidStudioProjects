package com.example.radi.raytraining.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.radi.raytraining.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RageComicDetailsFragment extends Fragment {

    public static RageComicDetailsFragment newInstance() {
        return new RageComicDetailsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rage_comic_details, container, false);
    }

}
