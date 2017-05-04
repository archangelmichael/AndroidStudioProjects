package com.example.radi.raytraining.animations;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

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
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mRocket.setTranslationY(value);
            }
        });

        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        valueAnimator.start();
    }

    public void onSpin(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 360);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mRocket.setRotation(value);
            }
        });

        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        valueAnimator.start();
    }

    public void onAccelerate(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mRocket.setTranslationY(value);
            }
        });

        valueAnimator.setInterpolator(new AccelerateInterpolator(1.5f));
        valueAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        valueAnimator.start();
    }

    public void onLaunch2(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mRocket, "translationY", 0, -mScreenHeight);
        objectAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        objectAnimator.start();
    }

    public void onBackgroundChange(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(mFrameLayout, "backgroundColor",
                new ArgbEvaluator(),
                ContextCompat.getColor(this, R.color.colorPrimaryDark),
                ContextCompat.getColor(this, R.color.colorAccent));
        objectAnimator.setRepeatCount(1);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        objectAnimator.start();
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
