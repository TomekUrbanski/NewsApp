package com.example.android.newsapp;

public class News {

    private String mTitle;
    private String mDate;
    private String mUrl;
    private String mAuthor;
    private String mSection;

    public News(String title, String section, String date, String url, String author) {
        mTitle = title;
        mSection = section;
        mDate = date;
        mUrl = url;
        mAuthor = author;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmSection() {
        return mSection;
    }

    public String getDate() {
        return mDate;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmAuthor() {
        return mAuthor;
    }
}
