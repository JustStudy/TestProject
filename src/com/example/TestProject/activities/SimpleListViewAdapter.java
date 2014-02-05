package com.example.TestProject.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.TestProject.R;

/**
 * Created by Ruslik on 05.02.14.
 */
public class SimpleListViewAdapter extends ArrayAdapter<String> {
    private final Context context;
    private String[] firstValues;
    private String secondValues;
    TextView nameTextView;
    TextView descriptionTextView;

    public SimpleListViewAdapter(Context context, int textViewResourceId, String[] firstValues) {
        super(context, textViewResourceId, firstValues);
        this.context = context;
        this.firstValues = firstValues;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.one_list_item_layout, parent, false);
        nameTextView = (TextView) rowView.findViewById(R.id.textView_firstTextID);
        descriptionTextView = (TextView) rowView.findViewById(R.id.textView_secondTextID);
        nameTextView.setText(firstValues[position]);
        secondValues = context.getResources().getString(R.string.just_press) + " " + firstValues[position];
        descriptionTextView.setText(secondValues);
        return rowView;
    }


}
