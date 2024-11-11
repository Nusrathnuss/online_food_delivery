package com.tap.main;

import java.util.ArrayList;

import com.tap.dao.MenuDao;
import com.tap.daoimpl.MenuDaoimpl;
import com.tap.model.Menu;

public class MenuMain {
	public static void main(String []args) {
		//Menu m=new Menu(3,"idly","goodtaste",60,1, null,1);
		MenuDao mdao=new MenuDaoimpl();
	//int status=mdao.updateMenuById(1,1);
		//System.out.println(status);
		
		//int status=mdao.deleteMenuById(2);
	//	System.out.println(status);
		
		Menu menu=mdao.getMenuById(1);
	System.out.println(menu);
		
		
//	int status=	mdao.insert(m);
//	System.out.println(status);
		
//		
//	ArrayList<Menu> menus=(ArrayList<Menu>)mdao.getAllMenu();
//		for(Menu m:menus) {
//			System.out.println(m);
//		
//		
//		}
	}
			
	}




