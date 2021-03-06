package com.example.radi.example.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.radi.example.R;

public class FragmentTabsActivity extends AppCompatActivity
        implements LeftTabFragment.OnLeftTabHitListener, RightTabFragment.OnRightTabHitListener {

    int activeTab = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tabs);
        setActiveTab(activeTab);
    }

    private void setActiveTab(int tab) {
        activeTab = tab;
        View fragLeft = findViewById(R.id.fragLeftTab);
        View fragRight = findViewById(R.id.fragRightTab);

        if (tab == 0) {
            fragLeft.setVisibility(View.VISIBLE);
            fragRight.setVisibility(View.GONE);
        }
        else {
            fragLeft.setVisibility(View.GONE);
            fragRight.setVisibility(View.VISIBLE);
        }

        TextView tvTitle = (TextView) findViewById(R.id.tvTabActive);
        tvTitle.setText(String.format("ACTIVE TAB %d", tab));
    }


    @Override
    public void onLeftTabSelected() {
        setActiveTab(1);
    }

    @Override
    public void onRightTabSelected() {
        setActiveTab(0);
    }
}
