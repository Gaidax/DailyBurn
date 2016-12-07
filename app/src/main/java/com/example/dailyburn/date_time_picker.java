package com.example.dailyburn;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class date_time_picker extends Activity implements  View.OnClickListener {

    Button btnDatePicker, btnTimePicker, btnSaveNotification;
    EditText txtDate, txtTime, reminderName;
    int mYear, mMonth, mDay, mHour, mMinute, mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder_notification);

        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        btnSaveNotification = (Button) findViewById(R.id.btnSet);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);
        reminderName = (EditText) findViewById(R.id.txtReminderName);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        btnSaveNotification.setOnClickListener(this);


    }

    public void onClick(View v) {

        String date = txtDate.getText().toString();
        String time = txtTime.getText().toString();
        String ReminderName = reminderName.getText().toString();

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();

        }

         else if (v == btnTimePicker) {

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            String AM_PM;
                            if (hourOfDay < 12) {
                                AM_PM = "AM";
                            } else {
                                AM_PM = "PM";
                            }

                            txtTime.setText(hourOfDay + ":" + minute + " " + AM_PM);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();

        }

        else if (ReminderName.length() == 0) {
            reminderName.requestFocus();
            reminderName.setError("Please Enter your Reminder Name !! ");
        }   else if (date.length() == 0) {
            txtDate.requestFocus();
            txtDate.setError("Please Select the Date to Proceed !! ");
        }
        else if (time.length() == 0) {
            txtTime.requestFocus();
            txtTime.setError("Please Select the desired time to Proceed !! ");
        }
        else {
            Intent intent = new Intent(date_time_picker.this, ProgressSurvey.class);
            Context context = getApplicationContext();
            CharSequence text = ("Thank You. You will be notified based on your chosen preferences !! ");
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            startActivity(intent);
        }
    }
}




