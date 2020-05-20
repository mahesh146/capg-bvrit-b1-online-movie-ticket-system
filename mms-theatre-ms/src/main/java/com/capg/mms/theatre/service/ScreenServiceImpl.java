package com.capg.mms.theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.mms.theatre.exception.InvalidInputException;
import com.capg.mms.theatre.exception.TheatreAlreadyExistsException;
import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Screen;
import com.capg.mms.theatre.model.Theatre;
import com.capg.mms.theatre.repository.ITheatreRepo;
import com.capg.mms.theatre.repository.ScreenRepo;

@Service
public class ScreenServiceImpl implements IScreenService {

	@Autowired
	ScreenRepo screenRepo;
	 
	

	/***************************************************************************************************************
	 * -FunctionName : addScreen() -Input Parameters : Screen Object -Return Type :
	 * Screen -Throws : TheatreAlreadyExistException, Invalid Input Exception
	 * -Description : Adding Screen to database
	 ***************************************************************************************************************/
	public Screen addScreen(Screen screen) {
		Integer screenId = screen.getScreenId();
		if (screenId == 0) {
			throw new InvalidInputException("screen id must be minimum of four characters");
		} else if (screenRepo.existsById(screenId)) {
			throw new TheatreAlreadyExistsException("user already exists with this id :" + screenId);
		}

		return screenRepo.saveAndFlush(screen);
	}

	/***************************************************************************************************************
	 * -FunctionName : updateScreen() -Input Parameters : Screen Object -Return Type
	 * : Screen -Throws : Invalid Input Exception,TheatreException -Description :
	 * Updating Screen in database
	 ***************************************************************************************************************/
	public Screen updateScreenById(Screen screen) {
		Integer screenId = screen.getScreenId();
		if (screenId == 0) {
			throw new InvalidInputException("screen id must be minimum of four characters ");
		} else if (screenRepo.existsById(screenId)) {
			Screen updateScreen = screenRepo.getOne(screenId);

			updateScreen.setScreenName(screen.getScreenName());
			updateScreen.setColumns(screen.getColumns());
			updateScreen.setRows(screen.getRows());
			updateScreen.setMovieEndDate(screen.getMovieEndDate());
			screenRepo.saveAndFlush(updateScreen);
		}
		return screen;
	}

	/************************************************************************************************************
	 * -FunctionName : deleteScreenById() -Input Parameters : screenId -Return Type
	 * : Void -Throws : TheatreException -Description : Deleting Screen in database
	 ***************************************************************************************************************/
	public boolean deleteScreenById(int screenId) {

		if (screenRepo.existsById(screenId)) {
			screenRepo.deleteById(screenId);
		} else {
			throw new TheatreException("Id not found");
		}
		return true;
	}

	/***************************************************************************************************************
	 * -FunctionName : findAllScreens() -Input Parameters : No Input -Return Type :
	 * List of Screens -Throws : TheatreException -Description : Shows All the
	 * Screens present in Database
	 ***************************************************************************************************************/
	public List<Screen> findAllScreens(){

		return screenRepo.findAll();
	}

	/***************************************************************************************************************
	 * -FunctionName : getScreenById() -Input Parameters : screenId -Return Type :
	 * Screen -Throws : Invalid Input Exception -Description : Fetches Screen from
	 * Database based on ScreenId
	 ***************************************************************************************************************/
	public Screen getScreenById(int screenId) {
		return screenRepo.getOne(screenId);
	}

	/***************************************************************************************************************
	 * -FunctionName : validateScreenById() -Input Parameters : screenId -Return
	 * Type : Boolean -Throws : TheatreException -Description : Validates the
	 * ScreenDetails while adding Screen into Database
	 ***************************************************************************************************************/

	public boolean validateScreenId(int screenId) {
		String screen = Integer.toString(screenId);
		if (!(screen.length()>= 4))
			throw new TheatreException("ScreenId must be minimum of 4 characters");
		return true;
	}
}
