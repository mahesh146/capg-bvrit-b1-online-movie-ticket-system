package com.capg.mms.user.register.execption;

public class UserAlredyExistsException extends RuntimeException {
	public UserAlredyExistsException(String msg) {
		super(msg);
	}

}
