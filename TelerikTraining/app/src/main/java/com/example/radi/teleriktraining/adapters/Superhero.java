package com.example.radi.teleriktraining.adapters;

/**
 * Created by radi on 5/10/17.
 */

public class Superhero {
    private String mName;
    private String mAlias;

    public Superhero(String name, String alias) {
        this.mName = name;
        this.mAlias = alias;
    }

    public String getName() {
        return this.mName;
    }

    public String getAlias() {
        return this.mAlias;
    }

}
