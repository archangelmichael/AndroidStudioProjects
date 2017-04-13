package com.example.radi.example;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment {

    private  String fragName = "NEW";
    private static final String ARGUMENT_NAME = "FRAGMENT_NAME";

    private TextView nameView;

    public static ArticleFragment newInstance(String name) {
        final Bundle args = new Bundle();
        args.putString(ARGUMENT_NAME, name);
        final ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view =  inflater.inflate(R.layout.fragment_article, container, false);
        nameView = (TextView) view.findViewById(R.id.textArticleFragTitle);
        Button hitButton = (Button) view.findViewById(R.id.buttonHitFragment);
        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHitInFragment(v);
            }
        });

        setRetainInstance(true);
        final Bundle args = getArguments();
        // setText(args.getString(ARGUMENT_NAME));
        setText(fragName);
        return view;
    }

    public void setText(String yourText){
        nameView.setText(yourText);
        fragName = yourText;
    }

    public void onHitInFragment(View view) {
        setText(getResources().getString(R.string.button_hit_fragment));
    }
}
