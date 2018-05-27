package com.example.android.newsapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.regex.Pattern;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, List<News> news) {
        super(context, 0, news);
    }

    private static final String LOCATION_DATE_SEPARATOR = "T";
    private static final String LOCATION_AUTHOR_SEPARATOR = (Pattern.quote("|"));

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_item, parent, false);
        }

        News currentNews = getItem(position);
        LinearLayout listItem = listItemView.findViewById(R.id.news_item);
        if ((position & 1) == 0) {
            listItem.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            listItem.setBackgroundColor(Color.parseColor("#E0E0E0"));
        }

        TextView newsTitle = listItemView.findViewById(R.id.titel);
        TextView newsAuthor = listItemView.findViewById(R.id.author);
        String info = currentNews.getmTitle();


        if (info.contains(LOCATION_AUTHOR_SEPARATOR)) {
            String[] information = currentNews.getmTitle().split(LOCATION_AUTHOR_SEPARATOR);
            newsTitle.setText(information[0]);
            newsAuthor.setText(information[1]);
        } else {
            newsTitle.setText(currentNews.getmTitle());
            newsAuthor.setText("Author: Unknown");
        }


        TextView newsDate = listItemView.findViewById(R.id.date);
        String originalDate = currentNews.getDate();

        if (originalDate.contains(LOCATION_DATE_SEPARATOR)) {
            String[] parts = originalDate.split(LOCATION_DATE_SEPARATOR);
            newsDate.setText(parts[0]);

        } else {
            newsDate.setText(currentNews.getDate());
        }

        return listItemView;
    }
}
