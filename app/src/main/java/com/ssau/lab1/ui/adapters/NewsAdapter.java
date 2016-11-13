package com.ssau.lab1.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ssau.lab1.R;


public class NewsAdapter extends BaseAdapter {

    private String[] data;
    private Context context;

    public NewsAdapter(Context context, String[] objects) {
        data = objects;
        this.context = context;
    }


    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // This a new view we inflate the new layout
            LayoutInflater inflater = (LayoutInflater) context
                    .getApplicationContext().getSystemService(
                            Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.i_news,
                    parent, false);
        }

        AppCompatTextView title = (AppCompatTextView) convertView
                .findViewById(R.id.news_title);
        title.setText(data[position]);


        return convertView;
    }
}
