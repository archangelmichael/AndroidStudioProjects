package com.example.radi.raytraining;
import java.util.ArrayList;

/**
 * Created by radi on 4/24/17.
 */

public class Tutorial {
    private String mTitle;
    private boolean mComplete;

    public String getTitle() {
        return mTitle;
    }

    public boolean isComplete() {
        return mComplete;
    }

    // Constructor for Class
    public Tutorial(String title, boolean isComplete) {
        this.mTitle = title;
        this.mComplete = isComplete;
    }

    public static ArrayList<Tutorial> getAvailableTutorials() {
        ArrayList<Tutorial> tutorials = new ArrayList<Tutorial>();
        tutorials.add(new Tutorial("Fortunes", true));
        tutorials.add(new Tutorial("Intents", true));
        tutorials.add(new Tutorial("Activities", false));
        tutorials.add(new Tutorial("Coming next", false));
        return tutorials;
    }
}
