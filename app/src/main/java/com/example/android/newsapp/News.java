package com.example.android.newsapp;

public class News {

    private String mTitle;
    private String mDate;
    private String mUrl;

    public News(String title, String date, String url) {
        mTitle = title;
        mDate = date;
        mUrl = url;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getDate() {
        return mDate;
    }

    public String getmUrl() {
        return mUrl;
    }
}
