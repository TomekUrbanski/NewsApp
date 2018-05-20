package com.example.android.newsapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, List<News> news) {
        super(context, 0, news);
    }

    private static final String LOCATION_SEPARATOR = "T";

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_item, parent, false);
        }

        News currentNews = getItem(position);
        LinearLayout listItem = listItemView.findViewById(R.id.news_item);
        if((position & 1) == 0) {
            listItem.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }else {
            listItem.setBackgroundColor(Color.parseColor("#E0E0E0"));
        }

        TextView newsTitle = listItemView.findViewById(R.id.titel);
        newsTitle.setText(currentNews.getmTitle());

        TextView newsDate = listItemView.findViewById(R.id.date);
        String originalDate = currentNews.getDate();

        if (originalDate.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalDate.split(LOCATION_SEPARATOR);
            newsDate.setText(parts[0]);

        } else {
            newsDate.setText(currentNews.getDate());
        }


        StringBuilder infoAndAuthor = new StringBuilder();
        String author;
        if(currentNews.getmAuthor()==null) {
            author = "anonymous";
        }else{
            author = currentNews.getmAuthor();
            }

        infoAndAuthor.append(currentNews.getmInformation()).append(" /").append(author);
        String finalInformation = infoAndAuthor.toString();
        TextView newsInformation = listItemView.findViewById(R.id.information);
        newsInformation.setText(finalInformation);

        return listItemView;
    }
}
