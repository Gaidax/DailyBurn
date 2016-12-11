package com.example.dailyburn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class EditPlanGainMuscle extends AppCompatActivity {

    CheckBox food01, food02, food03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan_gain_muscle);

        Button removeButton = (Button) findViewById(R.id.btnRemove);
        food01 = (CheckBox) findViewById(R.id.chkFood01);
        food02 = (CheckBox) findViewById(R.id.chkFood02);
        food03 = (CheckBox) findViewById(R.id.chkFood03);

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (food01.isChecked()) {
                    Toast.makeText(EditPlanGainMuscle.this, "You removed " + food01.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(EditPlanGainMuscle.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                } else if (food02.isChecked()) {
                    Toast.makeText(EditPlanGainMuscle.this, "You selected " + food02.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EditPlanGainMuscle.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                } else if (food03.isChecked()) {
                    Toast.makeText(EditPlanGainMuscle.this, "You selected " + food03.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(EditPlanGainMuscle.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                } else {
                    Toast.makeText(EditPlanGainMuscle.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

