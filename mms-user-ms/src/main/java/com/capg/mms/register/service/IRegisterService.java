package com.capg.mms.register.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.mms.register.execption.InvalidInputException;
import com.capg.mms.register.model.Admin;
import com.capg.mms.register.model.Customer;
import com.capg.mms.register.model.User;


public interface IRegisterService {
	
	Customer addCustomer(Customer customer);
	
	User getCustomer(int userId);
	
	Admin addAdmin(Admin admin);
	
	User getAdmin(int userId);
		
	boolean validateCustomerContact(String customerContact) throws InvalidInputException;
	
	boolean validateAdminContact(String adminContact) throws InvalidInputException;
	
	boolean validateCustomerId(int userId) throws InvalidInputException;
	
	boolean validateAdminId(int userId) throws InvalidInputException;
	
	boolean validateAdminDob(LocalDate dateOfBirth) throws InvalidInputException;
	
	boolean validateCustomerDob(LocalDate dateOfBirth) throws InvalidInputException;
	
	List<User> getAll();
	
	
}
