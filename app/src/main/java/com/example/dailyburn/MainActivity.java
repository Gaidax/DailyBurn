package com.example.dailyburn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerAge;
    EditText editName;
    EditText editWeight, editHeight;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItemsOnSpinner();

        editName = (EditText)findViewById(R.id.txtName);
        editWeight = (EditText)findViewById(R.id.txtWeight);
        editHeight = (EditText)findViewById(R.id.txtHight);
        group = (RadioGroup)findViewById(R.id.gender);

    }

    // add items into spinner dynamically
    public void addItemsOnSpinner() {

        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        List<Integer> list = new ArrayList<Integer>();
        for(int i=12; i<=65;i++)
        {
            list.add(i);
        }

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(dataAdapter);
    }

    public void onClick(View view){
        String name = editName.getText().toString();
        String weight = editWeight.getText().toString();
        String height = editHeight.getText().toString();

        int selected = group.getCheckedRadioButtonId();


        if(name.length() == 0)
        {
            editName.requestFocus();
            editName.setError("Field cannot be empty");
        }

        else if(!name.matches("[a-zA-Z ]+"))
        {
            editName.requestFocus();
            editName.setError("Enter only letters");
        }
        else if(height.length() == 0)
        {
            editHeight.requestFocus();
            editHeight.setError("Field cannot be empty");
        }else if(!height.matches("^[1-9]\\d*(\\.\\d+)?$"))
        {
            editHeight.requestFocus();
            editHeight.setError("Enter only digit and cannot be less than 0");
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
        }
        else if(selected == -1)
        {
            Toast.makeText(MainActivity.this,
                    "Please select your gender", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this,
                    "Your information is stored", Toast.LENGTH_LONG).show();
        }

    }

}
