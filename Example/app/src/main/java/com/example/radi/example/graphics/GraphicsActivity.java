package com.example.radi.example.graphics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GraphicsActivity extends AppCompatActivity {

    private GraphicsSurfaceView mGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGLView = new GraphicsSurfaceView(this);
        setContentView(mGLView);
        // setContentView(R.layout.activity_graphics);
    }
}
