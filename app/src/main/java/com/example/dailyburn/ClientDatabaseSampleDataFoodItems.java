package com.example.dailyburn;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rukshar on 2016-11-25.
 */

public class ClientDatabaseSampleDataFoodItems extends AppCompatActivity {

    ClientDatabase dbRF = new ClientDatabase(this);

//public DatabaseHandler dbRF = null;

    public void ClientDatabaseSampleDataFoodItemsTry() {

        String checker = dbRF.getDatabaseName();
        if (checker.equals(null)) {
            AddBaseFoodItems(dbRF);
            addRandomFoodItems(dbRF);
            addProfileItem(dbRF);
            addItemToHistory(dbRF);
        }
        else { Log.d("MattSample", "broken else");}
        try {

        }
        catch (Exception r) {
            Log.d("MattSample", "broken catch");
        }
    }

    public ClientDatabase ClientDatabaseSampleDataFoodItems(ClientDatabase dbRF) {
        try {
            String checker = dbRF.getDatabaseName();
            if (checker.equals(null)) {
                AddBaseFoodItems(dbRF);
                addRandomFoodItems(dbRF);
                addProfileItem(dbRF);
                addItemToHistory(dbRF);
            }
            else { Log.d("MattSample", "broken else");}
        }
        catch (Exception r) {
            Log.d("MattSample", "broken catch");
        }
        return dbRF;
    }
    //Nutrition Facts:
    //Calories-From carbohydrates, fat, protein, alcohol
    //Fats: saturated, trans fat, monounsaturates, saturates, polyunsaturated, omega 3, omega 6
    //cholesterol,
    //sodium
    //Carbohydrates
    //sugars
    //dietary fiber
    //sugars
    //protein


    //carbohydrates: sugar, dietary fiber

    //Sugars:
    //Sterols: cholesterol, phytosterol: campesterol, stigmasterol, beta-sitosterol
    //
    //
    //Vitamin Facts: Vitamin A(retinol, retinal,retinoic acid),
    //Vitamin B1(thiamin), Vitamin B2(Riboflavin), Vitamin B3(Niacin/nicotinic), Vitamin B5(Pantothenic acid),
    //Vitamin B6 (pyridoxal, pyridoxine, pyridoxamine), Vitamin B12 (Cobalamin), -folic acid
    //Biotin
    //Vitamin C(ascorbic acid),
    //Vitamin D(calciferol), Vitamin E (alpha-tocopherol)
    //folic acid(folate,folacin)
    //Vitamin K(phylloquinone)
    //
    //
    //http://www.simple-approach-to-healthy-living.com/list-of-minerals.html
    //Minerals Facts mg: calcium, iron, magnesium, phosphorus, potassium, sodium, zinc, copper, manganese, selenium, fluoride, iodine, biotin, boron, chromium, germanium,
    //Selenium, Silicon, Sulfur, Vanadium, Zinc, molybdenum, chloride, molybdenum, potassium, sulphur, Niacin, folacin, panthothenate,
    //
    String itemName  = "";
    List<String> itemTags = new ArrayList<>();
    List<String> itemNutritionFacts = new ArrayList<>();
    List<String> itemMinerals = new ArrayList<>();
    List<String> itemVitamins = new ArrayList<>();
    List<String> itemDescription= new ArrayList<>();

    void AddBaseFoodItems(ClientDatabase dbRF){
        //base values


        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Calories";
        itemTags.add("calories");
        itemNutritionFacts.add("calories:0.01:calories");
        itemDescription.add("General:Calories are necessary for survival but to many can result in weight gain.");
        ItemFood foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Fats";
        itemTags.add("fats");
        itemNutritionFacts.add("fats:0.01");// 20-30 of daily calorie intake% 1g fat = 9 calories
        itemDescription.add("General:fats are necessary for survival but to many can result in weight gain.");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Saturated Fats";
        itemTags.add("saturated fats");
        itemNutritionFacts.add("saturated fats:0.01:g");// 20-30 of daily calorie intake% 1g fat = 9 calories
        itemDescription.add("General:fats are necessary for survival but to many can result in weight gain.");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Trans Fats";
        itemTags.add("trans fats");
        itemNutritionFacts.add("trans fats:0.01:g");// 20-30 of daily calorie intake% 1g fat = 9 calories
        itemDescription.add("General:trans fats are necessary for survival but to many can result in weight gain.");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Monounsaturates";
        itemTags.add("monounsaturates");
        itemNutritionFacts.add("monounsaturates:0.01:g");// 20-30 of daily calorie intake% 1g fat = 9 calories
        itemDescription.add("General:monounsaturates");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Polyunsaturates";
        itemTags.add("polyunsaturated");
        itemTags.add("polyunsaturates");
        itemNutritionFacts.add("polyunsaturates:0.01:g");// 20-30 of daily calorie intake% 1g fat = 9 calories
        itemDescription.add("General:polyunsaturates");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Omega 3";
        itemTags.add("omega 3");
        itemNutritionFacts.add("omega3:0.01:g");// 20-30 of daily calorie intake% 1g fat = 9 calories
        itemDescription.add("General:omega3");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Omega 6";
        itemTags.add("omega6");
        itemNutritionFacts.add("omega6:0.01:g");// 20-30 of daily calorie intake% 1g fat = 9 calories
        itemDescription.add("General:omega6");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Cholesterol";
        itemTags.add("cholesterol");
        itemTags.add("cholesterol");
        itemNutritionFacts.add("cholesterol:0.01:mg");//
        itemDescription.add("General:cholesterol");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Sodium";
        itemTags.add("sodium");
        itemTags.add("sodium");
        itemNutritionFacts.add("sodium:0.01:mg");//mg
        itemDescription.add("General:sodium");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Carbohydrates";
        itemTags.add("carbohydrates");
        itemTags.add("carbohydrates");
        itemNutritionFacts.add("carbohydrates:0.01:g");//g
        itemDescription.add("General:Carbohydrates");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Sugars";
        itemTags.add("sugars");
        itemNutritionFacts.add("sugars:.01:g");//g
        itemDescription.add("General:Sugars");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Dietary Fiber";
        itemTags.add("dietary fiber");
        itemNutritionFacts.add("dietaryFiber:0.01:g");// g
        itemDescription.add("General:Dietary fiber");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////
        itemName = "Protein";
        itemTags.add("protein");
        itemNutritionFacts.add("protein:0.01:g");// g
        itemDescription.add("General:Dietary fiber");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        ////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////

/*
        itemTags.add("Base Item");
        itemNutritionFacts.add("");// g
        //itemMinerals.add();
        itemDescription.add("General: ");
        foodItem = new ItemFood(itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
        */
    }

//recommended values http://dsld.nlm.nih.gov/dsld/dailyvalue.jsp

    void addRandomFoodItems(ClientDatabase dbRF){
        //http://nutritiondata.self.com/facts/vegetables-and-vegetable-products/2356/2
        //http://www.inspection.gc.ca/food/labelling/food-labelling-for-industry/nutrition-labelling/information-within-the-nutrition-facts-table/eng/1389198568400/1389198597278?chap=6#s7c6
        //
        itemName = "Broccoli Raw";
        itemTags.add("broccoli");
        itemTags.add("raw");
        itemTags.add("uncooked");
        itemTags.add("vegetable");
        itemTags.add("greens");
        itemTags.add("healthy");
        itemNutritionFacts.add("calories:0.34:g");// g
        itemNutritionFacts.add("fat:0.032:g");//g
        itemNutritionFacts.add("sodium:0.329:mg");
        itemNutritionFacts.add("totalCarbohydrates:0.06.:g");
        itemNutritionFacts.add("dietaryFiber:0.021:g");
        itemNutritionFacts.add("sugars:0.021:g");
        itemNutritionFacts.add("protein:0.032:g");
        itemVitamins.add("vitaminA:0.12:%");
        itemMinerals.add("calcium:0.219:%");


        itemDescription.add("General:Broccoli Raw");
        ItemFood foodItem = new ItemFood(7777, itemName, itemTags, itemNutritionFacts, itemMinerals, itemVitamins, itemDescription);
        dbRF.addFoodItem(foodItem);
        removeAllFromFoodItemVariables();
    }


    void removeAllFromFoodItemVariables(){
        itemName  = "";
        itemTags = new ArrayList<String>();
        itemNutritionFacts = new ArrayList<String>();
        itemMinerals = new ArrayList<String>();
        itemVitamins = new ArrayList<String>();
        itemDescription= new ArrayList<String>();
    }


    void addProfileItem(ClientDatabase dbRF){

        int currentId = 7777;
        int _currentVersion = 1;
        String _profileName = "Matt";
        float _weightKg = 71;
        int _age = 20;
        int _height = 25;
        String _allergy = "None";
        String _gender = "Male";
        String _role = "None";
        Date _dayCreated = null;
        Date _dayReplaced = null;

        String toBeParsed = "2016/11/1 11:00:00 am";
        String toBeParsed2 = "2116/11/1 11:00:00 am";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss aa");
        try {
            _dayCreated = formatter.parse(toBeParsed);
            _dayReplaced = formatter.parse(toBeParsed2);

        } catch(Exception e){}
        //   ItemProfileInfo itemProfileInfo = new ItemProfileInfo(7777, _currentVersion, _profileName, _weightKg, _height, _allergy, _age, _gender, _role, _dayCreated, _dayReplaced);
        // dbRF.addProfileItem(itemProfileInfo);
    }


    void addItemToHistory(ClientDatabase dbRF){

        int foodId;
        float quantityGrams;
        int profileId;
        Date dateYearMonthDayHourMinuteSecond = new Date(2016, 10, 12, 12, 12, 12);
        boolean confirmed;

        foodId = 7777;
        quantityGrams = 100.0f;
        profileId = 7777;
        String toBeParsed = "2016/11/22 12:00:00 am";
        confirmed = false;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss aa");
        try {
            dateYearMonthDayHourMinuteSecond = formatter.parse(toBeParsed);
        } catch(Exception e){}

        ItemFoodTime itemFoodTime = new ItemFoodTime(foodId, quantityGrams, profileId, dateYearMonthDayHourMinuteSecond, confirmed);
        dbRF.addFoodItemToHistory(itemFoodTime);

    }

}
/*public class ClientDatabaseSampleDataFoodItems {

}*/
