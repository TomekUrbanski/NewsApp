package com.example.android.newsapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, List<News> news) {
        super(context, 0, news);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView newsTitle = listItemView.findViewById(R.id.titel);
        newsTitle.setText(currentNews.getmTitle());

        TextView newsDate = listItemView.findViewById(R.id.date);
        Date dateObject = new Date(currentNews.getmDate());
        String formattedDate = formatDate(dateObject);
        newsDate.setText(formattedDate);

        StringBuilder infoAndAuthor = new StringBuilder();
        infoAndAuthor.append(currentNews.getmInformation()).append(" /").append(currentNews.getmAuthor());
        String finalInformation = infoAndAuthor.toString();
        TextView newsInformation = listItemView.findViewById(R.id.information);
        newsInformation.setText(finalInformation);

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
}
