package com.example.radi.example;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SaveDataActivity extends AppCompatActivity {

    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        etInput =(EditText) findViewById(R.id.etSaveEntry);
    }

    public void onSaveData(View view) {
        String input = etInput.getText().toString();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.key_save_data_entry), input);
        editor.commit();
    }

    public void onLoadData(View view) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String output = sharedPref.getString(getString(R.string.key_save_data_entry), null);
        etInput.setText(output);
    }

    public void onClearData(View view) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.key_save_data_entry), null);
        editor.commit();
    }
}
