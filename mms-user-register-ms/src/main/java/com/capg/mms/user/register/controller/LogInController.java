package com.capg.mms.user.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mms.user.register.model.User;
import com.capg.mms.user.register.service.ILogInService;

@RestController
@RequestMapping("/user")
public class LogInController {

	@Autowired
	ILogInService service;
	
	@PostMapping("/login/{userName}/{password}")
	public ResponseEntity<User> checkUserDetails(@PathVariable String userName,@PathVariable String password) {
		if(service.checkUserDetails(userName,password)) {
			 return new ResponseEntity<User>(service.getUser(userName),HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
}
