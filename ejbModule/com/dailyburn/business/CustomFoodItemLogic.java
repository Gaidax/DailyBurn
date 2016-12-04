package com.dailyburn.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.json.JSONException;
import org.json.JSONObject;

import com.dailyburn.model.CustomFoodItem;

/**
 * Session Bean implementation class CustomFoodItemLogic
 */
@Stateless
@LocalBean
public class CustomFoodItemLogic implements CustomFoodItemLogicRemote {

    /**
     * Default constructor. 
     */
    public CustomFoodItemLogic() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public JSONObject getJSON(int id) throws JSONException {
	      JSONObject obj = new JSONObject();
	      
	      obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));
		return null;
	}
	
	//private String get

}
