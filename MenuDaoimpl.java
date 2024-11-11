package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDao;
import com.tap.model.Menu;
import com.tap.model.Restaurant;


public class MenuDaoimpl implements MenuDao {
	static Connection con;
	//private static List<Menu> MenuList;
	//static ArrayList<Restaurant>userList=new ArrayList();
	 static ArrayList<Menu>MenuList=new ArrayList();
	private static final String insert="insert into menu(menuid,itemname,description "
			+ ",price,isAvailable,imgpath,Restaurant_id)values(?,?,?,?,?,?,?)";
	private static final String Get_All_Menu="select*from Menu";
	 private static final String Get_Menu_By_Id="select*from menu where menuid=?";
	 private static final String delete_Menu_By_Id="delete from menu where menuid=?";
	 private static final String update_Menu_By_Id="update Menu set isAvailable=? where menuid=?";
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
	private int x;
	private Statement stmt;
	private ResultSet res;
	private Menu menu;
	@Override
	public int insert(Menu menu) {
		try {
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, menu.getMenuid());
			pstmt.setString(2,menu.getItemname());
			pstmt.setString(3,menu.getDescription());
			pstmt.setFloat(4,menu.getPrice());
			pstmt.setInt(5,menu.getIsAvailable());
			pstmt.setString(6,menu.getImgpath());
			pstmt.setInt(7,menu.getRestaurant_id());
			 x=pstmt.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
		
	@Override
	public List<Menu> getAllMenu() {
	try {
		stmt=con.createStatement();
		   res=stmt.executeQuery(Get_All_Menu);
		   MenuList=(ArrayList<Menu>)extractMenuListFromResultSet(res);
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return MenuList;
	}
	
	@Override
	public Menu getMenuById(int id) {
		try {
			pstmt=con.prepareStatement(Get_Menu_By_Id);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
		MenuList=(ArrayList<Menu>)extractMenuListFromResultSet(res);
			menu=MenuList.get(0);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return menu;
	}
		
	@Override
	public int deleteMenuById(int id) {
try {
			
			pstmt=con.prepareStatement(delete_Menu_By_Id);
			pstmt.setInt(1, id);
			x=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return x;
	
	}
	@Override
	public int updateMenuById(int id, int isAvailable) {
		try {
			pstmt=con.prepareStatement(update_Menu_By_Id);
			pstmt.setInt(2, id);
			pstmt.setInt(1, isAvailable);
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	static List<Menu> extractMenuListFromResultSet(ResultSet res) {
		try {
			while(res.next()) {
				MenuList.add(new Menu(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getString(7),res.getInt(6)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return MenuList;

	}
}

	