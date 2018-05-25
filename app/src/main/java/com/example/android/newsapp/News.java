package com.example.android.newsapp;

public class News {

    private String mTitle;
    private String mInformation;
    private String mDate;
    private String mAuthor;
    private String mUrl;

    public News(String title, String information, String date, String author, String url) {
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

    public String getDate() {
        return mDate;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmUrl() {
        return mUrl;
    }
}
