package com.example.dailyburn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final String yourName = getIntent().getStringExtra("name");
        final String gender = getIntent().getStringExtra("gender");
        final String age = getIntent().getStringExtra("age");
        final String weight = getIntent().getStringExtra("weight");
        final String height = getIntent().getStringExtra("height");
        final String allergy = getIntent().getStringExtra("allergy");
        final String goal = getIntent().getStringExtra("goal");

        TextView welcome = (TextView)findViewById(R.id.txtWelcome) ;
        String message = ("Welcome to your home page " + yourName);
        welcome.setTextSize(18);
        welcome.setText(message);

        final RadioGroup group = (RadioGroup)findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                switch (id) {
                    case R.id.option1:
                        Intent intent = new Intent (MenuActivity.this, DefaultPlanView.class);
                        intent.putExtra("name", yourName);
                        intent.putExtra("gender", gender);
                        intent.putExtra("age", age);
                        intent.putExtra("weight", weight);
                        intent.putExtra("height", height);
                        intent.putExtra("allergy", allergy);
                        intent.putExtra("goal", goal);
                        startActivity(intent);
                }
            }
        });

    }
}
