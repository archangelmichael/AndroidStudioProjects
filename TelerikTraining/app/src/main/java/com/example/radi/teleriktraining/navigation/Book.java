package com.example.radi.teleriktraining.navigation;

import java.io.Serializable;

/**
 * Created by radi on 5/15/17.
 */

public class Book implements Serializable {
    private String ibns;
    private String title;

    public Book(String ibns, String title) {
        this.ibns = ibns;
        this.title = title;
    }

    public String getIbns() {
        return this.ibns;
    }

    public String getTitle() {
        return this.title;
    }
}
