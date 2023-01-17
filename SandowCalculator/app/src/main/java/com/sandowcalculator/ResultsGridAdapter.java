package com.sandowcalculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsGridAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> results = new ArrayList<>();

    public ResultsGridAdapter(Context context, ArrayList<String> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public int getCount() {
        return this.results.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder")
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.results_grid,
                parent,
                false
        );

        TextView resultTextView = view.findViewById(R.id.resultTextView);
        resultTextView.setText(results.get(position));
        return view;
    }
}
