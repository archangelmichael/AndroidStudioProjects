package com.example.radi.raytraining.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.radi.raytraining.R;

public class RageComicsActivity extends AppCompatActivity implements RageComicListFragment.OnRageComicSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rage_comics);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.rage_fragments_frame, RageComicListFragment.newInstance(), "rageComicList")
                    .commit();
        }
    }

    @Override
    public void onRageComicSelected(String name) {
        Toast.makeText(this, "Hey, you selected " + name + "!", Toast.LENGTH_SHORT).show();

        final RageComicDetailsFragment detailsFragment =
                RageComicDetailsFragment.newInstance(name);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rage_fragments_frame, detailsFragment, "rageComicDetails")
                .addToBackStack(null)
                .commit();
    }
}
