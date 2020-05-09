package com.capg.mms.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.mms.register.execption.InvalidInputException;
import com.capg.mms.register.repo.IRegisterAdminRepo;
import com.capg.mms.register.repo.IRegisterCustomerRepo;
import com.capg.mms.register.repo.IRegisterRepo;
import com.capg.mms.register.service.IRegisterService;

@SpringBootTest
class MmsUserMsApplicationTests {
	
	@Autowired
	IRegisterService service;
	@Autowired
	IRegisterAdminRepo admin;
	@Autowired
	IRegisterCustomerRepo customer;
	@Autowired
	IRegisterRepo repo;

	@Test
	public void testValidateCustomerContact() throws InvalidInputException{
		assertEquals(true, service.validateCustomerContact("8857596102") );
	}
	
	@Test
	public void testValidateCustomerId() throws InvalidInputException{
		assertEquals(true, service.validateCustomerId(123456));
	}
	@Test
	public void testValidateAdminContact() throws InvalidInputException{
		assertEquals(true, service.validateAdminContact("7859632211"));
	}
	@Test
	public void testvalidateAdminId() throws InvalidInputException{
		assertEquals(true, service.validateAdminId(1001));
	}
	@Test
	public void testValidateCustomerIdWithLess() throws InvalidInputException{
		Exception exception=assertThrows(InvalidInputException.class,()->{
			service.validateCustomerId(12345);
		} );
		String expectedMessage="id should not be less than 6 digits";
		String actualMessage =exception.getMessage();
		assertFalse(actualMessage.contains(expectedMessage));
	}
	@Test
	public void testValidateAdminIdWithLess() throws InvalidInputException{
		Exception exception=assertThrows(InvalidInputException.class,()->{
			service.validateAdminId(101);
		} );
		String expectedMessage="id should not be less than 4 digits";
		String actualMessage =exception.getMessage();
		assertFalse(actualMessage.contains(expectedMessage));
	}
	@Test
	public void testValidateCustomerContactWithMoreNum() throws InvalidInputException{
		Exception exception=assertThrows(InvalidInputException.class,()->{
			service.validateCustomerContact("787578578575");
		} );
		String expectedMessage="phone number should not be more than 10 digits";
		String actualMessage =exception.getMessage();
		assertFalse(actualMessage.contains(expectedMessage));
	}
	@Test
	public void testValidateCustomerContactWithLessNum() throws InvalidInputException{
		Exception exception=assertThrows(InvalidInputException.class,() ->{
			service.validateCustomerContact("785455");
		});
		String exceptedMessage="phone number should not be less than 10 numbers";
		String actualMessage=exception.getMessage();
		assertFalse(actualMessage.contains(exceptedMessage));
	}
	@Test
	public void testValidateAdminWithMoreNum() throws InvalidInputException{
		Exception exception=assertThrows(InvalidInputException.class,()->{
			service.validateAdminContact("787578578575");
		} );
		String expectedMessage="phone number should not be more than 10 digits";
		String actualMessage =exception.getMessage();
		assertFalse(actualMessage.contains(expectedMessage));
	}
	@Test
	public void testValidateAdminWithLessNum() throws InvalidInputException{
		Exception exception=assertThrows(InvalidInputException.class,()->{
			service.validateAdminContact("78757");
		} );
		String expectedMessage="phone number should not be less than 10 digits";
		String actualMessage =exception.getMessage();
		assertFalse(actualMessage.contains(expectedMessage));
	}
}
