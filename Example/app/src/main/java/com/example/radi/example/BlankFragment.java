package com.example.radi.example;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private TextView nameView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_blank, container, false);
        nameView = (TextView) view.findViewById(R.id.textBlankFragTitle);
        setText("THIS IS BLANK FRAGMENT");
        return view;
    }

    public void setText(String yourText){
        nameView.setText(yourText);
    }
}
