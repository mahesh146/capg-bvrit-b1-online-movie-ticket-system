package com.capg.mms.theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.theatre.exception.InvalidInputException;
import com.capg.mms.theatre.exception.TheatreAlreadyExistsException;
import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.BookingState;
import com.capg.mms.theatre.model.Show;

import com.capg.mms.theatre.repository.ShowRepo;

@Service
public class ShowServiceImpl implements IShowService {

	@Autowired
	ShowRepo showRepo;

	@Override
	public Show addShow(Show show) {
		Integer showId=show.getShowId();
		if(showId==0)
		{
			throw new InvalidInputException("show id must be minimum of four characters");
		}
		else if(showRepo.existsById(showId)) {
			throw new TheatreAlreadyExistsException("user already exists with this id :"+showId);
		}
		return showRepo.saveAndFlush(show);

	}

	@Override
	public Show updateShowById(Show show){

		int showId = show.getShowId();
		if(showId==0)
		{
			throw new InvalidInputException("show id must be minimum of four characters");
		}
		else if (showRepo.existsById(showId)) {
			Show updateShow = showRepo.getOne(showId);
			updateShow.setShowName(show.getShowName());
			updateShow.setShowStartTime(show.getShowStartTime());
			updateShow.setShowEndTime(show.getShowEndTime());
			showRepo.saveAndFlush(updateShow);
		}
		return show;
		
	}

	@Override
	public boolean deleteShowById(Integer showId)  {

	
		if (showRepo.existsById(showId)) {
			
			showRepo.deleteById(showId);
		} else {
			throw new TheatreException("Id not found");
		}
		return true;

	}

	@Override
	public List<Show> findAllShows() {
		return showRepo.findAll();

	}
	@Override
	public Show getShowById(Integer showId) {
		
		return showRepo.getOne(showId);
	}

	

}
