package com.example.radi.tutorialspointtraining.intent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.radi.tutorialspointtraining.R;

public class IntentFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filter);

        TextView label = (TextView) findViewById(R.id.tv_intent_data);
        Uri url = getIntent().getData();
        label.setText(url.toString());
    }
}
