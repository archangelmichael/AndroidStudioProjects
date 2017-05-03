package com.example.radi.raytraining.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.radi.raytraining.R;
import com.squareup.picasso.Picasso;

public class RecyclerPhotoActivity extends AppCompatActivity {

    private ImageView mPhotoImageView;
    private TextView mDescriptionTextView;
    private Photo mSelectedPhoto;
    private static final String PHOTO_KEY = "PHOTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_photo);

        mPhotoImageView = (ImageView) findViewById(R.id.photoImageView);
        mSelectedPhoto = (Photo) getIntent().getSerializableExtra(PHOTO_KEY);
        Picasso.with(this).load(mSelectedPhoto.getUrl()).into(mPhotoImageView);

        mDescriptionTextView = (TextView) findViewById(R.id.photoDescription);

        if (mDescriptionTextView != null) {
            mDescriptionTextView.setText(mSelectedPhoto.getExplanation());
        }
    }
}
