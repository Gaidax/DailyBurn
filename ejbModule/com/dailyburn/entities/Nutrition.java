package com.dailyburn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nutrition database table.
 * 
 */
@Entity
@NamedQuery(name="Nutrition.findAll", query="SELECT n FROM Nutrition n")
public class Nutrition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float calories;

	private float carbs;

	private float cholesterol;

	private float fat;

	private float protein;

	//bi-directional many-to-one association to FoodItem
	@OneToMany(mappedBy="nutrition")
	private List<FoodItem> foodItems;

	public Nutrition() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCalories() {
		return this.calories;
	}

	public void setCalories(float calories) {
		this.calories = calories;
	}

	public float getCarbs() {
		return this.carbs;
	}

	public void setCarbs(float carbs) {
		this.carbs = carbs;
	}

	public float getCholesterol() {
		return this.cholesterol;
	}

	public void setCholesterol(float cholesterol) {
		this.cholesterol = cholesterol;
	}

	public float getFat() {
		return this.fat;
	}

	public void setFat(float fat) {
		this.fat = fat;
	}

	public float getProtein() {
		return this.protein;
	}

	public void setProtein(float protein) {
		this.protein = protein;
	}

	public List<FoodItem> getFoodItems() {
		return this.foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public FoodItem addFoodItem(FoodItem foodItem) {
		getFoodItems().add(foodItem);
		foodItem.setNutrition(this);

		return foodItem;
	}

	public FoodItem removeFoodItem(FoodItem foodItem) {
		getFoodItems().remove(foodItem);
		foodItem.setNutrition(null);

		return foodItem;
	}

}