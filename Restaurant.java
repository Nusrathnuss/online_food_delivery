package com.tap.model;

public class Restaurant {
	private int restaurant_id;
	private String rname;
	private String cuisinetype;
	private int deliverytime;
	private int isActive;
	private int ratings;
	private String imgpath;
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getCuisinetype() {
		return cuisinetype;
	}
	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}
	public int getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(int deliverytime) {
		this.deliverytime = deliverytime;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public Restaurant(int restaurant_id, String rname, String cuisinetype, int deliverytime, int isActive, int ratings,
			String imgpath) {
		super();
		this.restaurant_id = restaurant_id;
		this.rname = rname;
		this.cuisinetype = cuisinetype;
		this.deliverytime = deliverytime;
		this.isActive = isActive;
		this.ratings = ratings;
		this.imgpath = imgpath;
	}
	public Restaurant(String rname, String cuisinetype, int deliverytime, int isActive, int ratings, String imgpath) {
		super();
		this.rname = rname;
		this.cuisinetype = cuisinetype;
		this.deliverytime = deliverytime;
		this.isActive = isActive;
		this.ratings = ratings;
		this.imgpath = imgpath;
	}
	public Restaurant() {
		super();
	}
	@Override
	public String toString() {
		return restaurant_id +" " + rname +" " +cuisinetype+" "+
				" "+ deliverytime+" " +isActive+"  "+ ratings+" "+ imgpath;
				
	}
	

}
