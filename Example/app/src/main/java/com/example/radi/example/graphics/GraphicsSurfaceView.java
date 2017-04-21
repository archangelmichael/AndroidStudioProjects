package com.example.radi.example.graphics;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class GraphicsSurfaceView extends GLSurfaceView {
    private final GraphicsRenderer mRenderer;

    public GraphicsSurfaceView(Context context){
        super(context);
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);
        mRenderer = new GraphicsRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
    }
}
