package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDao;
import com.tap.model.User;

public class userDaoimpl implements UserDao{
	int x=-1;
	User user;
	 static Connection con;
	 static ArrayList<User>userList=new ArrayList();
	private static final  String insert_User="insert into user(uname,email)values(?,?)";
	private static final String Get_All_UserS="select*from user";
	private static final String Get_User_By_Id="select*from user where userid=?";
	private static final String Delete_User_By_Id="delete from user where userid=?";
	private static final String Update_Address_By_Id="update user set address=? where userid=?";
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int insert(User user) {
		
		try {
			pstmt=con.prepareStatement(insert_User);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getEmail());
		 x=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public  List<User> getAllUsers() {
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(Get_All_UserS);
			userList=(ArrayList<User>)extractUserListFromResultSet(res);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUserById(int id) {
		try {
			pstmt=con.prepareStatement(Get_User_By_Id);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			userList=(ArrayList<User>)extractUserListFromResultSet(res);
			user=userList.get(0);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int deleteUserById(int id) {
		try {
			pstmt=con.prepareStatement(Delete_User_By_Id);
			pstmt.setInt(1, id);
			x=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return x;
	}
	

	@Override
	public int updateUserById(int id, String address) {
		try {
			pstmt=con.prepareStatement(Update_Address_By_Id);
			pstmt.setInt(2, id);
			pstmt.setString(1, address);
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	static List<User> extractUserListFromResultSet(ResultSet res) {
		try {
			while(res.next()) {
				userList.add(new User(res.getString(1),res.getString(2)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;

	}
	
}
