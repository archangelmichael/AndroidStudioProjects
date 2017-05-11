package com.example.radi.tutorialspointtraining.intent;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.radi.tutorialspointtraining.R;

public class IntentActivity extends AppCompatActivity {

    Button btnOpenWebsite, btnDialPhone, btnSendEmail, btnSearchInBrowser, btnSendIntentFilter, btnOpenIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        btnOpenWebsite = (Button) findViewById(R.id.btn_open_website);
        btnOpenWebsite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.example.com"));
                startActivity(i);
            }
        });

        btnDialPhone = (Button) findViewById(R.id.btn_dial_phone_number);
        btnDialPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("tel:9510300000"));
                startActivity(i);
            }
        });

        btnSendEmail = (Button) findViewById(R.id.btn_send_email);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SEND AS EMAIL
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                emailIntent.setType("vnd.android.cursor.item/email");
                // SEND AS TEXT
//                Intent emailIntent = new Intent(Intent.ACTION_SEND);
//                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "test@test.com" });
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Sending email");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Test email");
                startActivity(Intent.createChooser(emailIntent, "Choose an email client from..."));
            }
        });

        btnSearchInBrowser = (Button) findViewById(R.id.btn_browser_search);
        btnSearchInBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q = "tutorialspoint";
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
                intent.putExtra(SearchManager.QUERY, q);
                startActivity(intent);
            }
        });

        btnSendIntentFilter = (Button) findViewById(R.id.btn_send_intent_filter);
        btnSendIntentFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        "com.example.radi.tutorialspointtraining.LAUNCH",
                        Uri.parse("http://www.example.com"));
                startActivity(i);
            }
        });

        btnOpenIntentFilter = (Button) findViewById(R.id.btn_open_intent_filter);
        btnOpenIntentFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.example.com"));
                startActivity(i);
            }
        });
    }
}
