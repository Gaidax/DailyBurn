package com.example.dailyburn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    EditText editWeight, editHeight, editAge;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText)findViewById(R.id.txtName);
        editWeight = (EditText)findViewById(R.id.txtWeight);
        editHeight = (EditText)findViewById(R.id.txtHight);
        editAge = (EditText)findViewById(R.id.Age);
        group = (RadioGroup)findViewById(R.id.gender);


    }

    public void onClick(View view){
        String name = editName.getText().toString();
        String weight = editWeight.getText().toString();
        String height = editHeight.getText().toString();
        String age = editAge.getText().toString();

        int selectedId = group.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        String gender = radioButton.getText().toString();

        if(name.length() == 0)
        {
            editName.requestFocus();
            editName.setError("Field cannot be empty");
        }

        else if(!name.matches("[a-zA-Z ]+"))
        {
            editName.requestFocus();
            editName.setError("Enter only letters");
        }else if(age.length() == 0)
        {
            editAge.requestFocus();
            editAge.setError("Field cannot be empty");
        }else if(!age.matches("^[0-9]*$"))
        {
            editAge.requestFocus();
            editAge.setError("Enter only digit");
        }else if(Integer.parseInt(age)<16 || Integer.parseInt(age)>65)
        {
            editAge.requestFocus();
            editAge.setError("The value should be 16-65");
        }
        else if(height.length() == 0)
        {
            editHeight.requestFocus();
            editHeight.setError("Field cannot be empty");
        }else if(!height.matches("^[1-9]\\d*(\\.\\d+)?$"))
        {
            editHeight.requestFocus();
            editHeight.setError("Enter only digit and cannot be less than 0");
        }else if(Double.parseDouble(height)<80 ||Double.parseDouble(height)>200 )
        {
            editHeight.requestFocus();
            editHeight.setError("The value should be 80-200");
        }

        else if(weight.length() == 0)
        {
            editWeight.requestFocus();
            editWeight.setError("Field cannot be empty");
        }
        else if(!weight.matches("^[1-9]\\d*(\\.\\d+)?"))
        {
            editWeight.requestFocus();
            editWeight.setError("Enter only digit and cannot be less than 0");
        }else if(Double.parseDouble(weight)<30 ||Double.parseDouble(weight)>200)
        {
            editWeight.requestFocus();
            editWeight.setError("The value should be 30-200");
        }
        else if(selectedId == -1)
        {
            Toast.makeText(MainActivity.this,
                    "Please select your gender", Toast.LENGTH_LONG).show();
        }
        else{

            Spinner allergySpinner = (Spinner)findViewById(R.id.spinnerAllergy);
            String allergy = allergySpinner.getSelectedItem().toString();


            Spinner goalSpinner = (Spinner)findViewById(R.id.spinnerGoal);
            String goal = goalSpinner.getSelectedItem().toString();


            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("gender", gender);
            intent.putExtra("age", age);
            intent.putExtra("weight", weight);
            intent.putExtra("height", height);
            intent.putExtra("allergy", allergy);
            intent.putExtra("goal", goal);
            startActivity(intent);
        }

    }

}
