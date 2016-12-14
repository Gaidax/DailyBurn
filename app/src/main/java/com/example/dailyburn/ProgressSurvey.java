package com.example.dailyburn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ProgressSurvey extends AppCompatActivity {


    ClientDatabase dbRF;
    String response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_survey);

        dbRF = new ClientDatabase(this);


        RadioGroup  group = (RadioGroup)findViewById(R.id.radioGroup);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if(checkedId == R.id.btnYes){
                    response  = "Yes, I followed my Plan";
                }
                else if(checkedId == R.id.btnNo){
                    response = "No, I did not follow my Plan";
                }
                dbRF.addFeedbackItem(response);
                Intent intent = new Intent(ProgressSurvey.this, Summary.class);
                CharSequence text = ("You selected " +response+ "\n Your response is stored");
                int duration = Toast.LENGTH_SHORT;
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                startActivity(intent);
                /*Toast.makeText(ProgressSurvey.this, "You selected " +response+ "\n Your response is stored",
                        Toast.LENGTH_LONG).show();*/

            }


        });

    }
}
