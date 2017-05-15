package com.example.radi.teleriktraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.radi.teleriktraining.adapters.SuperheroActivity;
import com.example.radi.teleriktraining.navigation.NavigationActivity;

public class MainActivity extends AppCompatActivity {

    String[] mTelerikTutorials = { "Superhero Adapter", "Navigation" };
    ListView mLvTelerik;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLvTelerik = (ListView) findViewById(R.id.lv_telerik);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mTelerikTutorials);
        mLvTelerik.setAdapter(mAdapter);

        mLvTelerik.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        onAdaptersTraining();
                        break;
                    case 1:
                        onNavigationTraining();
                        break;
                    default:
                        break;
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Action performed",
                                        Toast.LENGTH_SHORT ).show();
                            }
                        }).show();
            }
        });
    }

    private void onAdaptersTraining() {
        Intent adaptersIntent = new Intent(this, SuperheroActivity.class);
        this.startActivity(adaptersIntent);
    }

    private void onNavigationTraining() {
        Intent navigationIntent = new Intent(this, NavigationActivity.class);
        this.startActivity(navigationIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
