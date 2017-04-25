package com.example.radi.raytraining.intents;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.radi.raytraining.R;

import java.io.File;

public class TakePictureActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_TEXT_CAPTURE = 2;

    private TextView tvPictureText;
    private ImageButton ibTakePicture;
    private Button btnAddText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);

        tvPictureText = (TextView) findViewById(R.id.tvPictureText);
        ibTakePicture =  (ImageButton) findViewById(R.id.ibTakePicture);
        ibTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(
                            takePictureIntent,
                            REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        btnAddText = (Button) findViewById(R.id.btnAddText);
        btnAddText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        new Intent(TakePictureActivity.this, AddPictureTextActivity.class),
                        REQUEST_TEXT_CAPTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ibTakePicture.setImageBitmap(imageBitmap);
        }
        else if (requestCode == REQUEST_TEXT_CAPTURE && resultCode == RESULT_OK) {
            String pictureText = data.getExtras().getString("picture_text");
            tvPictureText.setText(pictureText);
        }
    }
}
