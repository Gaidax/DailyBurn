package com.dailyburn.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the food_item database table.
 * 
 */
@Entity
@Table(name="food_item")
@NamedQuery(name="FoodItem.findAll", query="SELECT f FROM FoodItem f")
public class FoodItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idfood_item")
	private int idfoodItem;

	private String description;

	private String name;

	private String tag;

	//bi-directional many-to-one association to Mineral
	@ManyToOne
	@JoinColumn(name="ref_minerals")
	private Mineral mineral;

	//bi-directional many-to-one association to Nutrition
	@ManyToOne
	@JoinColumn(name="ref_nutrition")
	private Nutrition nutrition;

	//bi-directional many-to-one association to Vitamin
	@ManyToOne
	@JoinColumn(name="ref_vitamins")
	private Vitamin vitamin;

	public FoodItem() {
	}

	public int getIdfoodItem() {
		return this.idfoodItem;
	}

	public void setIdfoodItem(int idfoodItem) {
		this.idfoodItem = idfoodItem;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Mineral getMineral() {
		return this.mineral;
	}

	public void setMineral(Mineral mineral) {
		this.mineral = mineral;
	}

	public Nutrition getNutrition() {
		return this.nutrition;
	}

	public void setNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}

	public Vitamin getVitamin() {
		return this.vitamin;
	}

	public void setVitamin(Vitamin vitamin) {
		this.vitamin = vitamin;
	}

}