package com.tap.main;

import java.util.ArrayList;

import com.tap.dao.UserDao;
import com.tap.daoimpl.userDaoimpl;
import com.tap.model.User;

public class Main {
	public static void main(String []args) {
		//User u=new User("nusu","nusu@gmail.com");
		UserDao udao=new userDaoimpl();
		int status=udao.updateUserById(1,"yelahanka");
		System.out.println(status);
		
//		int status=udao.deleteUserById(2);
//		System.out.println(status);
		
//		User user=udao.getUserById(2);
//		System.out.println(user);
		
		
//	int status=	udao.insert(u);
//	System.out.println(status);
		
//		
//		ArrayList<User> users=(ArrayList<User>)udao.getAllUsers();
//		for(User u:users) {
//			System.out.println(u);
		
		
		}
	
			
	}


