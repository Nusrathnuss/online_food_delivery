package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;
import com.tap.model.User;

public class RestaurantDaoimpl implements RestaurantDao{
	static Connection con;
	static ArrayList<Restaurant>userList=new ArrayList();
	 static ArrayList<Restaurant>RestaurantList=new ArrayList();
	 private static final String Insert="insert into restaurant (Restaurant_id,rname,cuisinetype,deliverytime,isActive,ratings,imgpath)values(?,?,?,?,?,?,?)";
	 private static final String Get_All_Restaurants="select*from Restaurant";
	 private static final String Get_Rest_By_Id="select*from restaurant where restaurant_id=?";
	 private static final String delete_Rest_By_Id="delete from Restaurant where restaurant_id=?";
	 private static final String update_Rest_By_Id="update Restaurant set isActive=? where restaurant_id=?";
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
}

private PreparedStatement pstmt;
private Statement stmt;
private ResultSet res;
private Restaurant restaurant;
private int x;
	@Override
	public int insert(Restaurant restaurant) {
		int x=-1;
		try {
			pstmt=con.prepareStatement(Insert);
			pstmt.setInt(1, restaurant.getRestaurant_id());
			pstmt.setString(2,restaurant.getRname());
			pstmt.setString(3,restaurant.getCuisinetype());
			pstmt.setInt(4,restaurant.getDeliverytime());
			pstmt.setInt(5,restaurant.getIsActive());
			pstmt.setInt(6,restaurant.getRatings());
			pstmt.setString(7,restaurant.getImgpath());
			 x=pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	

	@Override
	public List<Restaurant> getAllRestaurants() {
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(Get_All_Restaurants);
			RestaurantList=(ArrayList<Restaurant>)extractRestaurantListFromResultSet(res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return RestaurantList;
	}

	
	




	@Override
	public Restaurant getRestById(int id) {
		try {
			pstmt=con.prepareStatement(Get_Rest_By_Id);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			RestaurantList=(ArrayList<Restaurant>)extractRestaurantListFromResultSet(res);
			restaurant=RestaurantList.get(0);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return restaurant;
	}
		// TODO Auto-generated method stub
		

	@Override
	public int deleteRestById(int id) {
		try {
			
			pstmt=con.prepareStatement(delete_Rest_By_Id);
			pstmt.setInt(1, id);
			x=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return x;
	}
	
	

	@Override
	public int updateRestById(int id, boolean isActive) {
		try {
			pstmt=con.prepareStatement(update_Rest_By_Id);
			pstmt.setInt(2, id);
			pstmt.setBoolean(1, isActive);
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	static List<Restaurant> extractRestaurantListFromResultSet(ResultSet res) {
		try {
			while(res.next()) {
				RestaurantList.add(new Restaurant(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getInt(6),res.getString(7)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return RestaurantList;

	}
	

}
