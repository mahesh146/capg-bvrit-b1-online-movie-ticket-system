package com.capg.mms.user.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.mms.user.register.execption.InvalidInputException;
import com.capg.mms.user.register.model.User;
import com.capg.mms.user.register.repo.IUserRepo;
import com.capg.mms.user.register.service.IUserService;

@SpringBootTest
class MmsUserRegisterMsApplicationTests {

	@Autowired
	IUserService userService;
	
	@Autowired
	IUserRepo userRepo;
	
	@Test
	public void testValidUserContact() throws InvalidInputException{
		assertEquals(true, userService.validateUserPhoneNo("7286883270"));
	}
	@Test
	public void testValidUserEmail() throws InvalidInputException{
		assertEquals(true, userService.validateUserEmail("saicharan20399@gmail.com"));
	}
	@Test
	public void testInvalidUserEmail(){
		 Exception exception = assertThrows(InvalidInputException.class, () -> {
			 userService.validateUserEmail("thisisnotmail");
		    });
		 
		    String expectedMessage = "Email id is not a valid one";
		    String actualMessage = exception.getMessage();
		 
		    assertFalse(actualMessage.contains(expectedMessage));
	}
	@Test
	public void testUserPhoneNoWithLessDigits() throws InvalidInputException{
		
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			userService.validateUserPhoneNo("8743210");
		    });
		 
		    String expectedMessage = "Phone number should be of 10 digits";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testUserPhoneNoWithMoreDigits() throws InvalidInputException{
		
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			userService.validateUserPhoneNo("87432234565810");
		    });
		 
		    String expectedMessage = "Phone number should be of 10 digits";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	public void testValidUserName() {
		assertEquals(true, userService.validateUserName("saicharan20399"));
	}
}
