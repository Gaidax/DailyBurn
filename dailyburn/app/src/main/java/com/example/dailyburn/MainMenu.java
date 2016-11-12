package com.example.dailyburn;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void onClick(View v)
    {
        //EditText Name = (EditText)findViewById(R.id.txtName);
        //EditText age = (EditText)findViewById(R.id.Age);
        //EditText height = (EditText)findViewById(R.id.txtHeight);
        //EditText weight = (EditText)findViewById(R.id.txtWeight);

        //String yourName = Name.getText().toString().trim();
        //int Year = Integer.parseInt(age.getText().toString());
        //int Height = Integer.parseInt(height.getText().toString());
        //int Weight = Integer.parseInt(weight.getText().toString());
        //if(yourName.isEmpty() || yourName.length()==0 || yourName.equals("") || yourName == null){

          //  Intent intent = new Intent(this, MainMenu.class);
            //Context context = getApplicationContext();
            //CharSequence text = ("Error: Empty name.");
            //int duration = Toast.LENGTH_SHORT;
            //Toast toast = Toast.makeText(context, text, duration);
            //toast.show();
            //startActivity(intent);
        //}

    Intent intent = new Intent(this, TrueMenu.class);
    EditText name = (EditText) findViewById(R.id.txtName);
    String NameA = name.getText().toString();
        intent.putExtra("name", NameA);
        Context context = getApplicationContext();
        CharSequence text = ("Your information is now stored in the app.");
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        startActivity(intent);
    }

    public void menuChoice(View view)
    {
        boolean click = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.option1:
                if (click) {
                    //Build health plan here
                    setContentView(R.layout.activity_health_plan__calendar);
                }
                break;
            case R.id.option2:
                if (click) {
                    //change preference here
                    //setContentView(R.layout.);
                }
                break;
            case R.id.option3:
                if (click) {
                    //need help here
                    //setContentView(R.layout.);
                }
                break;
        }
    }
}
