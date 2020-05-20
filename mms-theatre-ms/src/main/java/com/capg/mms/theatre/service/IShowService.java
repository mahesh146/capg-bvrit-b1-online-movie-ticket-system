package com.capg.mms.theatre.service;

import java.util.List;

import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Show;


public interface IShowService {
	Show addShow (Show show);
	Show updateShowById(Show show);
	boolean deleteShowById(Integer showId);
	List<Show> findAllShows();
	Show getShowById(Integer showId);
	boolean validateShowId(int showId);
}
