package com.capg.mms.user.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.mms.user.register.model.User;
import com.capg.mms.user.register.service.IUserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users/account")
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
			return new ResponseEntity<User>(userService.addUser(user),HttpStatus.OK);
		
		
	}
	@GetMapping("{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId){
		
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.FOUND);
		
	}
	@GetMapping("/get/userName/{userName}")
	public User getUserByUserName(@PathVariable String userName) {
		return userService.getUserByUserName(userName);			
	} 
}
