package com.example.dailyburn;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class editPlanHealthIssues extends AppCompatActivity {

    CheckBox item1, item2, item3, item4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan_health_issues);

        Button removeButton = (Button) findViewById(R.id.btnHeatlhRemove);
        item1 = (CheckBox) findViewById(R.id.foodItem01);
        item2 = (CheckBox) findViewById(R.id.foodItem02);
        item3 = (CheckBox) findViewById(R.id.foodItem03);
        item4 = (CheckBox) findViewById(R.id.foodItem04);


        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (item1.isChecked()) {
                    Toast.makeText(editPlanHealthIssues.this, "You removed " + item1.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(editPlanHealthIssues.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                } else if (item2.isChecked()) {
                    Toast.makeText(editPlanHealthIssues.this, "You removed " + item2.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(editPlanHealthIssues.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                } else if (item3.isChecked()) {
                    Toast.makeText(editPlanHealthIssues.this, "You removed " + item3.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(editPlanHealthIssues.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                }
                else if (item4.isChecked()) {
                    Toast.makeText(editPlanHealthIssues.this, "You removed " + item4.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(editPlanHealthIssues.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                }
                else {
                    Toast.makeText(editPlanHealthIssues.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
