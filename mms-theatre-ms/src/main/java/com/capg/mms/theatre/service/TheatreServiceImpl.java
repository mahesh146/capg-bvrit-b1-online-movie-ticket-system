package com.capg.mms.theatre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.theatre.exception.InvalidInputException;
import com.capg.mms.theatre.exception.TheatreAlreadyExistsException;
import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Theatre;
import com.capg.mms.theatre.repository.ITheatreRepo;

@Service
public class TheatreServiceImpl implements ITheatreService {
	
	
	@Autowired
	ITheatreRepo theatreRepo;

	/***************************************************************************************************************
	 * -FunctionName : addTheatre() -Input Parameters : Theatre Object -Return Type
	 * : Theatre -Throws : TheatreAlreadyExistException, Invalid Input Exception
	 * -Description : Adding Theatre to database
	 ***************************************************************************************************************/
	public Theatre addTheatre(Theatre theatre) {
		Integer theatreId = theatre.getTheatreId();
		if (theatreId == 0) {
			throw new InvalidInputException("theatre id must be minimum of four characters starting with 2");
		} else if (theatreRepo.existsById(theatreId)) {
			throw new TheatreAlreadyExistsException("user already exists with this id :" + theatreId);
		}

		return theatreRepo.saveAndFlush(theatre);
	}

	/***************************************************************************************************************
	 * -FunctionName : updateTheatre() -Input Parameters : Theatre Object -Return
	 * Type : Theatre -Throws : Invalid Input Exception,TheatreException
	 * -Description : Updating Theatre in database
	 ***************************************************************************************************************/
	public Theatre updateTheatre(Theatre theatre) {
		Integer theatreId = theatre.getTheatreId();
		if (theatreId == 0) {
			throw new InvalidInputException("theatre id must be minimum of four characters starting with 2");
		} else if (theatreRepo.existsById(theatreId)) {
			Theatre updateTheatre = theatreRepo.getOne(theatreId);
			updateTheatre.setTheatreName(theatre.getTheatreName());
			updateTheatre.setTheatreCity(theatre.getTheatreCity());
			updateTheatre.setMovies(theatre.getMovies());
			updateTheatre.setManagerName(theatre.getManagerName());
			updateTheatre.setManagerContact(theatre.getManagerContact());
			theatreRepo.saveAndFlush(updateTheatre);
		}

		else {
			throw new TheatreException("Id not found");
		}
		return theatre;
	}

	/***************************************************************************************************************
	 * -FunctionName : deleteTheatreById() -Input Parameters : TheatreId -Return
	 * Type : Void -Throws : TheatreException -Description : Deleting Theatre in
	 * database
	 ***************************************************************************************************************/
	public boolean deleteTheatreById(Integer theatreId) {

		if (theatreRepo.existsById(theatreId)) {

			theatreRepo.deleteById(theatreId);
		} else {
			throw new TheatreException("Id not found");
		}
		return true;

	}

	/***************************************************************************************************************
	 * -FunctionName : findAllTheatres() -Input Parameters : No Input -Return Type :
	 * List of Theatres -Throws : TheatreException -Description : Shows All the
	 * Theatres present in Database
	 ***************************************************************************************************************/
	public List<Theatre> findAllTheatres() {

		return theatreRepo.findAll();
	}

	/***************************************************************************************************************
	 * -FunctionName : getTheatreByName() -Input Parameters : theatreName -Return
	 * Type : Theatre -Throws : TheatreException, Invalid Input Exception
	 * -Description : Fetching Theatre from Database
	 ***************************************************************************************************************/
	public Theatre getTheatreByName(String theatreName) {

		return theatreRepo.getByTheatreName(theatreName);
	}

	/***************************************************************************************************************
	 * -FunctionName : validateTheatreById() -Input Parameters : theatreId -Return
	 * Type : Boolean -Throws : TheatreException -Description : Validates the
	 * TheatreDetails while adding Theatre into Database
	 ***************************************************************************************************************/
	@Override
	public boolean validateTheatreId(Integer theatreId) {
		String theatre = Integer.toString(theatreId);
		if (!(theatre.length() >= 4 && theatre.charAt(0) == '2')) {
			throw new TheatreException("TheatreId must be minimum of 4 characters, starting with 2..");
		}
		return true;
	}

	/***************************************************************************************************************
	 * -FunctionName : getTheatreById() -Input Parameters : theatreId -Return Type :
	 * Theatre -Throws : Invalid Input Exception -Description : Fetches TheatreId
	 * from Database based on TheatreId
	 ***************************************************************************************************************/
	@Override
	public Theatre getTheatreById(Integer theatreId) {
		return theatreRepo.getByTheatreId(theatreId);
	}
}
