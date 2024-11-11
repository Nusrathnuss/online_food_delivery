package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface UserDao {
	int insert(User user);
	List<User>getAllUsers();
	User getUserById(int id);
	int deleteUserById(int id);
	int updateUserById(int id,String address);

}
