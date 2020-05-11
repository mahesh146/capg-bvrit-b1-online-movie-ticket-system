package com.capg.mms.user.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.user.register.execption.InvalidInputException;
import com.capg.mms.user.register.execption.UserAlredyExistsException;
import com.capg.mms.user.register.execption.UserNotFoundException;
import com.capg.mms.user.register.model.User;
import com.capg.mms.user.register.repo.IUserRepo;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepo userRepo;
	@Override
	public User addUser(User user) {
		if(userRepo.existsById(user.getUserId())) {
			throw new UserAlredyExistsException("user already exists with this id :"+user.getUserId());
		}
		return userRepo.save(user);
	}

	@Override
	public User getUserById(int userId)  {
		if(!userRepo.existsById(userId)) {
			
			throw new UserNotFoundException("user with following id "+userId+" does not exists");
		}
		
		return userRepo.getOne(userId);
	}
	

	public User getUserByUserName(String userName) {
		return userRepo.getUserByUserName(userName);
	}

	@Override
	public boolean validateUserPhoneNo(String userContact) {
		if(!(userContact.length()==10 && userContact.charAt(0)!='0')) {
			
			throw new InvalidInputException("Phone number should be of 10 digits and should not start with 0!");
		}
		return true;
	}

	@Override
	public boolean validateUserEmail(String userEmail)  {
		
		String regex = "[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{2,4}";
		
	      if(userEmail.matches(regex))
	    	  return true;
	      else
	    	  throw new InvalidInputException("Email Id NOT valid");

	}

	@Override
	public boolean validateUserId(User user){
		
		if(user.getUserType().equals("USER"))
		{
			    String s=Integer.toString(user.getUserId());
				
				if(!(s.length()>=6 && s.charAt(0)!='0')) 
				{
					throw new InvalidInputException("please enter a six digit id");
				}
		}
		else {
			String s=Integer.toString(user.getUserId());
			if(!(s.charAt(0)=='1' && s.length()==4)) {
				throw new InvalidInputException("please enter a valid id starting with one and length should be of 4 chartercters");
			}
		
		}
		return true;
	}

	@Override
	public boolean validateUserPassword(String password)  {
		String regex="[(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])]{8,}";
		if(password.matches(regex)) {
			return true;
		}
		else 
			throw new InvalidInputException("Password should contain:- [uppercase ,lowercase ,numeric ,any of these characters={'@','$','#'} ,should contain atleast 8 characters]");
	}

	@Override
	public boolean validateUserType(String userType)  {
		if((userType.toLowerCase()).equals("ADMIN") || (userType.toLowerCase()).equals("USER")){
			return true;
		}
		else 
			throw new InvalidInputException("UserType should be either USER or ADMIN");
		}

	@Override
	public boolean validateUserName(String userName)  {
		String regex="[(?=.*[A-Za-z])(?=.*[0-9].{2,4})]{8,}";
		if(!userName.matches(regex)) {
			throw new InvalidInputException("Username should contain atleast 8 alphanumeric characters");
			
		}
		else if(userRepo.existsByUserName(userName))
			throw new InvalidInputException("Username ["+userName+"] already exists");
		else
			return true;
	}

}
