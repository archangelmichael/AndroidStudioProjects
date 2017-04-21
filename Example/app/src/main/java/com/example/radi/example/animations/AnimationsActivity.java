package com.example.radi.example.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

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


}
