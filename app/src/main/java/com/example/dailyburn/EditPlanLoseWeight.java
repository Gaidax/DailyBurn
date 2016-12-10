package com.example.dailyburn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class EditPlanLoseWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan_lose_weight);

    }
    public void onClick(View v) {
        Intent intent = new Intent(EditPlanLoseWeight.this, date_time_picker.class);
        Context context = getApplicationContext();
        CharSequence showText = ("Your Plan is being updated...!! ");
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, showText, duration);
        toast.show();
        startActivity(intent);

    }
}
