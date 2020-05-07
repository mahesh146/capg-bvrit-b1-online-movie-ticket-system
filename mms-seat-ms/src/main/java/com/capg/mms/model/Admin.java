package com.capg.mms.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


public class Admin extends User {
	
	private String adminName;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate dateOfBirth;
	private String adminContact;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAdminContact() {
		return adminContact;
	}
	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}
	public Admin(int userId, String password, String adminName, LocalDate dateOfBirth, String adminContact) {
		super(userId, password);
		this.adminName = adminName;
		this.dateOfBirth = dateOfBirth;
		this.adminContact = adminContact;
	}
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", dateOfBirth=" + dateOfBirth + ", adminContact=" + adminContact
				+ ", userId=" + userId + ", password=" + password + "]";
	}
	public Admin() {
	// TODO Auto-generated constructor stub
	}
	

}
