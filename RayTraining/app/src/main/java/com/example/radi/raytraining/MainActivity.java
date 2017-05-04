package com.example.radi.raytraining;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.radi.raytraining.activities.TodoActivity;
import com.example.radi.raytraining.animations.AnimationsActivity;
import com.example.radi.raytraining.fragments.RageComicsActivity;
import com.example.radi.raytraining.intents.TakePictureActivity;
import com.example.radi.raytraining.recyclerview.RecyclerViewActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.tutorials_list_view);

        final ArrayList<Tutorial> tutorialList = Tutorial.getAvailableTutorials();
        TutorialAdapter adapter = new TutorialAdapter(this, tutorialList);
        mListView.setAdapter(adapter);

        final Context context = this;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tutorial selectedTutorial = tutorialList.get(position);
                onRowSelected(selectedTutorial, position);
            }
        });
    }

    public void onRowSelected(Tutorial tutorial, int position) {
        switch (position) {
            case 0: // Fortune teller
                Intent fortuneIntent = new Intent(this, FortuneActivity.class);
                fortuneIntent.putExtra("title", tutorial.getTitle());
                startActivity(fortuneIntent);
                break;
            case 1: // Intents
                Intent pictureIntent = new Intent(this, TakePictureActivity.class);
                pictureIntent.putExtra("title", tutorial.getTitle());
                startActivity(pictureIntent);
                break;
            case 2: // Activities
                Intent activitiesIntent = new Intent(this, TodoActivity.class);
                activitiesIntent.putExtra("title", tutorial.getTitle());
                startActivity(activitiesIntent);
                break;
            case 3: // Fragments
                Intent fragmentsIntent = new Intent(this, RageComicsActivity.class);
                fragmentsIntent.putExtra("title", tutorial.getTitle());
                startActivity(fragmentsIntent);
                break;
            case 4: // Recycler view
                Intent recyclerIntent = new Intent(this, RecyclerViewActivity.class);
                recyclerIntent.putExtra("title", tutorial.getTitle());
                startActivity(recyclerIntent);
                break;
            case 5: // Animations
                Intent animationsIntent = new Intent(this, AnimationsActivity.class);
                animationsIntent.putExtra("title", tutorial.getTitle());
                startActivity(animationsIntent);
                break;
            default:
                Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
