package com.example.TestProject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.TestProject.R;

public class StartActivity extends Activity implements View.OnClickListener {
    Button buttonToApp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        buttonToApp = (Button) findViewById(R.id.button);
        buttonToApp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, ListInfoActivity.class));

    }
}
