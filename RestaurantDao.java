package com.tap.dao;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDao {
	int insert (Restaurant restaurant);
	List<Restaurant>getAllRestaurants();
	Restaurant getRestById(int id);
	int deleteRestById(int id);
	int updateRestById(int id,boolean isActive);

}
