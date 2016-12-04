package com.dailyburn.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dailyburn.entities.FoodItem;

/**
 * Session Bean implementation class FoodIteamManageBean
 */
@Stateless
public class FoodIteamManageBean implements FoodIteamManageBeanRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="FoodObjPU")
	 private EntityManager entityManager;
	
    public FoodIteamManageBean() {
        // TODO Auto-generated constructor stub
    }
    
    public FoodItem getFoodItem(int id) {
        FoodItem fi = entityManager.find(FoodItem.class, id);
        return fi;  	
    }

	@Override
	public boolean addFoodItem(FoodItem foodItem) {
		// TODO Auto-generated method stub
		return true;
	}

}
