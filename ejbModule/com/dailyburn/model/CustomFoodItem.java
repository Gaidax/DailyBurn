package com.dailyburn.model;

public class CustomFoodItem {
	
	private String Name;
	private String Description;
	private String Protein;
	private String Fat;
	private String Carbs;

	public CustomFoodItem(String n, String desc, String prot, String fat, String carbs) {
		// TODO Auto-generated constructor stub
		this.Name = n;
		this.Description = desc;
		this.Protein = prot;
		this.Fat = fat;
		this.Carbs = carbs;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getProtein() {
		return Protein;
	}

	public void setProtein(String protein) {
		Protein = protein;
	}

	public String getFat() {
		return Fat;
	}

	public void setFat(String fat) {
		Fat = fat;
	}

	public String getCarbs() {
		return Carbs;
	}

	public void setCarbs(String carbs) {
		Carbs = carbs;
	}

}
