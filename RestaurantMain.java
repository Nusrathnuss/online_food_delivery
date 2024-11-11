package com.tap.main;

import java.util.ArrayList;

import com.tap.daoimpl.RestaurantDaoimpl;
import com.tap.model.*;

public class RestaurantMain {
	public static void main(String []args) {
		//Restaurant r=new Restaurant(1,"Aldaz","good",10,1,5, null);
		RestaurantDaoimpl rdao=new RestaurantDaoimpl();
		int status=rdao.updateRestById(2,true);
		System.out.println(status);
		
//		int status=rdao.deleteRestById(2);
//		System.out.println(status);

//	Restaurant restaurant=rdao.getRestById(2);
//		System.out.println(restaurant);
//		
		
		
//		ArrayList<Restaurant> restaurants=(ArrayList<Restaurant>)rdao.getAllRestaurants();
//	for(Restaurant r:restaurants) {
//		System.out.println(r);
//		
//		
//		int status=	rdao.insert(r);
//		System.out.println(status);
	}
}
