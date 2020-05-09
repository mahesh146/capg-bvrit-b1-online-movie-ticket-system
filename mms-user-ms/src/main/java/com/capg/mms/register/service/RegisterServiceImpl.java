package com.capg.mms.register.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.mms.register.execption.InvalidInputException;
import com.capg.mms.register.execption.UserAlredyExistsException;
import com.capg.mms.register.execption.UserNotFoundException;
import com.capg.mms.register.model.Admin;
import com.capg.mms.register.model.Customer;
import com.capg.mms.register.model.User;
import com.capg.mms.register.repo.IRegisterRepo;

@Service
public class RegisterServiceImpl implements IRegisterService {
	
	
	@Autowired
	IRegisterRepo repo;
	
	@Override
	public Customer addCustomer(Customer customer) throws UserAlredyExistsException {
		if(repo.existsById(customer.getUserId())){
			
			throw new UserAlredyExistsException("the customer with same id exists");
		}
		return repo.save(customer);
	}

	@Override
	public Admin addAdmin(Admin admin)throws UserAlredyExistsException{
		if(repo.existsById(admin.getUserId())) {
			throw new UserAlredyExistsException("the admin with this userid already exists");
		}
		return repo.save(admin);
	}

	@Override
	public boolean validateCustomerContact(String customerContact) throws InvalidInputException {
		
		if(!(customerContact.length()==10 && customerContact.charAt(0)!=0)) {
			throw new InvalidInputException("Phone number should be of 10 digits");
		}
		return true;
		
	}

	@Override
	public boolean validateAdminContact(String adminContact) throws InvalidInputException{
		
		if(!(adminContact.length()==10 && adminContact.charAt(0)!=0)) {
			throw new InvalidInputException("Phone number should be of 10 digits");
		}
		return true;
	}

	@Override
	public boolean validateCustomerId(int userId) throws InvalidInputException {
		String s=Integer.toString(userId);
		if(!(s.length()>=6 && s.charAt(0)!='0')) {
			throw new InvalidInputException("please enter a six digit id");
		}
		return true;
	}

	@Override
	public boolean validateAdminId(int userId) throws InvalidInputException {
		String s= Integer.toString(userId);
		
		if(!(s.charAt(0)=='1' && s.length()==4)) {
			throw new InvalidInputException("please enter a valid id starting with one");
		}
		return true;
	}

	@Override
	public User getCustomer(int userId) throws UserNotFoundException{
		if(!repo.existsById(userId)) {
			throw new UserNotFoundException("No user with this id :"+userId);
			}
		return repo.getOne(userId);
	}

	@Override
	public User getAdmin(int userId)throws UserNotFoundException {
		if(!repo.existsById(userId)) {
		throw new UserNotFoundException("No user with this id :"+userId);
		}
		return repo.getOne(userId);
	}

	@Override
	public List<User> getAll() {
		
		return repo.findAll();
	}

	
	}

