package com.example.dailyburn;

import java.util.List;

/**
 * Created by Rukshar on 2016-11-25.
 */

public class ItemFood {
    //exercise = -calories
    // 0 vs null
    //Nutrition Facts:
    //Calories-From carbohydrates, fat, protein, alcohol
    //Fats: saturated, transfat, monounsaturates, saturates, polyunsaturated, omega 3, omega 6
    //cholesterol,
    //sugars
    //dietary fiber
    //sodium
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
    //
    //
    //serving size

    //Important:
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //The primary values to consider: id, food name, tags (meat, animal product (milk, eggs, cheese), nutrition facts(calories etc), minerals(Selenium), vitamins(A, B, C),
    // description/notes, images?
    //
    //Android: id = string, name = string, tags = list<string>, nutrition facts = List<String>, minerals = List<String>, vitamins = List<String>,
    //Desctiption/Notes = String, Images = List<bitimage>
    //
    //int currentIndex = 0; // your index
    //myImageView.setImageResource(bgImageList.get(currentIndex));
    //
    //DB: id = integer, name = text, tags = Text (covert to array), nutrition facts = Text (covert to array), minerals = Text (covert to array),
    //vitamins = Text (covert to array), description/notes = text, images =

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CREATE TABLE IF NOT EXISTS Your_table ( id INTEGER PRIMARY KEY NOT NULL UNIQUE, someOtherField TEXT, pictureData TEXT);
    //
    // Convert image to text
    //
    //public class User {
    //
    //private String email;
    //private String name;
    //private Drawable pictureDataDrawable;
    //
    //public User() {}
    //
    //public void setPictureData(byte[] pictureData) {
    //    pictureDataDrawable = ImageUtils.byteToDrawable(pictureData);
    //}
    //
    //public byte[] getPictureData(){
    //    return ImageUtils.drawableToByteArray(pictureDataDrawable);
    //}
    //}
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //user.setPictureData(cursor.getBlob(cursor.getColumnIndexOrThrow(DB_PICTURE_DATA_KEY)));
    //
    //ContentValues c = new ContentValues();
    //c.put(DB_PICTURE_DATA_KEY, user.getPictureData());
    //...
    //
    //
    //public static byte[] drawableToByteArray(Drawable d) {
    //
    //if (d != null) {
    //    Bitmap imageBitmap = ((BitmapDrawable) d).getBitmap();
    //    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    //    imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
    //    byte[] byteData = baos.toByteArray();
//
    //    return byteData;
    //} else
    //        return null;

//}


    // public static Drawable byteToDrawable(byte[] data) {
//
    //      if (data == null)
    //        return null;
    //     else
    //         return new BitmapDrawable(BitmapFactory.decodeByteArray(data, 0, data.length));
    // }
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    int foodItemId;
    String foodItemName;
    List<String> foodItemTags;
    List<String> foodItemNutritionFacts;
    List<String> foodItemMinerals;
    List<String> foodItemVitamins;
    List<String> foodItemDescription;


    public ItemFood(){}

    public ItemFood(int foodItemId, String foodItemName, List<String> foodItemTags, List<String> foodItemNutritionFacts, List<String> foodItemMinerals, List<String> foodItemVitamins, List<String> foodItemDescription) {
        this.foodItemId = foodItemId;
        this.foodItemName = foodItemName;
        this.foodItemTags = foodItemTags;
        this.foodItemNutritionFacts = foodItemNutritionFacts;
        this.foodItemMinerals = foodItemMinerals;
        this.foodItemVitamins = foodItemVitamins;
        this.foodItemDescription = foodItemDescription;
    }



    public ItemFood( String foodItemName, List<String> foodItemTags, List<String> foodItemNutritionFacts, List<String> foodItemMinerals, List<String> foodItemVitamins, List<String> foodItemDescription) {
        this.foodItemName = foodItemName;
        this.foodItemTags = foodItemTags;
        this.foodItemNutritionFacts = foodItemNutritionFacts;
        this.foodItemMinerals = foodItemMinerals;
        this.foodItemVitamins = foodItemVitamins;
        this.foodItemDescription = foodItemDescription;
    }



    public int getFoodItemId() {return foodItemId;}
    public void setFoodItemId(int foodItemId) {this.foodItemId = foodItemId;}

    public String getFoodItemName() {return foodItemName;}
    public void setFoodItemName(String foodItemName) {this.foodItemName = foodItemName;}

    public List<String> getFoodItemTags() {return foodItemTags;}
    public void setFoodItemTags(List<String> foodItemTags) {this.foodItemTags = foodItemTags;}

    public List<String> getFoodItemNutritionFacts() {return foodItemNutritionFacts;}
    public void setFoodItemNutritionFacts(List<String> foodItemNutritionFacts) {this.foodItemNutritionFacts = foodItemNutritionFacts;}

    public List<String> getFoodItemMinerals() {return foodItemMinerals;}
    public void setFoodItemMinerals(List<String> foodItemMinerals) {this.foodItemMinerals = foodItemMinerals;}

    public List<String> getFoodItemVitamins() {
        return foodItemVitamins;
    }
    public void setFoodItemVitamins(List<String> foodItemVitamins) {this.foodItemVitamins = foodItemVitamins;}

    public List<String> getFoodItemDescription() {return foodItemDescription;}
    public void setFoodItemDescription(List<String> foodItemDescription) {this.foodItemDescription = foodItemDescription;}
}

/*public class ItemFood {
}*/
