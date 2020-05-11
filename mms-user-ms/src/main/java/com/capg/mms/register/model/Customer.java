package com.capg.mms.register.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "customer_info")
@Inheritance
public class Customer extends User {
	
	
	private String customerName;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate dateOfBirth;
	@ElementCollection
	private List<String> myTickets;
	private String customerContact;
	
	public Customer(int userId, String password) {
		super(userId, password);
		
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<String> getMyTickets() {
		return myTickets;
	}

	public void setMyTickets(List<String> myTickets) {
		this.myTickets = myTickets;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", dateOfBirth=" + dateOfBirth + ", myTickets=" + myTickets
				+ ", customerContact=" + customerContact + ", userId=" + userId + ", password=" + password + "]";
	}

	public Customer(int userId, String password, String customerName, LocalDate dateOfBirth, List<String> myTickets,
			String customerContact) {
		super(userId, password);
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.myTickets = myTickets;
		this.customerContact = customerContact;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
		super();
	}
	
}
