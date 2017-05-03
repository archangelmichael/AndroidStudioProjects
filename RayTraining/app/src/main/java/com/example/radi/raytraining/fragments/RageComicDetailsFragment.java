package com.example.radi.raytraining.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.radi.raytraining.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RageComicDetailsFragment extends Fragment {

    private static final String ARGUMENT_NAME = "name";

    public static RageComicDetailsFragment newInstance(String name) {

        final Bundle args = new Bundle();
        args.putString(ARGUMENT_NAME, name);
        final RageComicDetailsFragment fragment = new RageComicDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_rage_comic_details, container, false);
        final TextView nameTextView = (TextView) view.findViewById(R.id.tvRageName);

        final Bundle args = getArguments();
        nameTextView.setText(args.getString(ARGUMENT_NAME));
        return view;
    }

}
