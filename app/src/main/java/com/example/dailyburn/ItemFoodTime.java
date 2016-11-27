package com.example.dailyburn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rukshar on 2016-11-25.
 */

public class ItemFoodTime {

    //food item, food name, date, time, consumed TF

    public DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ");

    private int _foodActionId;
    private int _foodId;
    // String _foodName;
    private float _quantityGrams;
    private int _profileID;
    private Date _dateYearMonthDayHourMinuteSecond;
    private boolean _confirmed;
    //= new Date(1800, 11, 20, 01, 49, 02);
    //yearMonthDay
    //Time _timeHourMinuteSecond;// = new Time(01,49, 02);


    // Empty constructor
    public ItemFoodTime() {

    }

    // const
    public ItemFoodTime(int actionFoodId, int foodId, float quantityGrams, int profileId, Date dateYearMonthDayHourMinuteSecond, boolean confirmed) {
        this._foodActionId = actionFoodId;
        this._foodId = foodId;
        this._quantityGrams = quantityGrams;
        this._profileID = profileId;
        this._dateYearMonthDayHourMinuteSecond = dateYearMonthDayHourMinuteSecond;
        this._confirmed = confirmed;
        // this._typeOfCuisine = typeOfCuisine;

    }

    // constructor
    public ItemFoodTime(int foodId, float quantityGrams, int profileId, Date dateYearMonthDayHourMinuteSecond, boolean confirmed) {
        this._foodId = foodId;
        this._quantityGrams = quantityGrams;
        this._profileID = profileId;
        this._dateYearMonthDayHourMinuteSecond = dateYearMonthDayHourMinuteSecond;
        this._confirmed = confirmed;
        //  this._typeOfCuisine = typeOfCuisine;

    }


    //getter setters
    public int get_foodActionId() {return _foodActionId;}

    public void set_foodActionId(int _foodActionId) {this._foodActionId = _foodActionId;}
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int get_foodId() {
        return _foodId;
    }

    public void set_foodId(int _foodId) {
        this._foodId = _foodId;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //public String get_foodName() {return _foodName;}

    //public void set_foodName(String _foodName) {this._foodName = _foodName;}
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int get_profileId() { return _profileID; }

    public void set_profileId(int _profileName) {this._profileID = _profileName;}

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public float get_quantityGrams() {return _quantityGrams;}

    public void set_quantityGrams(float _quantityGrams) {this._quantityGrams = _quantityGrams;}

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public Date get_date() {return _dateYearMonthDayHourMinuteSecond;}

    public void set_date(Date _date) {this._dateYearMonthDayHourMinuteSecond = _date;}

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean getIsConfirmed() {return _confirmed;}

    public void setIsConfirmed(boolean confirmed) {this._confirmed = confirmed;}





}

/*public class ItemFoodTime {
}*/
