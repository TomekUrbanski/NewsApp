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

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, List<News> news) {
        super(context, 0, news);
    }

    private static final String LOCATION_DATE_SEPARATOR = "T";
    private static final String LOCATION_AUTHOR_SEPARATOR = ("\\|");

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

        TextView sectionName = listItemView.findViewById(R.id.section);
        sectionName.setText(currentNews.getmSection());

        TextView newsTitle = listItemView.findViewById(R.id.titel);
        String info = currentNews.getmTitle();

        if (info.contains("|")) {
            String[] information = currentNews.getmTitle().split(LOCATION_AUTHOR_SEPARATOR);
            newsTitle.setText(information[0]);
        } else {
            newsTitle.setText(currentNews.getmTitle());

        }

        TextView newsAuthor = listItemView.findViewById(R.id.author);
        if (currentNews.getmAuthor() != null) {
            newsAuthor.setText(currentNews.getmAuthor());
        } else {
            newsAuthor.setText(R.string.author_unknown);
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
