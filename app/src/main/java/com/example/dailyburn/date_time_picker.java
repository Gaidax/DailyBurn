package com.example.dailyburn;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class date_time_picker extends Activity implements  View.OnClickListener {

    private PendingIntent pendingIntent;
    Button btnDatePicker, btnTimePicker, btnSaveNotification;
    EditText txtDate, txtTime, reminderName;
    int mYear, mMonth, mDay, mHour, mMinute, mType;
    ClientDatabase dbRF;
    static int calendarday,calendarmonth,calendaryear,calendarhour,calendarminute,calendarampm;

   // Spinner feedbackSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder_notification);

        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
      //  dbRF = new ClientDatabase(this);

        btnSaveNotification = (Button) findViewById(R.id.btnSet);
     //   feedbackSpinner = (Spinner) findViewById(R.id.spinnerFeedback);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);
        reminderName = (EditText) findViewById(R.id.txtReminderName);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        btnSaveNotification.setOnClickListener(this);

      /*  Spinner reminderSpinner = (Spinner) findViewById(R.id.timeSpinner);
        reminderSpinner.setOnItemSelectedListener((OnItemSelectedListener) this);
        String text = reminderSpinner.getSelectedItem().toString();
       dbRF.addReminderItem(text);*/



    }


    public void onClick(View v) {

        String date = txtDate.getText().toString();
        String time = txtTime.getText().toString();
        String ReminderName = reminderName.getText().toString();
   //     String feedbackOptions = feedbackSpinner.getSelectedItem().toString();

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

                            txtDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            calendaryear=year;
                            calendarmonth=monthOfYear;
                            calendarday=dayOfMonth;

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
                                calendarampm=0;
                            } else {
                                AM_PM = "PM";
                                calendarampm=1;
                            }

                            txtTime.setText(hourOfDay + ":" + minute + " " + AM_PM);
                            calendarhour=(hourOfDay);
                            calendarminute=minute;
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
      /*  else if (feedbackSpinner.getSelectedItemId() == -1){
            Toast.makeText(date_time_picker.this,
                    "Please select your feedback notification", Toast.LENGTH_LONG).show();

        }*/
        else {
            Spinner reminderSpinner = (Spinner) findViewById(R.id.timeSpinner);
            // reminderSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
            String timeSelected = reminderSpinner.getSelectedItem().toString();
           // dbRF.addReminderItem(timeSelected);
          //  Intent intent = new Intent(date_time_picker.this, ProgressSurvey.class);
            Context context = getApplicationContext();
            CharSequence showText = ("Thank You. You will be notified based on your chosen preferences !! ");
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, showText, duration);
            toast.show();
           // startActivity(intent);
        }
        if(v==btnSaveNotification) {



            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.MONTH, calendarmonth);
            calendar.set(Calendar.YEAR, calendaryear);
            calendar.set(Calendar.DAY_OF_MONTH, calendarday);

            calendar.set(Calendar.HOUR_OF_DAY, calendarhour);
            calendar.set(Calendar.MINUTE, calendarminute);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.AM_PM,calendarampm);

            // txtview2.setText("year: "+calendaryear+" month:"+calendarmonth+" day: "+calendarday+" hour: "+calendarhour+" minute: "+calendarminute+" AM/PM: "+calendarampm);







            Intent myIntent = new Intent(date_time_picker.this, MyReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(date_time_picker.this, 0, myIntent,0);

            AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);





        }

    }


}




