package com.tap.model;

public class User {
	private int userid;
	private String uname;
	private String email;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(int userid, String uname, String email) {
		super();
		this.userid = userid;
		this.uname = uname;
		this.email = email;
	}
	public User(String uname, String email) {
		super();
		this.uname = uname;
		this.email = email;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return userid+" "+uname+" "+email;
	}
}
