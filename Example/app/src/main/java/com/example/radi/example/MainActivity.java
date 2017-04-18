package com.example.radi.example;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

        }
    }

    public void onSendMessage(View view) {
        Intent intent = new Intent(this, DetailedActivity.class);
        EditText editText = (EditText) findViewById(R.id.textInput);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void onShowFragments(View view) {
        Intent intent = new Intent(this, FragmentsActivity.class);
        startActivity(intent);
    }

    public void onShowTabs(View view) {
        Intent intent = new Intent(this, FragmentTabsActivity.class);
        startActivity(intent);
    }

    public void onShowSave(View view) {
        Intent intent = new Intent(this, SaveDataActivity.class);
        startActivity(intent);
    }
}
