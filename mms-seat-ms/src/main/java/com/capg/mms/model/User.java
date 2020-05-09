package com.capg.mms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class User {
	protected int userId;
	
	protected String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int userId, String password) {
		super();
		this.userId = userId;
		
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + "]";
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
}
