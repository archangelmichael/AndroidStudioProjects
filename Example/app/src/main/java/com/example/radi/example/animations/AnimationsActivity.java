package com.example.radi.example.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.radi.example.R;

public class AnimationsActivity extends AppCompatActivity {

    ViewGroup mSceneRoot;
    Scene mAScene;
    Scene mBScene;
    boolean isAVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);

// Create the scene root for the scenes in this app
        mSceneRoot = (ViewGroup) findViewById(R.id.animations_scene_root);

// Create the scenes
        mAScene = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_a, this);
        mBScene = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_b, this);
    }

    public void onTransitionScenes(View view) {
        Transition mFadeTransition = new Fade();

        if (isAVisible) {
            isAVisible = false;
            TransitionManager.go(mBScene, mFadeTransition);
        }
        else {
            isAVisible = true;
            TransitionManager.go(mAScene, mFadeTransition);
        }
    }

    private ScrollView scrollView;
    private TextView textView;

    public void onCrossFade(View view) {
        scrollView = (ScrollView) findViewById(R.id.svContent);
        textView = (TextView) findViewById(R.id.tvScene1);
        int animationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);

        if (scrollView.getVisibility() == View.GONE) {
            scrollView.setAlpha(0f);
            scrollView.setVisibility(View.VISIBLE);

            scrollView.animate()
                    .alpha(1f)
                    .setDuration(animationDuration)
                    .setListener(null);

            textView.animate()
                    .alpha(0f)
                    .setDuration(animationDuration)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            textView.setVisibility(View.GONE);
                        }
                    });
        }
        else {
            textView.setAlpha(0f);
            textView.setVisibility(View.VISIBLE);

            textView.animate()
                    .alpha(1f)
                    .setDuration(animationDuration)
                    .setListener(null);

            scrollView.animate()
                    .alpha(0f)
                    .setDuration(animationDuration)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            scrollView.setVisibility(View.GONE);
                        }
                    });
        }
    }

}
