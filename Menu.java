package com.tap.model;

public class Menu {
	private int menuid;
	private String itemname;
	private String description;
	private float price;
	private int isAvailable;
	private String imgpath;
	private int Restaurant_id;
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public int getRestaurant_id() {
		return Restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		Restaurant_id = restaurant_id;
	}
	public Menu(int menuid, String itemname, String description, float price, int isAvailable, String imgpath,
			int restaurant_id) {
		super();
		this.menuid = menuid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imgpath = imgpath;
		Restaurant_id = restaurant_id;
	}
	public Menu(String itemname, String description, float price, int isAvailable, String imgpath, int restaurant_id) {
		super();
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imgpath = imgpath;
		Restaurant_id = restaurant_id;
	}
	public Menu() {
		super();
	}
	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", itemname=" + itemname + ", description=" + description + ", price=" + price
				+ ", isAvailable=" + isAvailable + ", imgpath=" + imgpath + ", Restaurant_id=" + Restaurant_id + "]";
	}
	
}
