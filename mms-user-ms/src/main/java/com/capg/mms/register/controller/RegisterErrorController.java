package com.capg.mms.register.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mms.register.execption.InvalidInputException;
import com.capg.mms.register.execption.UserAlredyExistsException;
import com.capg.mms.register.execption.UserNotFoundException;

@ControllerAdvice
@RestController
public class RegisterErrorController {
	
	@ExceptionHandler(InvalidInputException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Input")
	public void handelInvalidInputException(){
		
	}
	@ExceptionHandler(UserAlredyExistsException.class)
	@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE,reason = "user already exists")
	public void handelUserAlredyExistsException (){
		
	}
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "user not found")
	public  void handelUserNotFoundException() {
		
	}

	
}
