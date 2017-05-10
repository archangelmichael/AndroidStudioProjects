package com.example.radi.teleriktraining.adapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.radi.teleriktraining.R;

public class SuperheroActivity extends AppCompatActivity {

    private Superhero[] superheroes = {
            new Superhero("Bruse Wayne", "Batman"),
            new Superhero("Clark Kent", "Superman"),
            new Superhero("Peter Parker", "Spiderman")
    };

    private ListView mSuperheroesListView;
    private SuperheroAdapter mSuperheroesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superhero);

        mSuperheroesListView = (ListView) this.findViewById(R.id.lv_superheroes);
        mSuperheroesAdapter = new SuperheroAdapter(this, this.superheroes);
        mSuperheroesListView.setAdapter(mSuperheroesAdapter);
        mSuperheroesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Superhero selectedHero = (Superhero) mSuperheroesAdapter.getItem(position);
                Toast.makeText(
                        getApplicationContext(),
                        String.format("%s's real name is %s", selectedHero.getAlias(), selectedHero.getName()),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
