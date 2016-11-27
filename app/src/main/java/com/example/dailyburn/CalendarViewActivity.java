package com.example.dailyburn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CalendarViewActivity extends AppCompatActivity {

    CalendarView calendar;
    Button buttonEdit;
    Spinner spinnerAdditionType;//on change the list of items changes accordingly
    Spinner spinnerPlanTypeCalendar;
    TextView textCurrentlySelected;
    ScrollView scrollViewFoodItems;
    RelativeLayout tableLayout;
    //TableLayout scrollViewTableLayout;
    LinearLayout linearLayoutScrollLayout;
    //values
    int yearValue;
    int monthValue;
    int dayValue;

    int hourValue;
    int minuteValue;
    int secondValue;
    String amPmValue;

    ClientDatabase dbRF = new ClientDatabase(CalendarViewActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sets the main layout of the activity
        setContentView(R.layout.activity_calendar_view);
        //initializes the calendarview
        initializeCalendar();

        // dbRF.DropAll();


        buttonEdit = (Button) findViewById(R.id.editDay);
        textCurrentlySelected = (TextView) findViewById(R.id.textViewCurrentlySelectedDate);
        scrollViewFoodItems = (ScrollView) findViewById(R.id.scrollViewPlanRelatedItems);
        tableLayout = (RelativeLayout) findViewById(R.id.relativeLayoutCalendarView);
        // scrollViewTableLayout = (TableLayout) findViewById(R.id.scrollViewTableLayout);
        linearLayoutScrollLayout = (LinearLayout)findViewById(R.id.scrollViewLinearLayout);
        calendarPlanTypeSpinnerInitalize();
        addFoodTypeSpinner();

        // dateHistoryAddition();


    }


    public void initializeCalendar() {


        calendar = (CalendarView) findViewById(R.id.calendar);

        // sets whether to show the week number.
        calendar.setShowWeekNumber(false);

        // sets the first day of week according to Calendar.
        // here we set Monday as the first day of the Calendar
        calendar.setFirstDayOfWeek(2);
        calendar.setBackgroundColor(getResources().getColor(R.color.green));
        //The background color for the selected week.
        // calendar.setSelectedWeekBackgroundColor(getResources().getColor(R.color.green));

        //sets the color for the dates of an unfocused month.
        //calendar.setUnfocusedMonthDateColor(getResources().getColor(R.color.transparent));

        //sets the color for the separator line between weeks.
        //calendar.setWeekSeparatorLineColor(getResources().getColor(R.color.grey));

        //sets the color for the vertical bar shown at the beginning and at the end of the selected date.
        //calendar.setSelectedDateVerticalBar(R.color.darkgreen);

        //sets the listener to be notified upon selected date change.
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
                //buttonEdit.setText(year + "/" + month + "/" + day);
                textCurrentlySelected.setText(year + "/" + month + "/" + day);
                String dateSelectedATM = year + "/" + month + "/" + day;
                try {
                    uiOnDateSelect(dateSelectedATM);
                } catch (Exception e) {
                    Log.d("matt", "uiT");
                }

                //  List<TextView> foodItemNames;
                //   List<EditText> foodItemQuantity;
                //   List<Button> foodItemDelete;
                //     List<Spinner> foodItemConfirmation;

            }
        });


    }

    private void uiOnDateSelect(String dateSelectedATM) {
        //textview-edit item quantity- confirmation - removal
        Log.d("DebugMatthew", "MatthewYaw" + dateSelectedATM);

        String toBeParsed = "2016/11/22 11:00:00";

        Log.d("bedbug", "Matt" + dateSelectedATM);

        //List<ItemProfileInfo> itemProfileInfos = dbRF.getAllPROFILEITEMS();
        //List<ItemProfileInfo> itemProfileInfos = dbRF.getAllPROFILEITEMS();
        //if (itemProfileInfos.size() < 1){ Log.d("profileI", "broken");}
        //else {
        //    for (ItemProfileInfo item : itemProfileInfos) {
        //        Log.d("Profiles", item.getDayCreated() + "profile");
        //   }
        // }

        List<ItemFood> itemFoods = dbRF.getAllFOODITEM();
        for (ItemFood item: itemFoods){
            Log.d("foodItems", item.getFoodItemName()+" " + item.getFoodItemId());
        }

        //List<ItemFoodTime> itemCheck = dbRF.getAllItemFoodTime();
        //for (ItemFoodTime item : itemCheck){
        //    Log.d("foodTimeItems", item.get_date()+"foodTimeItems");
        // }
        dbRF.getAllFoodTimeByDateV2(dateSelectedATM);
        List<ItemFoodTime> itemFoodTimes = dbRF.getAllFoodTimeByDateV2(dateSelectedATM);
        if (itemFoodTimes.size() > 0) {

            try {

                for (final ItemFoodTime item : itemFoodTimes) {
                    Log.d("tyty", item.get_foodId()+"");
                    ItemFood fItem = dbRF.getFoodItem(item.get_foodId());
                    String fItemName = fItem.getFoodItemName();
                    Log.d("foodTimeW", fItemName);

                    // String foodNameOfCurrent = dbRF.getFoodItem(item.get_foodId()).getFoodItemName();

                    //TableRow tableRowAdd = new TableRow(this);

                    TextView textViewFoodItem = new TextView(this);
                    textViewFoodItem.setText(fItemName);
                    textViewFoodItem.setSingleLine();
                    //tableRowAdd.addView(textViewFoodItem);

                    EditText editTextFoodItemQuantity = new EditText(this);
                    editTextFoodItemQuantity.setTag(item.get_foodId() + "editText");
                    editTextFoodItemQuantity.setText(item.get_quantityGrams()+"");
                    editTextFoodItemQuantity.setTextSize(20);
                    editTextFoodItemQuantity.setSingleLine();
                    editTextFoodItemQuantity.setMaxWidth(80);
                    //editTextFoodItemQuantity.addTextChangedListener();

                    //editTextFoodItemQuantity.getLayout();
                    // ViewGroup.LayoutParams params = editTextFoodItemQuantity.getLayoutParams();
                    // params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    // editTextFoodItemQuantity.setLayoutParams(params);
                    //tableRowAdd.addView(editTextFoodItemQuantity);

                    CheckBox buttonFoodItemConfirmed = new CheckBox(this);
                    if (item.getIsConfirmed() == true){
                        buttonFoodItemConfirmed.setChecked(true);
                    }
                    else{
                        buttonFoodItemConfirmed.setChecked(false);
                    }
                    //buttonFoodItemConfirmed.setTag("checkBox" + item.get_foodId());
                    buttonFoodItemConfirmed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked){
                                item.setIsConfirmed(true);
                                dbRF.updateFoodItemTime(item);
                            }
                            else {item.setIsConfirmed(false);
                                dbRF.updateFoodItemTime(item);
                            }
                        }
                    });
                    buttonFoodItemConfirmed.setText("Eaten");
                    // tableRowAdd.addView(buttonFoodItemConfirmed);
                    linearLayoutScrollLayout.addView(textViewFoodItem);
                    linearLayoutScrollLayout.addView(editTextFoodItemQuantity);
                    linearLayoutScrollLayout.addView(buttonFoodItemConfirmed);
                }
            } catch (Exception e) {
                Log.d("Nope", "Nope");

            }
        }
    }

    private void dailyPlanScrollView() {

        TextView textViewTime = new TextView(this);
        textViewTime.setText("Time:");

        EditText editTextHour = new EditText(this);
        editTextHour.setSingleLine();
        editTextHour.setTextSize(20);
        editTextHour.setText("00");
        editTextHour.setWidth(50);


        EditText editTextMinute = new EditText(this);
        editTextMinute.setSingleLine();
        editTextMinute.setText("00");
        editTextMinute.setTextSize(20);
        editTextMinute.setWidth(50);

        EditText editTextSecond = new EditText(this);
        editTextSecond.setSingleLine();
        editTextSecond.setTextSize(20);
        editTextSecond.setWidth(50);

        ////////////////////////////////////////////////////////////////////////////////////////////
        final Spinner spinnerAmPm = new Spinner(this);
        List<String> spinnerAmPmArray = new ArrayList<String>();
        spinnerAmPmArray.add("am");
        spinnerAmPmArray.add("pm");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerAmPmArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAmPm.setAdapter(adapter);
        spinnerAmPm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                // Toast.makeText(getBaseContext(),list.get(position), Toast.LENGTH_SHORT).show();
                String selected = spinnerAmPm.getSelectedItem().toString();
                spinnerAmPm.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    private void addFoodTypeSpinner() {
        spinnerAdditionType = (Spinner) findViewById(R.id.spinnerAdditionType);
        List<String> spinnerArrayPlan = new ArrayList<String>();
        spinnerArrayPlan.add("Swift");
        spinnerArrayPlan.add("Food Search");
        spinnerArrayPlan.add("Recent");
        spinnerArrayPlan.add("Dish");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArrayPlan);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdditionType.setAdapter(adapter);

        spinnerAdditionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                // Toast.makeText(getBaseContext(),list.get(position), Toast.LENGTH_SHORT).show();
                String selected = spinnerAdditionType.getSelectedItem().toString();

                spinnerAdditionType.setSelection(position);
                spinnerAdditionType.toString();
                if (selected.equals("what ever the option was")) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }


    private void calendarPlanTypeSpinnerInitalize() {
        spinnerPlanTypeCalendar = (Spinner) findViewById(R.id.spinnerPlanTypeCalendar);
        List<String> spinnerArray = new ArrayList<String>();

        spinnerArray.add("Daily");
        spinnerArray.add("Weekly");
        spinnerArray.add("Monthly");
        //   spinnerArray.add("Yearly");
        // spinnerArray.add("Preset");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlanTypeCalendar.setAdapter(adapter);

        spinnerPlanTypeCalendar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                // Toast.makeText(getBaseContext(),list.get(position), Toast.LENGTH_SHORT).show();
                String selected = spinnerPlanTypeCalendar.getSelectedItem().toString();

                spinnerPlanTypeCalendar.setSelection(position);
                spinnerPlanTypeCalendar.toString();
                if (selected.equals("Daily")) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    public void dateHistoryAddition() {
        Intent intent = getIntent();
        String dateSelectedATM = intent.getStringExtra("DateIn");
        dbRF.getAllFoodTimeByDateV2(dateSelectedATM);
        List<ItemFoodTime> itemFoodTimes = dbRF.getAllFoodTimeByDateV2(dateSelectedATM);
        if (itemFoodTimes.size() > 0) {

            try {

                for (ItemFoodTime item : itemFoodTimes) {
                    Log.d("tyty", item.get_foodId()+"");
                    ItemFood fItem = dbRF.getFoodItem(item.get_foodId());
                    String fItemName = fItem.getFoodItemName();
                    Log.d("foodTimeW", fItemName);

                    String foodNameOfCurrent = dbRF.getFoodItem(item.get_foodId()).getFoodItemName();

                    TableRow tableRowAdd = new TableRow(this);

                    TextView textViewFoodItem = new TextView(this);
                    textViewFoodItem.setText(foodNameOfCurrent + " ");
                    textViewFoodItem.setSingleLine();
                    tableRowAdd.addView(textViewFoodItem);

                    EditText editTextFoodItemQuantity = new EditText(this);
                    //editTextFoodItemQuantity.setTag(item.get_foodId() + "editText");
                    editTextFoodItemQuantity.setTextSize(20);
                    editTextFoodItemQuantity.setSingleLine();
                    tableRowAdd.addView(editTextFoodItemQuantity);

                    Button buttonFoodItemConfirmed = new CheckBox(this);
                    //buttonFoodItemConfirmed.setTag("checkBox" + item.get_foodId());
                    buttonFoodItemConfirmed.setText("Eaten");
                    //tableRowAdd.addView(buttonFoodItemConfirmed);

                }
            } catch (Exception e) {
                Log.d("Nope", "Nope");

            }

        }
    }
}