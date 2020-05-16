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

	
	@Override
	public Theatre addTheatre(Theatre theatre) {
		Integer theatreId=theatre.getTheatreId();
		if(theatreId==0)
		{
			throw new InvalidInputException("theatre id must be minimum of four characters starting with 2");
		}
		else if(theatreRepo.existsById(theatreId)) {
			throw new TheatreAlreadyExistsException("user already exists with this id :"+theatreId);
		}
		
		return theatreRepo.saveAndFlush(theatre);
	}

	@Override
	public Theatre updateTheatreById(Theatre theatre){
		Integer theatreId = theatre.getTheatreId();
		if(theatreId==0)
		{
			throw new InvalidInputException("theatre id must be minimum of four characters starting with 2");
		}
		else if( theatreRepo.existsById(theatreId))
		{ 
			Theatre updateTheatre=theatreRepo.getOne(theatreId);		
			updateTheatre.setTheatreName(theatre.getTheatreName());
			updateTheatre.setTheatreCity(theatre.getTheatreCity());
			updateTheatre.setMovies(theatre.getMovies());
			updateTheatre.setManagerName(theatre.getManagerName());
			updateTheatre.setManagerContact(theatre.getManagerContact());
			theatreRepo.saveAndFlush(updateTheatre);
		}
		
		else
		{
			throw new TheatreException("Id not found");
		}
		return theatre;
	}

	@Override
	public boolean deleteTheatreById(Integer theatreId) {
		
		if( theatreRepo.existsById(theatreId))
		{
			 
			theatreRepo.deleteById(theatreId);
		}
		else
		{
			throw new TheatreException("Id not found");
		}
		return true;
		
	}

	@Override
	public List<Theatre> findAllTheatres()  {
		if(theatreRepo.findAll()==null)
		{
			throw new TheatreException("No Theatre exists");
		}
		return theatreRepo.findAll();
	}
	
	@Override
	public Theatre getTheatreByName(String theatreName) {
		
		return theatreRepo.getByTheatreName(theatreName);
	}

	@Override
	public boolean validateTheatreId(Integer theatreId)  {
		String theatre=Integer.toString(theatreId);
		if(!(theatre.length()>=4 && theatre.charAt(0)=='2')) {
			throw new TheatreException("TheatreId must be minimum of 4 characters, starting with 2..");
		}
		return true;
	}

	@Override
	public Theatre getTheatreById(Integer theatreId) {
			// TODO Auto-generated method stub
			return theatreRepo.getByTheatreId(theatreId);
	}
	
}
