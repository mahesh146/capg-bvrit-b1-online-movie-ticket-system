package com.capg.mms.theatre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Theatre;
import com.capg.mms.theatre.repository.ITheatreRepo;

@Service
public class TheatreServiceImpl implements ITheatreService {
	
	
	@Autowired
	ITheatreRepo theatreRepo;
	
	
	@Override
	public Theatre addTheatre(Theatre theatre)throws TheatreException {
		
		return theatreRepo.saveAndFlush(theatre);
	}

	@Override
	public Theatre updateTheatreById(Theatre theatre) throws TheatreException{
		int theatreId = theatre.getTheatreId();
		if( theatreRepo.existsById(theatreId))
		{
			Theatre updateTheatre = theatreRepo.findById(theatreId).get();
			theatreRepo.saveAndFlush(updateTheatre);
		}
		else
		{
			throw new TheatreException("Id not found");
		}
		return theatre;
	}

	@Override
	public boolean deleteTheatreById(int theatreId) throws TheatreException{
		
		if( theatreRepo.existsById(theatreId))
		{
			 //deleteTheatre = theatreRepo.findById(theatreId).get();
			theatreRepo.deleteById(theatreId);
		}
		else
		{
			throw new TheatreException("Id not found");
		}
		return true;
		
	}

	@Override
	public List<Theatre> findAllTheatres() throws TheatreException {
		
		return theatreRepo.findAll();
	}
	
	@Override
	public Theatre getTheatreById(int theatreId) {
		// TODO Auto-generated method stub
		return theatreRepo.getByTheatreId(theatreId);
	}
	@Override
	public Theatre getTheatreByName(String theatreName) {
		// TODO Auto-generated method stub
		return theatreRepo.getByTheatreName(theatreName);
	}

	@Override
	public boolean validateTheatreId(int theatreId) throws TheatreException {
		String theatre=Integer.toString(theatreId);
		if(!(theatre.length()>=4 && theatre.charAt(0)=='2')) {
			throw new TheatreException("TheatreId must be minimum of 4 characters, starting with 2..");
		}
		return true;
	}
	
}
