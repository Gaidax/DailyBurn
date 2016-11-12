package com.example.dailyburn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class TrueMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_menu);

        Intent i = getIntent();

        String yourName = i.getStringExtra("name");

        String message = ("Welcome to your home page " + yourName);
        TextView textView = new TextView(this);
        textView.setTextSize(26);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_true_menu);
        layout.addView(textView);
    }
}
