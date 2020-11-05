package com.example.safari.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.safari.R;

public class CustomAdapter extends BaseAdapter {
    Context context;

    String[] roomNames;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] roomNames) {
        this.context = applicationContext;

        this.roomNames = roomNames;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_items, null);

        TextView names = (TextView) view.findViewById(R.id.textView);

        names.setText(roomNames[i]);
        return view;
    }
}
