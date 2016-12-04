package com.dailyburn.business;

import javax.ejb.Remote;

import org.json.JSONException;
import org.json.JSONObject;


@Remote
public interface CustomFoodItemLogicRemote  {
	public JSONObject getJSON(int id) throws JSONException;
}
