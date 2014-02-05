package com.example.TestProject.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import com.example.TestProject.R;

/**
 * Created by Ruslik on 05.02.14.
 */
public class DetailInfoActivity extends ActionBarActivity {
    TextView titleTextView;
    TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        titleTextView = (TextView) findViewById(R.id.textViewTitle);
        descriptionTextView = (TextView) findViewById(R.id.textViewDetailArticle);
        String string = getIntent().getStringExtra(Constants.NAME_FOR_INTENT_STRING_TITLE);
        String desc = getIntent().getStringExtra(Constants.NAME_FOR_INTENT_STRING_DESC);
        getSupportActionBar().setTitle(string);
        titleTextView.setText(string);
        descriptionTextView.setText(desc);


    }
}
