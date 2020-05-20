package com.capg.mms.theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.theatre.exception.InvalidInputException;
import com.capg.mms.theatre.exception.TheatreAlreadyExistsException;
import com.capg.mms.theatre.exception.TheatreException;

import com.capg.mms.theatre.model.Show;

import com.capg.mms.theatre.repository.ShowRepo;

@Service
public class ShowServiceImpl implements IShowService {

	@Autowired
	ShowRepo showRepo;

	/***************************************************************************************************************
	 -FunctionName                     : addShow()
	 -Input Parameters                 : Show Object
	 -Return Type                      : Show
	 -Throws				           : TheatreAlreadyExistException, Invalid Input Exception
	 -Description			           : Adding Show to database
***************************************************************************************************************/	 
	public Show addShow(Show show) {
		Integer showId = show.getShowId();
		if (showId == 0) {
			throw new InvalidInputException("show id must be minimum of four characters");
		} else if (showRepo.existsById(showId)) {
			throw new TheatreAlreadyExistsException("user already exists with this id :" + showId);
		}
		return showRepo.saveAndFlush(show);

	}
	/***************************************************************************************************************
	 -FunctionName                     : updateShow()
	 -Input Parameters                 : Show Object
	 -Return Type                      : Show
	 -Throws				           : Invalid Input Exception,TheatreException
	 -Description			           : Updating Show in database
***************************************************************************************************************/	
	public Show updateShowById(Show show) {

		int showId = show.getShowId();
		if (showId == 0) {
			throw new InvalidInputException("show id must be minimum of four characters");
		} else if (showRepo.existsById(showId)) {
			Show updateShow = showRepo.getOne(showId);
			updateShow.setShowName(show.getShowName());
			updateShow.setShowStartTime(show.getShowStartTime());
			updateShow.setShowEndTime(show.getShowEndTime());
			showRepo.saveAndFlush(updateShow);
		}
		return show;

	}
/************************************************************************************************************
	 -FunctionName                     : deleteShowById()
	 -Input Parameters                 : showId
	 -Return Type                      : Void
	 -Throws				           : TheatreException
	 -Description			           : Deleting Show in database
***************************************************************************************************************/
	public boolean deleteShowById(Integer showId) {

		if (showRepo.existsById(showId)) {

			showRepo.deleteById(showId);
		} else {
			throw new TheatreException("Id not found");
		}
		return true;

	}
/***************************************************************************************************************
	 -FunctionName                     : findAllShows()
	 -Input Parameters                 : No Input
	 -Return Type                      : List of Shows
	 -Throws				           : TheatreException
	 -Description			           : Shows All the Shows present in Database
***************************************************************************************************************/	
	public List<Show> findAllShows() {
		return showRepo.findAll();

	}
/***************************************************************************************************************
	-FunctionName                     : getShowById()
	-Input Parameters                 : showId
	-Return Type                      : Show
	-Throws				              : Invalid Input Exception
	-Description			          : Fetches Show from Database based on ShowId
***************************************************************************************************************/	
	public Show getShowById(Integer showId) {

		return showRepo.getOne(showId);
	}
/***************************************************************************************************************
	 -FunctionName                     : validateShowById()
	 -Input Parameters                 : showId
	 -Return Type                      : Boolean
	 -Throws				           : TheatreException
	 -Description			           : Validates the ShowDetails while adding Show into Database
***************************************************************************************************************/
	public boolean validateShowId(int showId) {
		String show = Integer.toString(showId);
		if (!(show.length()>=8))
			throw new TheatreException("ShowId must be minimum of 8 characters");

		return true;
	}


}
