package com.example.dailyburn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Rukshar on 2016-11-25.
 */

public class ClientDatabase extends SQLiteOpenHelper {

    // All Static variables
    // Database Version

    /*
    int _foodActionId;

    int _foodId;
    String _foodName;
    float _quantityGrams;

    String _profileID;


    Date _dateYearMonthDay;// = new Date(1800, 11, 20);
    Time _timeHourMinuteSecond;// = new Time(01,49, 02);

    boolean _confirmed;
    */
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "consumptionHistoryManager.db";

    // tables
    private static final String TABLE_FOOD_HISTORY = "foodItemHistoryTable";
    private static final String TABLE_PROFILES = "profileTable";
    //private static final String TABLE_LIKEDFOODS = "LikedFoodsTable";
    //private static final String TABLE_RECENTFOODITEMS = "RecentFoodItemsTable";
    private static final String TABLE_RESTRICTEDDISLIKEDFOODITEMS = "restrictedDislikedFoodItemsTable";
    private static final String TABLE_FOOD_ITEMS = "foodItemsTable";
    private static final String TABLE_NOTIFICATIONS_ITEMS = "notificationsSelections";// TABLE TO STORE USER NORIFICATIONS
    private static final String TABLE_FEEDBACK_ITEMS = "feedbackSelections";
    //Food Item Table
    //

    //Profile Table
    //

    // Feedback table Items

  /*  private static  final String KEY_FeedBack_ID = "feedbackID";
    private static final String KEY_FeedBack_Yes = "feedbackYes";
    private static final String KEY_FeedBack_No = "feedbackNo";*/


    //Food item history table
    private static final String KEY_FOODHISTORY_PRIMARYID = "foodHistoryPKID";
    private static final String KEY_FOODHISTORY_FOODID = "foodHistoryFoodId";
    //private static final String KEY_FOODHISTORY_FOODNAME = "foodName";
    private static final String KEY_FOODHISTORY_QUANTITYGRAMS = "foodHistoryQuantityGrams";
    private static final String KEY_FOODHISTORY_PROFILEID = "foodHistoryProfileID";
    private static final String KEY_FOODHISTORY_DATETIMESET = "foodHistoryDateTime";
    private static final String KEY_FOODHISTORY_CONFIRMEDCONSUMPTION = "foodHistoryConfirmedConsumption";

    private static final String KEY_PROFILE_ID = "profileId";
    private static final String KEY_PROFILE_CURRENTVERSION = "profileCurrentVersion";
    private static final String KEY_PROFILE_NAME = "profileName";
    private static final String KEY_PROFILE_WEIGHTKG = "profileWeightKG";
    private static final String KEY_PROFILE_AGE = "profileAge";
    private static final String KEY_PROFILE_GENDER = "profileGender";
    private static final String KEY_PROFILE_OBJECTIVES = "profileObjectives";
    private static final String KEY_PROFILE_DAYCREATED = "profileDayCreated";
    private static final String KEY_PROFILE_DAYREPLACED = "profileDayReplaced";

    private static final String KEY_RESTRICTEDITEM_ID = "restrictedItemId";
    private static final String KEY_RESTRICTEDITEM_FOODID = "restrictedItemFoodId";
    private static final String KEY_RESTRICTEDITEM_TAG = "restrictedItemTag";
    private static final String KEY_RESTRICTEDITEM_MAXQUANTITY_GRAMS = "restrictedItemMaxQuantityGrams";

    private static final String KEY_FOODITEM_ID = "foodItemId";
    private static final String KEY_FOODITEM_NAME = "foodItemName";
    private static final String KEY_FOODITEM_TAGS = "foodItemTags";
    private static final String KEY_FOODITEM_NUTRITIONFACTS = "foodItemNutritionFacts";
    private static final String KEY_FOODITEM_MINERALFACTS = "foodItemMineralFacts";
    private static final String KEY_FOODITEM_VITAMINFACTS = "foodItemVitaminFacts";
    private static final String KEY_FOODITEM_DESCRIPTION = "foodItemDescription";


    // NOTIFICATIONS TABLE ITEMS
  /*  private static final String KEY_REMINDER_NOTIFICATIONS_ID = "remindNotificationsID";
    private static final String KEY_REMINDER_NAME = "reminderName";
  //  private static final String FEEDBACK_NOTIFICATIONS_ID = "feedbackNotificationsID";*/



    public ClientDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override    public void onCreate(SQLiteDatabase db) {

        final String CREATE_FOOD_HISTORY_TABLE = "CREATE TABLE " +  TABLE_FOOD_HISTORY + " ( "
                + KEY_FOODHISTORY_PRIMARYID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_FOODHISTORY_FOODID + " INTEGER, "//foreign key
                + KEY_FOODHISTORY_QUANTITYGRAMS + " REAL, "//quantity/ joules
                + KEY_FOODHISTORY_PROFILEID + " INTEGER, "
                + KEY_FOODHISTORY_DATETIMESET + " TEXT, "
                + KEY_FOODHISTORY_CONFIRMEDCONSUMPTION + " INTEGER, "
                + " FOREIGN KEY ("+KEY_FOODHISTORY_FOODID+") REFERENCES "+TABLE_FOOD_ITEMS+" ("+ KEY_FOODITEM_ID +") , "
                + " FOREIGN KEY ("+KEY_FOODHISTORY_PROFILEID+") REFERENCES "+TABLE_PROFILES+" ("+ KEY_PROFILE_ID +")"
                + ");";



        final String CREATE_PROFILE_TABLE = "CREATE TABLE " + TABLE_PROFILES + " ( "
                + KEY_PROFILE_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_PROFILE_CURRENTVERSION + " INTEGER, "
                + KEY_PROFILE_NAME + " TEXT, "
                + KEY_PROFILE_WEIGHTKG + " REAL, "
                + KEY_PROFILE_AGE + " INTEGER, "
                + KEY_PROFILE_GENDER + " TEXT, "
                + KEY_PROFILE_OBJECTIVES + " TEXT, "
                + KEY_PROFILE_DAYCREATED + " TEXT, "
                + KEY_PROFILE_DAYREPLACED + " TEXT "
                + ");";


        final String CREATE_RESTRICTED_ITEMS_TABLE = "CREATE TABLE " + TABLE_RESTRICTEDDISLIKEDFOODITEMS + " ( "
                + KEY_RESTRICTEDITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_RESTRICTEDITEM_FOODID + " INTEGER, "
                + KEY_RESTRICTEDITEM_TAG + " TEXT, "//delimeter required
                + KEY_RESTRICTEDITEM_MAXQUANTITY_GRAMS + " REAL, "
                + " FOREIGN KEY ("+KEY_RESTRICTEDITEM_FOODID+") REFERENCES "+TABLE_FOOD_ITEMS+" ("+ KEY_FOODITEM_ID +") "
                + ");";



        final String CREATE_FOOD_ITEMS_TABLE = "CREATE TABLE " + TABLE_FOOD_ITEMS + " ("
                + KEY_FOODITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_FOODITEM_NAME + " TEXT, "
                + KEY_FOODITEM_TAGS + " TEXT, "
                + KEY_FOODITEM_NUTRITIONFACTS + " TEXT, "
                + KEY_FOODITEM_MINERALFACTS + " TEXT, "
                + KEY_FOODITEM_VITAMINFACTS + " TEXT, "
                + KEY_FOODITEM_DESCRIPTION + " TEXT "
                + ");";

      /*  final String CREATE_FEEDBACK_ITEMS_TABLE = "CREATE TABLE " + TABLE_FEEDBACK_ITEMS + " ( "
                + KEY_FeedBack_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_FeedBack_Yes + "TEXT ,"
                + KEY_FeedBack_No + "TEXT ,"
                + "FOREIGN KEY ("+KEY_FeedBack_ID +") REFERENCES "+TABLE_PROFILES+" ("+KEY_PROFILE_ID+")"
                +");";*/

        /*final String CREATE_NOTIFICATIONS_TABLE = "CREATE TABLE " + TABLE_NOTIFICATIONS_ITEMS + " ("
                + KEY_REMINDER_NOTIFICATIONS_ID + "INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + KEY_REMINDER_NAME + "TEXT "
                + ");";*/
             //   + "FOREIGN KEY ("+KEY_REMINDER_NOTIFICATIONS_ID+") REFERENCES "+TABLE_PROFILES+" ("+KEY_PROFILE_ID+"));";
        try {
            db.execSQL(CREATE_FOOD_ITEMS_TABLE);
            db.execSQL(CREATE_PROFILE_TABLE);
            db.execSQL(CREATE_RESTRICTED_ITEMS_TABLE);
            db.execSQL(CREATE_FOOD_HISTORY_TABLE);
          //  db.execSQL(CREATE_FEEDBACK_ITEMS_TABLE);
          //  db.execSQL(CREATE_NOTIFICATIONS_TABLE);
        } catch(Exception e){
            Log.d("boom", "---------------------------------------------------------");}
    }

    /*  public void createTables(){
          SQLiteDatabase db = getWritableDatabase();

          String CREATE_FOOD_HISTORY_TABLE = "CREATE TABLE " +  TABLE_FOOD_HISTORY + "( "
                  + KEY_FOODHISTORY_PRIMARYID + " INTEGER PRIMARY KEY, "
                  + KEY_FOODHISTORY_FOODID + " INTEGER, "//foreign key
                  + KEY_FOODHISTORY_QUANTITYGRAMS + " REAL, "//quantity/ joules
                  + KEY_FOODHISTORY_PROFILEID + " INTEGER, "
                  + KEY_FOODHISTORY_DATETIMESET + " TEXT, "
                  + KEY_FOODHISTORY_CONFIRMEDCONSUMPTION + " INTEGER, "
                  + " FOREIGN KEY ("+KEY_FOODHISTORY_FOODID+") REFERENCES "+TABLE_FOOD_ITEMS+" ("+ KEY_FOODITEM_ID +"), "
                  + " FOREIGN KEY ("+KEY_FOODHISTORY_PROFILEID+") REFERENCES "+TABLE_PROFILES+" ("+ KEY_PROFILE_ID +")"
                  + ");";



          String CREATE_PROFILE_TABLE = "CREATE TABLE " + TABLE_PROFILES + "( "
                  + KEY_PROFILE_ID  + " INTEGER PRIMARY KEY, "
                  + KEY_PROFILE_CURRENTVERSION + " INTEGER, "
                  + KEY_PROFILE_NAME + " TEXT, "
                  + KEY_PROFILE_WEIGHTKG + " REAL, "
                  + KEY_PROFILE_AGE + " INTEGER, "
                  + KEY_PROFILE_GENDER + " TEXT, "
                  + KEY_PROFILE_OBJECTIVES + " TEXT, "
                  + KEY_PROFILE_DAYCREATED + " TEXT, "
                  + KEY_PROFILE_DAYREPLACED + " TEXT "
                  + ");";


          String CREATE_RESTRICTED_ITEMS_TABLE = "CREATE TABLE " + TABLE_RESTRICTEDDISLIKEDFOODITEMS + "("
                  + KEY_RESTRICTEDITEM_ID + " INTEGER PRIMARY KEY, "
                  + KEY_RESTRICTEDITEM_FOODID + " INTEGER, "
                  + KEY_RESTRICTEDITEM_TAG + " TEXT, "//delimeter required
                  + KEY_RESTRICTEDITEM_MAXQUANTITY_GRAMS + " REAL, "
                  + " FOREIGN KEY ("+KEY_RESTRICTEDITEM_FOODID+") REFERENCES "+TABLE_FOOD_ITEMS+" ("+ KEY_FOODITEM_ID +"));";



          String CREATE_FOOD_ITEMS_TABLE = "CREATE TABLE " + TABLE_FOOD_ITEMS + "("
                  + KEY_FOODITEM_ID + " INTEGER PRIMARY KEY, "
                  + KEY_FOODITEM_NAME + " TEXT, "
                  + KEY_FOODITEM_TAGS + " TEXT, "
                  + KEY_FOODITEM_NUTRITIONFACTS + " TEXT, "
                  + KEY_FOODITEM_MINERALFACTS + " TEXT, "
                  + KEY_FOODITEM_VITAMINFACTS + " TEXT, "
                  + KEY_FOODITEM_DESCRIPTION + " TEXT "
                  + ");";

          db.execSQL(CREATE_FOOD_ITEMS_TABLE);
          db.execSQL(CREATE_PROFILE_TABLE);
          db.execSQL(CREATE_RESTRICTED_ITEMS_TABLE);
          db.execSQL(CREATE_FOOD_HISTORY_TABLE);

      }*/
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD_HISTORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTRICTEDDISLIKEDFOODITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD_ITEMS);
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATIONS_ITEMS);
      //  db.execSQL("DROP TABLE IF EXSISTS" +TABLE_FEEDBACK_ITEMS);
        // Create tables again
        onCreate(db);
    }

    void TableDrops(SQLiteDatabase db) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD_HISTORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTRICTEDDISLIKEDFOODITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD_ITEMS);
     //   db.execSQL("DROP TABLE IF EXISTS" +TABLE_NOTIFICATIONS_ITEMS);
      //  db.execSQL("DROP TABLE IF EXISTS" +TABLE_FEEDBACK_ITEMS);
        //  onCreate(db);
    }

     /*void DropAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD_HISTORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTRICTEDDISLIKEDFOODITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD_ITEMS);
    }*/
///////////////////////////////////////////////////////////
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    void addFoodItemToHistory(ItemFoodTime ItemFoodTime) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FOODHISTORY_FOODID, ItemFoodTime.get_foodId()); // Restaurant Name
        values.put(KEY_FOODHISTORY_QUANTITYGRAMS , ItemFoodTime.get_quantityGrams());
        values.put(KEY_FOODHISTORY_PROFILEID , ItemFoodTime.get_profileId());
        values.put(KEY_FOODHISTORY_DATETIMESET, parseDateToString(ItemFoodTime.get_date()) );
        values.put(KEY_FOODHISTORY_CONFIRMEDCONSUMPTION, ItemFoodTime.getIsConfirmed());
        // Inserting Row
        db.insert(TABLE_FOOD_HISTORY, null, values);
        db.close(); // Closing database connection
    }


    // new simpleDateFormat("yyyy/MM/dd HH:mm:ss") {

    // Getting single item
    ItemFoodTime getFoodItemToHistory(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOOD_HISTORY, new String[] {KEY_FOODHISTORY_PRIMARYID,
                        KEY_FOODHISTORY_QUANTITYGRAMS, KEY_FOODHISTORY_PROFILEID, KEY_FOODHISTORY_DATETIMESET,
                        KEY_FOODHISTORY_CONFIRMEDCONSUMPTION }, KEY_FOODHISTORY_PRIMARYID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
//int actionFoodId, int foodId, float quantityGrams, String profileId, Date dateYearMonthDayHourMinuteSecond, boolean confirmed)
        ItemFoodTime ItemFoodTime = new ItemFoodTime(Integer.parseInt(cursor.getString(0)),
                Float.parseFloat(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                parseStringToDate(cursor.getString(3)), intToBool(Integer.parseInt(cursor.getString(4))));
        cursor.close();
        db.close();
        // return Restaurant
        return ItemFoodTime;
    }


    // Getting All item
    public List<ItemFoodTime> getAllItemFoodTime() {
        List<ItemFoodTime> itemList = new ArrayList<ItemFoodTime>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOOD_HISTORY + ";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemFoodTime item = new ItemFoodTime();
                item.set_foodActionId(Integer.parseInt(cursor.getString(0))); //setID(Integer.parseInt(cursor.getString(0)));
                item.set_foodId(Integer.parseInt(cursor.getString(1)));
                item.set_quantityGrams(Float.parseFloat(cursor.getString(2)));
                item.set_profileId(Integer.parseInt(cursor.getString(3)));
                item.set_date(parseStringToDate(cursor.getString(4)));
                item.setIsConfirmed(intToBool(Integer.parseInt(cursor.getString(5))));

                //setName(cursor.getString(1));
                //setFoodType(cursor.getString(2));
                // Adding item to list
                itemList.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        // return item list
        return itemList;
    }

    public List<ItemFoodTime> getAllFoodTimeByDateV2(String dateIn){
        List<ItemFoodTime> checker = getAllItemFoodTime();
        List<ItemFoodTime> checked = new ArrayList<ItemFoodTime>();
        //date in = 1996/11/23
        //to convert this to format Tue Nov 22 11:00:00 EST 2016
        //
        int day;
        int month;
        int year;
        for (ItemFoodTime item : checker){
            day = item.get_date().getDate();
            month = item.get_date().getMonth();
            year = item.get_date().getYear();
            String getChecked = ((year+1900)+"/"+month+"/"+day);

            // Log.d("Checker", "dateIn:"+dateIn  );
            // Log.d("Checker", "itemDate:"+(year+1900)+"/"+month+"/"+day);
            if (getChecked.equals(dateIn)){
                checked.add(item);
            }
        }
        return checked;
    }

    // Getting All item
    public List<ItemFoodTime> getAllItemFoodTimeByDate(String dateIn) {
        List<ItemFoodTime> itemList = new ArrayList<ItemFoodTime>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOOD_HISTORY + " WHERE " + KEY_FOODHISTORY_DATETIMESET + " LIKE '" + dateIn + "%' " ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemFoodTime item = new ItemFoodTime();
                item.set_foodActionId(Integer.parseInt(cursor.getString(0))); //setID(Integer.parseInt(cursor.getString(0)));
                item.set_foodId(Integer.parseInt(cursor.getString(1)));
                item.set_quantityGrams(Float.parseFloat(cursor.getString(2)));
                item.set_profileId(Integer.parseInt(cursor.getString(3)));
                item.set_date(parseStringToDate(cursor.getString(4)));
                item.setIsConfirmed(intToBool(Integer.parseInt(cursor.getString(5))));

                //setName(cursor.getString(1));
                //setFoodType(cursor.getString(2));
                // Adding item to list
                itemList.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return item list
        return itemList;
    }


    // Updating single item
    public void updateFoodItemTime(ItemFoodTime itemFoodTime) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FOODHISTORY_FOODID, itemFoodTime.get_foodId());
        values.put(KEY_FOODHISTORY_QUANTITYGRAMS, itemFoodTime.get_quantityGrams() );
        values.put(KEY_FOODHISTORY_PROFILEID, itemFoodTime.get_quantityGrams() );
        values.put(KEY_FOODHISTORY_DATETIMESET, parseDateToString(itemFoodTime.get_date()) );
        values.put(KEY_FOODHISTORY_CONFIRMEDCONSUMPTION, itemFoodTime.getIsConfirmed());

        // updating row
        db.update(TABLE_FOOD_HISTORY, values, KEY_FOODHISTORY_PRIMARYID + " = ?",
                new String[] { String.valueOf(itemFoodTime.get_foodActionId()) });
        db.close();
    }

    // Deleting single item
    public void deleteItemFoodTime(ItemFoodTime itemFoodTime) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_FOOD_HISTORY, KEY_FOODHISTORY_PRIMARYID + " = ?",
                new String[] { String.valueOf(itemFoodTime.get_foodActionId()) });

        db.close();
    }


    // Getting item Count
    public int getItemFoodTimeCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FOOD_HISTORY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();
        // return count
        return cursor.getCount();
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //  private static final String KEY_PROFILE_ID = "profileId";
    //  private static final String KEY_PROFILE_CURRENTVERSION = "profileCurrentVersion";
    //   private static final String KEY_PROFILE_NAME = "profileName";
    //  private static final String KEY_PROFILE_WEIGHTKG = "profileWeightLB";
    //  private static final String KEY_PROFILE_AGE = "profileAge";
    //  private static final String KEY_PROFILE_GENDER = "profileGender";
    //   private static final String KEY_PROFILE_OBJECTIVES = "profileObjectives";
//    private static final String KEY_PROFILE_DAYCREATED = "profileDayCreated";
    //   private static final String KEY_PROFILE_DAYREPLACED = "profileDayReplaced";


    void addProfileItem(ItemProfileInfo ItemProfileInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // values.put(KEY_PROFILE_ID, ItemProfileInfo.getProfileId());
        values.put(KEY_PROFILE_CURRENTVERSION, ItemProfileInfo.getCurrentVersion());
        values.put(KEY_PROFILE_NAME, ItemProfileInfo.getProfileName());
        values.put(KEY_PROFILE_WEIGHTKG, ItemProfileInfo.getWeightKg());
        values.put(KEY_PROFILE_AGE, ItemProfileInfo.getAge());
        values.put(KEY_PROFILE_GENDER, ItemProfileInfo.getGender());
        values.put(KEY_PROFILE_OBJECTIVES, ItemProfileInfo.getRole());
        values.put(KEY_PROFILE_DAYCREATED, parseDateToString(ItemProfileInfo.getDayCreated()));
        values.put(KEY_PROFILE_DAYREPLACED, parseDateToString(ItemProfileInfo.getDayReplaced()));


        db.insert(TABLE_PROFILES, null, values);
        db.close(); // Closing database connection

    }

    ItemProfileInfo getItemProfileById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PROFILES, new String[] { KEY_PROFILE_ID,
                        KEY_PROFILE_CURRENTVERSION, KEY_PROFILE_NAME, KEY_PROFILE_WEIGHTKG, KEY_PROFILE_AGE, KEY_PROFILE_GENDER,
                        KEY_PROFILE_OBJECTIVES, KEY_PROFILE_DAYCREATED, KEY_PROFILE_DAYREPLACED}, KEY_PROFILE_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        ItemProfileInfo ItemProfile = new ItemProfileInfo(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)),
                cursor.getString(2), Float.parseFloat(cursor.getString(3)),  Float.parseFloat(cursor.getString(4)),Integer.parseInt(cursor.getString(5)),
                cursor.getString(6), cursor.getString(7), cursor.getString(8),parseStringToDate(cursor.getString(9)), parseStringToDate(cursor.getString(10)));//, cursor.getString(5));

       /*ItemProfileInfo ItemProfile = new ItemProfileInfo(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)),
                cursor.getString(2), Float.parseFloat(cursor.getString(3)), Integer.parseInt(cursor.getString(4)),
                cursor.getString(5), cursor.getString(6), parseStringToDate(cursor.getString(7)), parseStringToDate(cursor.getString(8)));//, cursor.getString(5));*/

        cursor.close();
        db.close();
        return ItemProfile;
    }

    //ItemProfileInfo getItemProfileByName(){}




    // Getting All FoodItems
    public List<ItemProfileInfo> getAllPROFILEITEMS() {
        List<ItemProfileInfo> ProfileItemList = new ArrayList<ItemProfileInfo>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_PROFILES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ItemProfileInfo itemProfileInfo = new ItemProfileInfo();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                itemProfileInfo.setProfileId(Integer.parseInt(cursor.getString(0)));
                itemProfileInfo.setCurrentVersion(Integer.parseInt(cursor.getString(1)));
                itemProfileInfo.setProfileName(cursor.getString(2));
                itemProfileInfo.setWeightKg(Float.parseFloat(cursor.getString(3)));
                itemProfileInfo.setAge(Integer.parseInt(cursor.getString(4)));
                itemProfileInfo.setGender(cursor.getString(5));
                itemProfileInfo.setRole(cursor.getString(6));
                itemProfileInfo.setDayCreated(parseStringToDate(cursor.getString(7)));
                itemProfileInfo.setDayReplaced(parseStringToDate(cursor.getString(8)));

                // Adding Restaurant to list
                ProfileItemList.add(itemProfileInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return Restaurant list
        return ProfileItemList;
    }

    // Getting All
    public List<ItemProfileInfo> getAllPROFILEITEMS_BY(String queryString) {
        List<ItemProfileInfo> ProfileItemList = new ArrayList<ItemProfileInfo>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_PROFILES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemProfileInfo itemProfileInfo = new ItemProfileInfo();

                itemProfileInfo.setProfileId(Integer.parseInt(cursor.getString(0)));
                itemProfileInfo.setCurrentVersion(Integer.parseInt(cursor.getString(1)));
                itemProfileInfo.setProfileName(cursor.getString(2));
                itemProfileInfo.setWeightKg(Float.parseFloat(cursor.getString(3)));
                itemProfileInfo.setAge(Integer.parseInt(cursor.getString(4)));
                itemProfileInfo.setGender(cursor.getString(5));
                itemProfileInfo.setRole(cursor.getString(6));
                itemProfileInfo.setDayCreated(parseStringToDate(cursor.getString(7)));
                itemProfileInfo.setDayReplaced(parseStringToDate(cursor.getString(8)));

                // Adding Restaurant to list
                ProfileItemList.add(itemProfileInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return Restaurant list
        return ProfileItemList;
    }
/*

 */



    // Updating single Restaurant
    public void updateProfileItem(ItemProfileInfo ItemProfileInfo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_RESTAUANTID, ItemFood.get_restaurantId());
        values.put(KEY_PROFILE_ID, ItemProfileInfo.getProfileId());
        values.put(KEY_PROFILE_CURRENTVERSION, ItemProfileInfo.getCurrentVersion());
        values.put(KEY_PROFILE_NAME, ItemProfileInfo.getProfileName());
        values.put(KEY_PROFILE_WEIGHTKG, ItemProfileInfo.getWeightKg());
        values.put(KEY_PROFILE_AGE, ItemProfileInfo.getAge());
        values.put(KEY_PROFILE_GENDER, ItemProfileInfo.getGender());
        values.put(KEY_PROFILE_OBJECTIVES, ItemProfileInfo.getRole());
        values.put(KEY_PROFILE_DAYCREATED, parseDateToString(ItemProfileInfo.getDayCreated()));
        values.put(KEY_PROFILE_DAYREPLACED, parseDateToString(ItemProfileInfo.getDayReplaced()));

        // updating row
        db.update(TABLE_PROFILES, values, KEY_PROFILE_ID + " = ?",
                new String[] { String.valueOf(ItemProfileInfo.getProfileId()) });

        db.close();
    }

    // Deleting single ItemProfile             new String[] { String.valueOf(ItemProfile.getProfileId()) });

    public void deleteProfileItem(ItemProfileInfo ItemProfileInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PROFILES, KEY_PROFILE_ID + " = ?",
                new String[] { String.valueOf(ItemProfileInfo.getProfileId()) });
        db.close();
    }


    // Getting itemProfile Count
    public int getProfileCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PROFILES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int toBeReturned = cursor.getCount();
        cursor.close();
        db.close();
        // return count
        return toBeReturned;
    }

    /*void addFeedbackItem(FeedBackInfo FeedBackInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_FeedBack_ID, FeedBackInfo.getFeedbackId() );
        values.put(KEY_FeedBack_Yes, FeedBackInfo.getFeedbackYes());
        values.put(KEY_FeedBack_No, FeedBackInfo.getFeedbackNo());

        db.insert(TABLE_FEEDBACK_ITEMS, null, values);
        db.close();
    }*/

    /*FeedBackInfo getFeedBackInfoById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FEEDBACK_ITEMS, new String[] {KEY_FeedBack_ID, KEY_FeedBack_Yes, KEY_FeedBack_No, KEY_PROFILE_ID}, KEY_FeedBack_ID + "=?" , new String[] {String.valueOf(id)}, null, null, null, null );
        if (cursor != null)
            cursor.moveToFirst();

        FeedBackInfo FeedBack = new FeedBackInfo(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(4))));
        cursor.close();
        db.close();
        return FeedBack;
    }*/
///////////////////////////////////////////////////////////////////////////////////////////////////







    void addRestrictedFoodItem(ItemRestrictedOrDislikedFood ItemFood) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_RESTRICTEDITEM_ID, ItemFood.getRestrictedFoodId());
        values.put(KEY_RESTRICTEDITEM_FOODID, ItemFood.getRestricedFoodItemId());//To ban a specific item
        values.put(KEY_RESTRICTEDITEM_TAG, ItemFood.getGetRestrictedFoodTag()); //tag for blacklisting many foods with a similar property
        values.put(KEY_RESTRICTEDITEM_MAXQUANTITY_GRAMS, ItemFood.getRestrictedFoodLimitGrams());

        db.insert(TABLE_RESTRICTEDDISLIKEDFOODITEMS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single Food Item
    ItemRestrictedOrDislikedFood getRestrictedFoodItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_RESTRICTEDDISLIKEDFOODITEMS, new String[] { KEY_RESTRICTEDITEM_FOODID,
                        KEY_RESTRICTEDITEM_TAG, KEY_RESTRICTEDITEM_MAXQUANTITY_GRAMS}, KEY_FOODHISTORY_FOODID + "= ?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ItemRestrictedOrDislikedFood ItemFood = new ItemRestrictedOrDislikedFood(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt((cursor.getString(1))), cursor.getString(2), Integer.parseInt(cursor.getString(3)));//, cursor.getString(5)); //███

        cursor.close();
        db.close();
        return ItemFood;
    }

    ItemRestrictedOrDislikedFood getRestrictedFoodItemByTag(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_RESTRICTEDDISLIKEDFOODITEMS, new String[] { KEY_RESTRICTEDITEM_ID,
                        KEY_RESTRICTEDITEM_FOODID, KEY_RESTRICTEDITEM_TAG, KEY_RESTRICTEDITEM_MAXQUANTITY_GRAMS}, KEY_RESTRICTEDITEM_TAG + "=?",
                new String[] { String.valueOf(name) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ItemRestrictedOrDislikedFood ItemFood = new ItemRestrictedOrDislikedFood(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)), cursor.getString(2), Float.parseFloat(cursor.getString(3)) );//, cursor.getString(5));

        cursor.close();
        db.close();
        return ItemFood;
    }


    // Getting All FoodItems
    public List<ItemRestrictedOrDislikedFood> getAllRestrictedFOODITEMS() {
        List<ItemRestrictedOrDislikedFood> FoodItemList = new ArrayList<ItemRestrictedOrDislikedFood>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RESTRICTEDDISLIKEDFOODITEMS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemRestrictedOrDislikedFood ItemFood = new ItemRestrictedOrDislikedFood();
                ItemFood.setRestrictedFoodId(Integer.parseInt(cursor.getString(0)));
                ItemFood.setRestricedFoodItemId(Integer.parseInt(cursor.getString(1)));
                ItemFood.setGetRestrictedFoodProperty((cursor.getString(2)));
                ItemFood.setRestrictedFoodLimitGrams(Float.parseFloat(cursor.getString(3)));

                // Adding Restaurant to list
                FoodItemList.add(ItemFood);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        // return Restaurant list
        return FoodItemList;
    }



    // Updating single Restaurant
    public void updateRestrictedFoodItem(ItemRestrictedOrDislikedFood ItemFood) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_RESTRICTEDITEM_FOODID, ItemFood.getRestricedFoodItemId());
        values.put(KEY_RESTRICTEDITEM_TAG, ItemFood.getGetRestrictedFoodTag());
        values.put(KEY_RESTRICTEDITEM_MAXQUANTITY_GRAMS, ItemFood.getRestrictedFoodLimitGrams());


        // updating row
        db.update(TABLE_RESTRICTEDDISLIKEDFOODITEMS, values, KEY_RESTRICTEDITEM_ID + " = ?",
                new String[] { String.valueOf(ItemFood.getRestrictedFoodId()) });
        db.close();
    }

    // Deleting single ItemFood               new String[] { String.valueOf(ItemFood.get_foodId()) });

    public void deleteRestrictedFoodItem(ItemRestrictedOrDislikedFood ItemFood) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_RESTRICTEDDISLIKEDFOODITEMS, KEY_RESTRICTEDITEM_ID + " = ?",
                new String[] { String.valueOf(ItemFood.getRestrictedFoodId()) });

        db.close();
    }


    // Getting  Count
    public int getRestrictedFoodItemCount() {
        String countQuery = "SELECT  * FROM " + TABLE_RESTRICTEDDISLIKEDFOODITEMS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int toBeReturned = cursor.getCount();
        cursor.close();
        db.close();
        // return count
        return toBeReturned;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    void addFoodItem(ItemFood ItemFood) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_FOODITEM_NAME, ItemFood.getFoodItemName());
        values.put(KEY_FOODITEM_TAGS, splitString(ItemFood.getFoodItemTags())); //
        values.put(KEY_FOODITEM_NUTRITIONFACTS, splitString(ItemFood.getFoodItemNutritionFacts()));
        values.put(KEY_FOODITEM_MINERALFACTS, splitString( ItemFood.getFoodItemMinerals()));
        values.put(KEY_FOODITEM_VITAMINFACTS,  splitString(ItemFood.getFoodItemVitamins()));
        values.put(KEY_FOODITEM_DESCRIPTION, splitString(ItemFood.getFoodItemDescription()));

        db.insert(TABLE_FOOD_ITEMS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single Food Item
    ItemFood getFoodItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOOD_ITEMS, new String[] { KEY_FOODITEM_ID,
                        KEY_FOODITEM_NAME, KEY_FOODITEM_TAGS, KEY_FOODITEM_NUTRITIONFACTS, KEY_FOODITEM_MINERALFACTS, KEY_FOODITEM_VITAMINFACTS,
                        KEY_FOODITEM_DESCRIPTION}, KEY_FOODITEM_ID + "= ?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ItemFood ItemFood = new ItemFood(Integer.parseInt(cursor.getString(0)),
                ((cursor.getString(1))), stringToListString(cursor.getString(2)), stringToListString(cursor.getString(3)), stringToListString(cursor.getString(4)),
                stringToListString(cursor.getString(5)), stringToListString(cursor.getString(6)) );//, cursor.getString(5));
        cursor.close();
        db.close();
        return ItemFood;
    }

    ItemFood getFoodItemByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOOD_ITEMS, new String[] { KEY_FOODITEM_ID,
                        KEY_FOODITEM_NAME, KEY_FOODITEM_NAME, KEY_FOODITEM_TAGS, KEY_FOODITEM_NUTRITIONFACTS, KEY_FOODITEM_MINERALFACTS,
                        KEY_FOODITEM_VITAMINFACTS, KEY_FOODITEM_DESCRIPTION}, KEY_FOODITEM_NAME + "=?",
                new String[] { String.valueOf(name) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ItemFood ItemFood = new ItemFood(Integer.parseInt(cursor.getString(0)),
                ((cursor.getString(1))), stringToListString(cursor.getString(2)), stringToListString(cursor.getString(3)), stringToListString(cursor.getString(4)),
                stringToListString(cursor.getString(5)), stringToListString(cursor.getString(6)) );//, cursor.getString(5));
        cursor.close();
        db.close();
        return ItemFood;
    }


    // Getting All FoodItems
    public List<ItemFood> getAllFOODITEM() {
        List<ItemFood> FoodItemList = new ArrayList<ItemFood>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_FOOD_ITEMS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemFood ItemFood = new ItemFood();
                ItemFood.setFoodItemId(Integer.parseInt(cursor.getString(0)));
                ItemFood.setFoodItemName(cursor.getString(1));
                ItemFood.setFoodItemTags( stringToListString(cursor.getString(2)));
                ItemFood.setFoodItemNutritionFacts(stringToListString(cursor.getString(3)));
                ItemFood.setFoodItemMinerals( stringToListString(cursor.getString(4)));
                ItemFood.setFoodItemVitamins( stringToListString(cursor.getString(5)));
                ItemFood.setFoodItemDescription( stringToListString(cursor.getString(6)));
                // Adding to list
                FoodItemList.add(ItemFood);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return Restaurant list
        return FoodItemList;
    }

    /*
    // Getting All Food
    public List<ItemFood> getAllFOODITEMs_BYRESTAURANT(String queryString) {
        List<ItemFood> FoodItemList = new ArrayList<ItemFood>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOOD_ITEMS + " WHERE " + KEY_FOODITEM + " = '" + queryString + "';" ;//+ " LIKE ('%" + queryString + "%');";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemFood ItemFood = new ItemFood();
                ItemFood.set_foodId(Integer.parseInt(cursor.getString(0)));
                //ItemFood.set_restaurantId(Integer.parseInt(cursor.getString(1)));
                ItemFood.set_restaurantName(cursor.getString(1));
                ItemFood.set_foodName(cursor.getString(2));
                ItemFood.set_price(cursor.getString(3));
                ItemFood.set_typeOfCuisine(cursor.getString(4));
                // Adding Restaurant to list
                FoodItemList.add(ItemFood);
            } while (cursor.moveToNext());
        }

        // return Restaurant list
        return FoodItemList;
    }
*/

    public List<ItemFood> getAllFOODITEMS_BYID(int queryString) {
        List<ItemFood> FoodItemList = new ArrayList<ItemFood>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOOD_ITEMS + " WHERE " + KEY_FOODITEM_NAME + " = '" + queryString + "';" ;//+ " LIKE ('%" + queryString + "%');";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemFood ItemFood = new ItemFood();
                ItemFood.setFoodItemId(Integer.parseInt(cursor.getString(0)));
                ItemFood.setFoodItemName(cursor.getString(1));
                ItemFood.setFoodItemTags( stringToListString(cursor.getString(2)));
                ItemFood.setFoodItemNutritionFacts(stringToListString(cursor.getString(3)));
                ItemFood.setFoodItemMinerals( stringToListString(cursor.getString(4)));
                ItemFood.setFoodItemVitamins( stringToListString(cursor.getString(5)));
                ItemFood.setFoodItemDescription( stringToListString(cursor.getString(6)));
                FoodItemList.add(ItemFood);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return Restaurant list
        return FoodItemList;
    }

    // Updating single Restaurant
    public void updateFoodItem(ItemFood ItemFood) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_FOODITEM_NAME, ItemFood.getFoodItemName());
        values.put(KEY_FOODITEM_TAGS, splitString(ItemFood.getFoodItemTags())); //
        values.put(KEY_FOODITEM_NUTRITIONFACTS, splitString(ItemFood.getFoodItemNutritionFacts()));
        values.put(KEY_FOODITEM_MINERALFACTS, splitString( ItemFood.getFoodItemMinerals()));
        values.put(KEY_FOODITEM_VITAMINFACTS,  splitString(ItemFood.getFoodItemVitamins()));
        values.put(KEY_FOODITEM_DESCRIPTION, splitString(ItemFood.getFoodItemDescription()));

        db.insert(TABLE_FOOD_ITEMS, null, values);


        // updating row
        db.update(TABLE_FOOD_ITEMS, values, KEY_FOODHISTORY_FOODID + " = ?",
                new String[] { String.valueOf(ItemFood.getFoodItemId()) });
        db.close(); // Closing database connection
    }

    // Deleting single ItemFood               new String[] { String.valueOf(ItemFood.get_foodId()) });

    public void deleteFoodItem(ItemFood ItemFood) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FOOD_ITEMS, KEY_FOODITEM_ID + " = ?",
                new String[] { String.valueOf(ItemFood.getFoodItemId()) });

        db.close();
    }


    // Getting RESTAURANT Count
    public int getFoodItemCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FOOD_ITEMS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int returner = cursor.getCount();
        cursor.close();
        db.close();
        // return count
        return returner;
    }


/*
    void addFoodItem(ItemFood ItemFood) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_RESTAUANTID, ItemFood._restaurantId); //
        values.put(KEY_RESTAURANTNAME, ItemFood._restaurantName);
        values.put(KEY_FOODHISTORY_FOODNAME, ItemFood._foodName); //
        values.put(KEY_PRICE, ItemFood._price);
        values.put(KEY_TYPEOFCUISINE, ItemFood._typeOfCuisine);

        db.insert(TABLE_FOODITEM, null, values);
        db.close(); // Closing database connection
    }

    // Getting single Food Item
    ItemFood getFoodItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOODITEM, new String[] { KEY_FOODHISTORY_FOODID,
                        // KEY_RESTAUANTID
                        KEY_RESTAURANTNAME, KEY_FOODHISTORY_FOODNAME, KEY_PRICE, KEY_TYPEOFCUISINE}, KEY_FOODHISTORY_FOODID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ItemFood ItemFood = new ItemFood(Integer.parseInt(cursor.getString(0)),
                ((cursor.getString(1))), cursor.getString(2), cursor.getString(3), cursor.getString(4));//, cursor.getString(5));
        return ItemFood;
    }

    ItemFood getFoodItemByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOODITEM, new String[] { KEY_FOODHISTORY_FOODID,
                        // KEY_RESTAUANTID
                        KEY_RESTAURANTNAME, KEY_FOODHISTORY_FOODNAME, KEY_PRICE, KEY_TYPEOFCUISINE}, KEY_FOODHISTORY_FOODNAME + "=?",
                new String[] { String.valueOf(name) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ItemFood ItemFood = new ItemFood(Integer.parseInt(cursor.getString(0)),
                ((cursor.getString(1))), cursor.getString(2), cursor.getString(3), cursor.getString(4));//, cursor.getString(5));
        return ItemFood;
    }


    // Getting All FoodItems
    public List<ItemFood> getAllFOODITEM() {
        List<ItemFood> FoodItemList = new ArrayList<ItemFood>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOODITEM;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemFood ItemFood = new ItemFood();
                ItemFood.set_foodId(Integer.parseInt(cursor.getString(0)));
                //ItemFood.set_restaurantId(Integer.parseInt(cursor.getString(1)));
                ItemFood.set_restaurantName(cursor.getString(1));
                ItemFood.set_foodName(cursor.getString(2));
                ItemFood.set_price(cursor.getString(3));
                ItemFood.set_typeOfCuisine(cursor.getString(4));
                // Adding Restaurant to list
                FoodItemList.add(ItemFood);
            } while (cursor.moveToNext());
        }

        // return Restaurant list
        return FoodItemList;
    }

    // Getting All Food
    public List<ItemFood> getAllFOODITEMs_BYRESTAURANT(String queryString) {
        List<ItemFood> FoodItemList = new ArrayList<ItemFood>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOODITEM + " WHERE " + KEY_RESTAURANTNAME + " = '" + queryString + "';" ;//+ " LIKE ('%" + queryString + "%');";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemFood ItemFood = new ItemFood();
                ItemFood.set_foodId(Integer.parseInt(cursor.getString(0)));
                //ItemFood.set_restaurantId(Integer.parseInt(cursor.getString(1)));
                ItemFood.set_restaurantName(cursor.getString(1));
                ItemFood.set_foodName(cursor.getString(2));
                ItemFood.set_price(cursor.getString(3));
                ItemFood.set_typeOfCuisine(cursor.getString(4));
                // Adding Restaurant to list
                FoodItemList.add(ItemFood);
            } while (cursor.moveToNext());
        }

        // return Restaurant list
        return FoodItemList;
    }


    public List<ItemFood> getAllFOODITEMS_BYID(int queryString) {
        List<ItemFood> FoodItemList = new ArrayList<ItemFood>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOODITEM + " WHERE " + KEY_RESTAURANTNAME + " = '" + queryString + "';" ;//+ " LIKE ('%" + queryString + "%');";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ItemFood ItemFood = new ItemFood();
                ItemFood.set_foodId(Integer.parseInt(cursor.getString(0)));
                //ItemFood.set_restaurantId(Integer.parseInt(cursor.getString(1)));
                ItemFood.set_restaurantName(cursor.getString(1));
                ItemFood.set_foodName(cursor.getString(2));
                ItemFood.set_price(cursor.getString(3));
                ItemFood.set_typeOfCuisine(cursor.getString(4));
                // Adding Restaurant to list
                FoodItemList.add(ItemFood);
            } while (cursor.moveToNext());
        }

        // return Restaurant list
        return FoodItemList;
    }

    // Updating single Restaurant
    public int updateFoodItem(ItemFood ItemFood) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_RESTAUANTID, ItemFood.get_restaurantId());
        values.put(KEY_RESTAURANTNAME, ItemFood.get_restaurantName());
        values.put(KEY_FOODHISTORY_FOODNAME, ItemFood.get_foodName());
        values.put(KEY_PRICE, ItemFood.get_price());
        values.put(KEY_TYPEOFCUISINE, ItemFood.get_typeOfCuisine());

        // updating row
        return db.update(TABLE_FOODITEM, values, KEY_FOODHISTORY_FOODID + " = ?",
                new String[] { String.valueOf(ItemFood.get_foodId()) });
    }

    // Deleting single ItemFood               new String[] { String.valueOf(ItemFood.get_foodId()) });

    public void deleteFoodItem(ItemFood ItemFood) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FOODITEM, KEY_FOODHISTORY_FOODID + " = ?",
                new String[] { String.valueOf(ItemFood.get_foodId()) });

        db.close();
    }


    // Getting RESTAURANT Count
    public int getFoodItemCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FOODITEM;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    */
    //fooditem: item name, id, calories, other nutrition facts, quantity
    //time: time, day, month year
    //combo: food item, quantity consumed, time, day month year, consumption confirmation,

    String splitString(List<String> toBeSplit, char delimiter){
        String joinedString = "";
        String convertedDelimiter =  Character.toString(delimiter);
        for (String item: toBeSplit) {
            joinedString+= item + convertedDelimiter;
        }
        return joinedString;

    }

    String splitString(List<String> toBeSplit){
        String joinedString = "";
        String convertedDelimiter =  "~";
        for (String item: toBeSplit) {

            joinedString+= item + convertedDelimiter;
        }
        return joinedString;

    }


    List<String> stringToListString(String toBeJoined, char delimiter){
        String convertedDelimiter =  Character.toString(delimiter);
        List<String> splitString = new ArrayList<String>(Arrays.asList(toBeJoined.split(convertedDelimiter)));
        return splitString;
    }

    List<String> stringToListString(String toBeJoined){
        String convertedDelimiter =  "~";
        List<String> splitString = new ArrayList<String>(Arrays.asList(toBeJoined.split(convertedDelimiter)));
        return splitString;
    }


    Boolean intToBool(int toBool){
        return toBool > 0;
    }

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    //DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
    Date parseStringToDate(String toBeParsed) {
        // Locale current =  getResources().getConfiguration().locale;

        Date date = new Date(2016, 11, 12, 12, 12, 12);
        try {
            //date = formatter.parse("2016/12/12 12:12:12 AM");
            date = formatter.parse(toBeParsed);
            //  System.out.println(date);
            // System.out.println(formatter.format(date));
            return  date;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  date;
    }

    String parseDateToString(Date date){
        String returner = formatter.format(date);
        return returner;
    }
}

/*public class ClientDatabase {
}*/
