package com.capg.mms.user.register.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "register_info")
public class User {

	@Id
	 private int userId;
	 private String password;
	 private String userName;
	 @DateTimeFormat(pattern = "yyyy/MM/dd")
	 private LocalDate dateOfBirth;
	 private String userContact;
	 private String userEmail;
	 private String userType;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public User(int userId, String password, String userName, LocalDate dateOfBirth, String userContact,
			String userEmail, String userType) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.userContact = userContact;
		this.userEmail = userEmail;
		this.userType = userType;
	}
	 public User() {
		
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", userName=" + userName + ", dateOfBirth="
				+ dateOfBirth + ", userContact=" + userContact + ", userEmail=" + userEmail + ", userType=" + userType
				+ "]";
	}

}
