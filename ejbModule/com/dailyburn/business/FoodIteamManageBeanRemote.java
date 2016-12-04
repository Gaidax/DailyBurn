package com.dailyburn.business;

import javax.ejb.Remote;

import com.dailyburn.entities.FoodItem;

@Remote
public interface FoodIteamManageBeanRemote {

	boolean addFoodItem(FoodItem foodItem);
	public FoodItem getFoodItem(int id);

}
