package com.tap.dao;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDao {
	int insert(Menu menu);
	List<Menu>getAllMenu();
	Menu getMenuById(int id);
	int deleteMenuById(int id);
	int updateMenuById(int id,int isAvailable);

}
