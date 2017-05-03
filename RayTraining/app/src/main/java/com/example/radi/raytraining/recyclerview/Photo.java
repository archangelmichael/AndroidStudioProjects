package com.example.radi.raytraining.recyclerview;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Photo implements Serializable {

    private String mDate;
    private String mHumanDate;
    private String mExplanation;
    private String mUrl;

    public Photo(JSONObject photoJSON) {
        try {
            mDate = photoJSON.getString("date");
            mHumanDate = convertDateToHumanDate();
            mExplanation = photoJSON.getString("explanation");
            mUrl = photoJSON.getString("url");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getHumanDate() {
        return mHumanDate;
    }

    public String getExplanation() {
        return mExplanation;
    }

    public String getUrl() {
        return mUrl;
    }

    private String convertDateToHumanDate() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat humanDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        try {
            Date date = dateFormat.parse(mDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return humanDateFormat.format(cal.getTime());
        }
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
