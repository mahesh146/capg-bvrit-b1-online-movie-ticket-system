package com.capg.mms.user.register.service;

import com.capg.mms.user.register.model.User;

public interface ILogInService {

	public boolean checkUserDetails(String userName,String password);

	public User getUser(String userName);
}
