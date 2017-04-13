package com.example.radi.example;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentsActivity extends AppCompatActivity {

    private final String LEFT_ARTICLE = "left";
    private final String RIGHT_ARTICLE = "right";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        addFragment(savedInstanceState);
    }

    private void addFragment(Bundle savedInstanceState) {
        if (findViewById(R.id.frameTabs) != null) {
            if (savedInstanceState != null) {
                //Restore the fragment's instance
                return;
            }

            onChangeFragment(findViewById(R.id.buttonShowLeftFrag));
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void onChangeFragment(View view) {
        int fragmentsCount = getSupportFragmentManager().getBackStackEntryCount();

        if (view.getId() == R.id.buttonShowLeftFrag) {
            ArticleFragment leftFragment = getFragmentFromStackByTag(LEFT_ARTICLE);
            if (leftFragment == null) {
                String fragName = getResources().getString(R.string.button_left_fragment);
                leftFragment = ArticleFragment.newInstance(fragName);
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragmentsCount > 0) {
                transaction.replace(R.id.frameTabs, leftFragment, LEFT_ARTICLE);
            }
            else {
                transaction.add(R.id.frameTabs, leftFragment, LEFT_ARTICLE);
            }

            transaction.addToBackStack("leftFragment");
            transaction.commit();
        }
        else if (view.getId() == R.id.buttonShowRightFrag) {
            ArticleFragment rightFragment = getFragmentFromStackByTag(RIGHT_ARTICLE);
            if (rightFragment == null) {
                String fragName = getResources().getString(R.string.button_right_fragment);
                rightFragment = ArticleFragment.newInstance(fragName);
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragmentsCount > 0) {
                transaction.replace(R.id.frameTabs, rightFragment, RIGHT_ARTICLE);
            }
            else {
                transaction.add(R.id.frameTabs, rightFragment, RIGHT_ARTICLE);
            }

            transaction.addToBackStack(RIGHT_ARTICLE);
            transaction.commit();
        }
    }

    private ArticleFragment getFragmentFromStackByTag(String tag) {
        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager().findFragmentByTag(tag);
        return articleFragment;
    }
}
