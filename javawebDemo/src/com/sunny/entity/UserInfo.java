package com.sunny.entity;

public class UserInfo {
	private int userId;
	private String userName;
	private String pwd;
	public UserInfo(){};
	public UserInfo(int userId, String userName, String pwd) {
		this.userId = userId;
		this.userName = userName;
		this.pwd = pwd;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
