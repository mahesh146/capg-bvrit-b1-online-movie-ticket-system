package com.capg.mms.theatre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
//	@Test
//	public void validateScreenId(int screenId, int theatreId) throws TheatreException {
//	assertEquals(true,screenService.validateScreenId(,));
//	}
	@Test
	public void validateTheatreId(int theatreId)throws TheatreException{
		assertTrue(true,theatreService.validateTheatreId(2345));
		
		
	}
private boolean assertTrue(boolean b, boolean validateTheatreId) {
	// TODO Auto-generated method stub
	return false;
}

}
