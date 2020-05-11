package com.capg.mms.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mms.register.execption.InvalidInputException;
import com.capg.mms.register.execption.UserAlredyExistsException;
import com.capg.mms.register.execption.UserNotFoundException;
import com.capg.mms.register.model.Admin;
import com.capg.mms.register.model.Customer;
import com.capg.mms.register.model.Movie;
import com.capg.mms.register.model.Screen;
import com.capg.mms.register.model.Show;
import com.capg.mms.register.model.Theatre;
import com.capg.mms.register.model.User;
import com.capg.mms.register.service.IAdminService;
import com.capg.mms.register.service.IRegisterService;

@RestController
@RequestMapping("/users")
public class RegisterController {
	
	@Autowired
	IRegisterService service;
	
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws UserAlredyExistsException,InvalidInputException{
		
		if(service.validateCustomerId(customer.getUserId()) && service.validateCustomerContact(customer.getCustomerContact())) {
			
			return new ResponseEntity<Customer>(service.addCustomer(customer),HttpStatus.CREATED);
		}
		return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/addadmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws UserAlredyExistsException,InvalidInputException{
		if(service.validateAdminId(admin.getUserId())&&service.validateAdminContact(admin.getAdminContact())) {
			
			return new ResponseEntity<Admin>(service.addAdmin(admin),HttpStatus.CREATED); 
		}
		return new ResponseEntity<Admin>(HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/getcustomer/id/{userId}")
	public ResponseEntity<User> getCustomer(@PathVariable int userId) throws UserNotFoundException{
		
		return new ResponseEntity<User>(service.getCustomer(userId),HttpStatus.FOUND);
	}

	@GetMapping("/getadmin/id/{userId}")
	public ResponseEntity<User> getadmin(@PathVariable int userId) throws UserNotFoundException{
		return new ResponseEntity<User>(service.getAdmin(userId),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAll() {
		List<User> list=service.getAll();
		
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
		
	}
	
	
	
}
