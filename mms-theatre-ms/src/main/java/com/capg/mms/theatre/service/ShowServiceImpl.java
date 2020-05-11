package com.capg.mms.theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return showRepo.saveAndFlush(show);

	}

	@Override
	public Show updateShowById(Show show) throws TheatreException {

		int showId = show.getShowId();
		if (showRepo.existsById(showId)) {
			Show updateShow = showRepo.findById(showId).get();
			showRepo.saveAndFlush(updateShow);
		} else {
			throw new TheatreException("Id not found");
		}
		return show;

	}

	@Override
	public boolean deleteShowById(int showId) throws TheatreException {

	
		if (showRepo.existsById(showId)) {
			// deleteTheatre = theatreRepo.findById(theatreId).get();
			showRepo.deleteById(showId);
		} else {
			throw new TheatreException("Id not found");
		}
		return true;

	}

	@Override
	public List<Show> findAllShows() throws TheatreException {
		return showRepo.findAll();

	}
	@Override
	public Show getShowById(int showId) {
		
		return showRepo.getOne(showId);
	}

	@Override
	public boolean validateShowId(int showId, int theatreId, int screenId) throws TheatreException {
		
		String show=Integer.toString(showId);
		String theatre=Integer.toString(theatreId);
		String screen=Integer.toString(screenId);
		String show1 = show+theatre+screen;
		if(!(show1.length()>=8)) {
			throw new TheatreException("Theatre Id must be minimum of 8 characters concatinated with ShowId,TheatreId and ScreenId");
		}
		return true;
	}

}
