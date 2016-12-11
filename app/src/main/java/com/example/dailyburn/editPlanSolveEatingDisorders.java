package com.example.dailyburn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class editPlanSolveEatingDisorders extends AppCompatActivity {

    CheckBox disorder01, disorder02, disorder03, disorder04;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan_solve_eating_disorders);

        Button removeButton = (Button) findViewById(R.id.btnDisorderRemove);
        disorder01 = (CheckBox) findViewById(R.id.disorderItem01);
        disorder02 = (CheckBox) findViewById(R.id.disorderItem02);
        disorder03 = (CheckBox) findViewById(R.id.disorderItem03);
        disorder04 = (CheckBox) findViewById(R.id.disorderItem04);


        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (disorder01.isChecked()) {
                    Toast.makeText(editPlanSolveEatingDisorders.this, "You removed " + disorder01.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(editPlanSolveEatingDisorders.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                } else if (disorder02.isChecked()) {
                    Toast.makeText(editPlanSolveEatingDisorders.this, "You removed " + disorder02.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(editPlanSolveEatingDisorders.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                } else if (disorder03.isChecked()) {
                    Toast.makeText(editPlanSolveEatingDisorders.this, "You removed " + disorder03.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(editPlanSolveEatingDisorders.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                }
                else if (disorder04.isChecked()) {
                    Toast.makeText(editPlanSolveEatingDisorders.this, "You removed " + disorder04.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(editPlanSolveEatingDisorders.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                }
                else {
                    Toast.makeText(editPlanSolveEatingDisorders.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
