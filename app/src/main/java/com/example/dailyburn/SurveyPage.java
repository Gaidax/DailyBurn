package com.example.dailyburn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SurveyPage extends AppCompatActivity {

    EditText editName;
    EditText editWeight, editHeight, editAge;
    RadioGroup group;
    String name, weight, height, age, gender, allergy, goal;
    Date dateCreated;
    String formattedDate;
    ClientDatabase dbRF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_survey);

        dbRF = new ClientDatabase(SurveyPage.this);


        editName = (EditText)findViewById(R.id.txtName);
        editWeight = (EditText)findViewById(R.id.txtWeight);
        editHeight = (EditText)findViewById(R.id.txtHight);
        editAge = (EditText)findViewById(R.id.Age);
        group = (RadioGroup)findViewById(R.id.gender);

        Button submit = (Button)findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editName.getText().toString();
                weight = editWeight.getText().toString();
                height = editHeight.getText().toString();
                age = editAge.getText().toString();

                int selectedId = group.getCheckedRadioButtonId();
//        RadioButton radioButton = (RadioButton) findViewById(selectedId);
//        String gender = radioButton.getText().toString();

                if(name.length() == 0)
                {
                    editName.requestFocus();
                    editName.setError("Name cannot be empty");
                }

                else if(!name.matches("[a-zA-Z ]+"))
                {
                    editName.requestFocus();
                    editName.setError("Enter only letters");
                } else if(selectedId == -1)
                {
                    Toast.makeText(SurveyPage.this,
                            "Please select your gender", Toast.LENGTH_LONG).show();
                }
                else if(age.length() == 0)
                {
                    editAge.requestFocus();
                    editAge.setError("Age cannot be empty");
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
                    editHeight.setError("Height cannot be empty");
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
                    editWeight.setError("Weight cannot be empty");
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

                else{

                    Spinner allergySpinner = (Spinner)findViewById(R.id.spinnerAllergy);
                    allergy = allergySpinner.getSelectedItem().toString();
                    RadioButton radioButton = (RadioButton) findViewById(selectedId);
                    gender = radioButton.getText().toString();


                    Spinner goalSpinner = (Spinner)findViewById(R.id.spinnerGoal);
                    goal = goalSpinner.getSelectedItem().toString();
                    Calendar c = Calendar.getInstance();
//
                    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss aa");
                    formattedDate = df.format(c.getTime());

                    addProfileItem(dbRF);

                    Intent intent = new Intent(SurveyPage.this, MenuActivity.class);
                    intent.putExtra("goal", goal);
                    intent.putExtra("name", name);
                    intent.putExtra("age", age);
                    intent.putExtra("weight", weight);
                    intent.putExtra("height", height);
                    intent.putExtra("allergy", allergy);
                    intent.putExtra("goal", goal);
                    Context context = getApplicationContext();
                    CharSequence text = ("Your information is now stored in the app.");
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    startActivity(intent);

                    startActivity(intent);
                }
            }
        });

    }
    public void onClear(View view) {
        editName.getText().clear();
        editAge.getText().clear();
        editHeight.getText().clear();
        editWeight.getText().clear();
        group.clearCheck();
        getCurrentFocus().clearFocus();
    }

    void addProfileItem(ClientDatabase dbRF){

        int _currentId = 7777;
        int _currentVersion = 1;
        String _profileName = name;
        float _weightKg = Float.parseFloat(weight);
        float _heightCm = Float.parseFloat(height);
        int _age = Integer.parseInt(age);
        String _gender = gender;
        String _role = goal;
        String _allergy = allergy;
        Date _dayCreated = null;
        Date _dayReplaced = null;

//        String toBeParsed = "2016/11/1 11:00:00 am";
        String toBeParsed2 = "2016/11/1   11:00:00 am";


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss aa");
        try {
            _dayCreated = formatter.parse(formattedDate);
            _dayReplaced = formatter.parse(toBeParsed2);

        } catch(Exception e){}
        ItemProfileInfo itemProfileInfo = new ItemProfileInfo(7777,_currentVersion, _profileName, _weightKg, _heightCm, _age, _gender, _role, _allergy, _dayCreated, _dayReplaced);
        dbRF.addProfileItem(itemProfileInfo);
    }


   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_page);
    }*/
}

/*public class SurveyPage extends AppCompatActivity {

    EditText editName;
    EditText editWeight, editHeight, editAge;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_survey);

        editName = (EditText)findViewById(R.id.txtName);
        editWeight = (EditText)findViewById(R.id.txtWeight);
        editHeight = (EditText)findViewById(R.id.txtHight);
        editAge = (EditText)findViewById(R.id.Age);
        group = (RadioGroup)findViewById(R.id.gender);

    }
    public void onClear(View view) {
        editName.getText().clear();
        editAge.getText().clear();
        editHeight.getText().clear();
        editWeight.getText().clear();
        group.clearCheck();
        getCurrentFocus().clearFocus();
  }

    public void onClick(View view){
        String name = editName.getText().toString();
        String weight = editWeight.getText().toString();
        String height = editHeight.getText().toString();
        String age = editAge.getText().toString();


        int selectedId = group.getCheckedRadioButtonId();
     //   RadioButton radioButton = (RadioButton) findViewById(selectedId);
        // String gender = radioButton.getText().toString();

        if(name.length() == 0)
        {
            editName.requestFocus();
            editName.setError("Name cannot be empty");
        }

        else if(!name.matches("[a-zA-Z ]+"))
        {
            editName.requestFocus();
            editName.setError("Enter only letters");

        }else if(selectedId == -1)
        {
            Toast.makeText(SurveyPage.this,
                    "Please select your gender", Toast.LENGTH_LONG).show();
        }
        else if(age.length() == 0)
        {
            editAge.requestFocus();
            editAge.setError("Age cannot be empty");
        }else if(!age.matches("^[0-9]*$"))
        {
            editAge.requestFocus();
            editAge.setError("Enter only whole numbers");
        }else if(Integer.parseInt(age)<16 || Integer.parseInt(age)>65)
        {
            editAge.requestFocus();
            editAge.setError("The value should be 16-65");
        }
        else if(height.length() == 0)
        {
            editHeight.requestFocus();
            editHeight.setError("Height cannot be empty");
        }else if(!height.matches("^[1-9]\\d*(\\.\\d+)?$"))
        {
            editHeight.requestFocus();
            editHeight.setError("Enter only numbers and it cannot be less than 0");
        }else if(Double.parseDouble(height)<80 ||Double.parseDouble(height)>200 )
        {
            editHeight.requestFocus();
            editHeight.setError("The value should be 80-200");
        }

        else if(weight.length() == 0)
        {
            editWeight.requestFocus();
            editWeight.setError("Weight cannot be empty");
        }
        else if(!weight.matches("^[1-9]\\d*(\\.\\d+)?"))
        {
            editWeight.requestFocus();
            editWeight.setError("Enter only numbers and it cannot be less than 0");
        }else if(Double.parseDouble(weight)<30 ||Double.parseDouble(weight)>200)
        {
            editWeight.requestFocus();
            editWeight.setError("The value should be 30-200");
        }

        else{

            Spinner allergySpinner = (Spinner)findViewById(R.id.spinnerAllergy);
            String allergy = allergySpinner.getSelectedItem().toString();


            Spinner goalSpinner = (Spinner)findViewById(R.id.spinnerGoal);
            String goal = goalSpinner.getSelectedItem().toString();


            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra("name", name);
       //     intent.putExtra("gender", gender);
            intent.putExtra("age", age);
            intent.putExtra("weight", weight);
            intent.putExtra("height", height);
            intent.putExtra("allergy", allergy);
            intent.putExtra("goal", goal);
            Context context = getApplicationContext();
            CharSequence text = ("Your information is now stored in the app.");
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            startActivity(intent);

        }

    }



}*/
