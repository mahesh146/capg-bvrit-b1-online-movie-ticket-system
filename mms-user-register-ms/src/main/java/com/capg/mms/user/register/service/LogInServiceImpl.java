package com.capg.mms.user.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.user.register.execption.InvalidInputException;
import com.capg.mms.user.register.execption.UserNotFoundException;
import com.capg.mms.user.register.model.User;
import com.capg.mms.user.register.repo.IUserRepo;

@Service
public class LogInServiceImpl implements ILogInService {

	@Autowired
	IUserRepo userRepo;
	
	@Override
	public boolean checkUserDetails(String userName, String password) {
		if(!userRepo.existsByUserName(userName)) {
			throw new UserNotFoundException("Invalid Username or Password");
		}
		if(userRepo.existsByUserName(userName)) {
			if(!password.equals(userRepo.getUserByUserName(userName).getPassword())) {
				throw new InvalidInputException("Password mismatch");
			}
			
		}
		return true;
	}

	@Override
	public User getUser(String userName) {
		
		return userRepo.getUserByUserName(userName);
	}

}
