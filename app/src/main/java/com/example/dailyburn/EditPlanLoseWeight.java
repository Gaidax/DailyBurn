package com.example.dailyburn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class EditPlanLoseWeight extends AppCompatActivity {

    CheckBox loseWeightItem1, loseWeightItem2, loseWeightItem3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan_lose_weight);

        Button removeButton = (Button) findViewById(R.id.btnLoseRemove);
        loseWeightItem1 = (CheckBox) findViewById(R.id.weightFood01);
        loseWeightItem2 = (CheckBox) findViewById(R.id.weightFood02);
        loseWeightItem3 = (CheckBox) findViewById(R.id.weightFood03);
      //  loseWeightItem4 = (CheckBox) findViewById(R.id.foodItem04);


        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (loseWeightItem1.isChecked()) {
                    Toast.makeText(EditPlanLoseWeight.this, "You removed " + loseWeightItem1.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(EditPlanLoseWeight.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                } else if (loseWeightItem2.isChecked()) {
                    Toast.makeText(EditPlanLoseWeight.this, "You removed " + loseWeightItem2.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EditPlanLoseWeight.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                } else if (loseWeightItem3.isChecked()) {
                    Toast.makeText(EditPlanLoseWeight.this, "You removed " + loseWeightItem3.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(EditPlanLoseWeight.this, date_time_picker.class);
                    Context context = getApplicationContext();
                    CharSequence showText = ("Your Plan is being updated...!! ");
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, showText, duration);
                    toast.show();
                    startActivity(intent);

                }

                else {
                    Toast.makeText(EditPlanLoseWeight.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
