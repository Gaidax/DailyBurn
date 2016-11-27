package com.example.dailyburn;

/**
 * Created by Rukshar on 2016-11-25.
 */

public class ItemRestrictedOrDislikedFood {
    //profile id, food id //profile id, completely refute a subspecies of a food group

    private int restrictedFoodId;
    private int restrictedFoodItemId;
    private String restrictedFoodProperty;
    private float restrictedFoodLimitGrams;

    public ItemRestrictedOrDislikedFood(){}

    public ItemRestrictedOrDislikedFood(int restrictedFoodId, int restrictedFoodItemId, String restrictedFoodProperty, float restrictedFoodLimitGrams) {
        this.restrictedFoodId = restrictedFoodId;
        this.restrictedFoodItemId = restrictedFoodItemId;
        this.restrictedFoodProperty = restrictedFoodProperty;
        this.restrictedFoodLimitGrams = restrictedFoodLimitGrams;
    }


    public ItemRestrictedOrDislikedFood(int restrictedFoodItemId, String getRestrictedFoodProperty, float restrictedFoodLimitGrams) {
        this.restrictedFoodItemId = restrictedFoodItemId;
        this.restrictedFoodProperty = getRestrictedFoodProperty;
        this.restrictedFoodLimitGrams = restrictedFoodLimitGrams;
    }


    public int getRestrictedFoodId() {
        return restrictedFoodId;
    }
    public void setRestrictedFoodId(int restrictedFoodId) {this.restrictedFoodId = restrictedFoodId;}

    public int getRestricedFoodItemId() {return restrictedFoodItemId;}
    public void setRestricedFoodItemId(int restrictedFoodItemId) {this.restrictedFoodItemId = restrictedFoodItemId;}

    public String getGetRestrictedFoodTag() {
        return restrictedFoodProperty;
    }
    public void setGetRestrictedFoodProperty(String getRestrictedFoodProperty) {this.restrictedFoodProperty = getRestrictedFoodProperty;}


    public float getRestrictedFoodLimitGrams() {return restrictedFoodLimitGrams;}
    public void setRestrictedFoodLimitGrams(float restrictedFoodLimitGrams) {this.restrictedFoodLimitGrams = restrictedFoodLimitGrams;}
}
