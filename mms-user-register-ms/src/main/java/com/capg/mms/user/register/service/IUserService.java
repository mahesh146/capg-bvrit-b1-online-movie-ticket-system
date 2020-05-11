package com.capg.mms.user.register.service;


import com.capg.mms.user.register.model.User;

public interface IUserService {

	public User addUser(User user);
	
	public User getUserById(int userId);
	
	public User getUserByUserName(String userName);
	
	public boolean validateUserPhoneNo(String userContact);
	
	public boolean validateUserEmail(String userEmail);
	
	public boolean validateUserId(User user);
	
	public boolean validateUserPassword(String password);
	
	public boolean validateUserType(String userType);
	
	public boolean validateUserName(String userName);
}
