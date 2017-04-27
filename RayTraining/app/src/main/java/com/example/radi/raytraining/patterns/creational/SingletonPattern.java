package com.example.radi.raytraining.patterns.creational;

/**
 * Created by radi on 4/27/17.
 */

public class SingletonPattern {
    private static SingletonPattern instance = null;

    private SingletonPattern() {
        // customize if needed
    }

    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }

        return instance;
    }
}
