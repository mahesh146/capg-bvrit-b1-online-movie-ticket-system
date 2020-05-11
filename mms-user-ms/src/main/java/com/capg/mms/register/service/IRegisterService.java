package com.capg.mms.register.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.mms.register.execption.InvalidInputException;
import com.capg.mms.register.execption.UserAlredyExistsException;
import com.capg.mms.register.execption.UserNotFoundException;
import com.capg.mms.register.model.Admin;
import com.capg.mms.register.model.Customer;
import com.capg.mms.register.model.User;


public interface IRegisterService {
	
	Customer addCustomer(Customer customer)throws UserAlredyExistsException;
	
	User getCustomer(int userId)throws UserNotFoundException;
	
	Admin addAdmin(Admin admin)throws UserAlredyExistsException;
	
	User getAdmin(int userId)throws UserNotFoundException;
		
	boolean validateCustomerContact(String customerContact) throws InvalidInputException;
	
	boolean validateAdminContact(String adminContact) throws InvalidInputException;
	
	boolean validateCustomerId(int userId) throws InvalidInputException;
	
	boolean validateAdminId(int userId) throws InvalidInputException;
	
	List<User> getAll();
	
	
}
