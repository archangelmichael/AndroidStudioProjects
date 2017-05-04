package com.example.radi.raytraining.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.radi.raytraining.R;

public class AnimationsActivity extends AppCompatActivity {

    public static final long DEFAULT_ANIMATION_DURATION = 2500L;
    protected View mRocket;
    protected View mDoge;
    protected View mFrameLayout;
    protected float mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);

        mRocket = findViewById(R.id.rocket);
        mDoge = findViewById(R.id.doge);
        mFrameLayout = findViewById(R.id.container);
    }

    @Override
    protected void onResume() {
        super.onResume();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;
    }

    public void onLaunch(View view) {

    }

    public void onSpin(View view) {

    }

    public void onAccelerate(View view) {

    }

    public void onLaunch2(View view) {

    }

    public void onBackgroundChange(View view) {

    }

    public void onLaunchAndSpin(View view) {

    }

    public void onLaunchAndSpin2(View view) {

    }

    public void onGetDoge(View view) {

    }

    public void onEvents(View view) {

    }

    public void onFlyBack(View view) {

    }
}
