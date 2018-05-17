package com.example.android.newsapp;

import java.net.URL;

public class News {

    private String mTitle;
    private String mInformation;
    private long mDate;
    private String mAuthor;
    private String mUrl;

    public News(String title, String information, long date, String author,String url) {
        mTitle = title;
        mInformation = information;
        mDate = date;
        mAuthor = author;
        mUrl = url;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmInformation() {
        return mInformation;
    }

    public long getmDate() {
        return mDate;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmUrl() {
        return mUrl;
    }
}
