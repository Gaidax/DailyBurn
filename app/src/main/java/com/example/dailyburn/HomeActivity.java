package com.example.dailyburn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final String yourName = getIntent().getStringExtra("name");
        final String gender = getIntent().getStringExtra("gender");
        final String age = getIntent().getStringExtra("age");
        final String weight = getIntent().getStringExtra("weight");
        final String height = getIntent().getStringExtra("height");
        final String allergy = getIntent().getStringExtra("allergy");
        final String goal = getIntent().getStringExtra("goal");

        TextView welcome = (TextView)findViewById(R.id.txtWelcome) ;
        String message = ("Welcome to your home page " + yourName);
        welcome.setTextSize(26);
        welcome.setText(message);

        final RadioGroup group = (RadioGroup)findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                switch (id) {
                    case R.id.option1:
                        Intent intent = new Intent (HomeActivity.this, defaultPlan.class);
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
