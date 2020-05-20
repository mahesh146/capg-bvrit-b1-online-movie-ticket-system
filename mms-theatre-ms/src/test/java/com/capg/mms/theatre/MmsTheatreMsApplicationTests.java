package com.capg.mms.theatre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.mms.theatre.exception.InvalidInputException;
import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.service.ScreenServiceImpl;
import com.capg.mms.theatre.service.ShowServiceImpl;
import com.capg.mms.theatre.service.TheatreServiceImpl;
@SpringBootTest
class MmsTheatreMsApplicationTests {
	@Autowired
	ScreenServiceImpl screenService;
	@Autowired
	TheatreServiceImpl theatreService;
	@Autowired
	ShowServiceImpl showService;

	
	@Test
	public void testValidateTheatreId(){
		assertEquals(true,theatreService.validateTheatreId(23452));
	}

	@Test
	public void testInvalidTheatreId(){
		 Exception exception = assertThrows(TheatreException.class, () -> {
			theatreService.validateTheatreId(136489);
		    });
		 
		    String expectedMessage = "Invalid TheatreId";
		    String actualMessage = exception.getMessage();
		    System.out.println(actualMessage);
		 
		    assertFalse(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testValidateScreenId(){
		assertEquals(true,screenService.validateScreenId(236845));
	}

	@Test
	public void testInvalidScreenId(){
		 Exception exception = assertThrows(TheatreException.class, () -> {
			screenService.validateScreenId(123);
		    });
		 
		    String expectedMessage = "Invalid screen Id";
		    String actualMessage = exception.getMessage();
		    System.out.println(actualMessage);
		 
		    assertFalse(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testValidateShowId(){
		assertEquals(true,showService.validateShowId(235641859));
	}

	@Test
	public void testInvalidShowId(){
		 Exception exception = assertThrows(TheatreException.class, () -> {
			showService.validateShowId(2362652);
		    });
		 
		    String expectedMessage = "Invalid Show Id";
		    String actualMessage = exception.getMessage();
		    System.out.println(actualMessage);
		 
		    assertFalse(actualMessage.contains(expectedMessage));
	}
	

}
