package com.example.radi.raytraining.activities;

import java.io.Serializable;
import java.util.Date;

public class Todo implements Serializable {

    private String mTodoTitle;
    private Date mTodoDate;

    public String getTitle() {
        return mTodoTitle;
    }

    public Date getDate() {
        return mTodoDate;
    }

    public Todo (String title, Date date) {
        mTodoTitle = title;
        mTodoDate = date;
    }

}
