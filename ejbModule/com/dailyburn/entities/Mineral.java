package com.dailyburn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the minerals database table.
 * 
 */
@Entity
@Table(name="minerals")
@NamedQuery(name="Mineral.findAll", query="SELECT m FROM Mineral m")
public class Mineral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float calcium;

	private float iron;

	private float magnesium;

	private float potassium;

	private float sodium;

	//bi-directional many-to-one association to FoodItem
	@OneToMany(mappedBy="mineral")
	private List<FoodItem> foodItems;

	public Mineral() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCalcium() {
		return this.calcium;
	}

	public void setCalcium(float calcium) {
		this.calcium = calcium;
	}

	public float getIron() {
		return this.iron;
	}

	public void setIron(float iron) {
		this.iron = iron;
	}

	public float getMagnesium() {
		return this.magnesium;
	}

	public void setMagnesium(float magnesium) {
		this.magnesium = magnesium;
	}

	public float getPotassium() {
		return this.potassium;
	}

	public void setPotassium(float potassium) {
		this.potassium = potassium;
	}

	public float getSodium() {
		return this.sodium;
	}

	public void setSodium(float sodium) {
		this.sodium = sodium;
	}

	public List<FoodItem> getFoodItems() {
		return this.foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public FoodItem addFoodItem(FoodItem foodItem) {
		getFoodItems().add(foodItem);
		foodItem.setMineral(this);

		return foodItem;
	}

	public FoodItem removeFoodItem(FoodItem foodItem) {
		getFoodItems().remove(foodItem);
		foodItem.setMineral(null);

		return foodItem;
	}

}