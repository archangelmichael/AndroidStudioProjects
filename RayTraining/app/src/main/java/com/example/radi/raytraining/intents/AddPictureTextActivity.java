package com.example.radi.raytraining.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.radi.raytraining.R;

public class AddPictureTextActivity extends AppCompatActivity {

    private Button btnAddText;
    private EditText etPictureInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picture_text);

        btnAddText = (Button) findViewById(R.id.btnAddPictureText);
        etPictureInput = (EditText) findViewById(R.id.etPictureText);

        btnAddText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pictureText = etPictureInput.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("picture_text", pictureText);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
