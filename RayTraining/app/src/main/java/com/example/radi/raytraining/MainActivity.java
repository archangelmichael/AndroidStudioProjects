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
                onRowSelected(selectedTutorial, 0);
            }
        });
    }

    public void onRowSelected(Tutorial tutorial, int position) {
        switch (position) {
            case 0:
                Toast.makeText(this, "Fortunes are coming next", Toast.LENGTH_SHORT).show();
                break;
            case 1:
//                Intent detailIntent = new Intent(context, RecipeDetailActivity.class);
//                detailIntent.putExtra("title", selectedRecipe.title);
//                detailIntent.putExtra("url", selectedRecipe.instructionUrl);
//                startActivity(detailIntent);
                break;
            default:
                break;
        }
    }
}
