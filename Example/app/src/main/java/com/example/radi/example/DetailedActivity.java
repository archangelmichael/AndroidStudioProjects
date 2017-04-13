package com.example.radi.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textMessage);
        textView.setText(message);
    }

    public void changeText() {
        //BlankFragment frag = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentBlank);
        //frag.setText("FRAGMENT HIT");
    }
}
