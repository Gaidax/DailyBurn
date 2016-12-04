package com.dailyburn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vitamins database table.
 * 
 */
@Entity
@Table(name="vitamins")
@NamedQuery(name="Vitamin.findAll", query="SELECT v FROM Vitamin v")
public class Vitamin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float a;

	private float b;

	private float c;

	private float d;

	private float e;

	//bi-directional many-to-one association to FoodItem
	@OneToMany(mappedBy="vitamin")
	private List<FoodItem> foodItems;

	public Vitamin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getA() {
		return this.a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return this.b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float getC() {
		return this.c;
	}

	public void setC(float c) {
		this.c = c;
	}

	public float getD() {
		return this.d;
	}

	public void setD(float d) {
		this.d = d;
	}

	public float getE() {
		return this.e;
	}

	public void setE(float e) {
		this.e = e;
	}

	public List<FoodItem> getFoodItems() {
		return this.foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public FoodItem addFoodItem(FoodItem foodItem) {
		getFoodItems().add(foodItem);
		foodItem.setVitamin(this);

		return foodItem;
	}

	public FoodItem removeFoodItem(FoodItem foodItem) {
		getFoodItems().remove(foodItem);
		foodItem.setVitamin(null);

		return foodItem;
	}

}