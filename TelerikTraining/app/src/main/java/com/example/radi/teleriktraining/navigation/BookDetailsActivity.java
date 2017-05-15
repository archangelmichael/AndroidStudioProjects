package com.example.radi.teleriktraining.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.radi.teleriktraining.R;

public class BookDetailsActivity extends AppCompatActivity {

    public static final String BOOK_KEY = "book_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        Intent bookIntent = this.getIntent();
        Book bookReceived = (Book) bookIntent.getSerializableExtra(BOOK_KEY);
        Toast.makeText(this, bookReceived.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
