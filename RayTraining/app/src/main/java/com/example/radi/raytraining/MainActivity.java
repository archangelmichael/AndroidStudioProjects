package com.example.radi.raytraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.tutorials_list_view);

        final ArrayList<Tutorial> tutorials = Tutorial.getAvailableTutorials();
        TutorialAdapter adapter = new TutorialAdapter(this, tutorials);
        mListView.setAdapter(adapter);
    }
}
