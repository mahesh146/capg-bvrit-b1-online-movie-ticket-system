package com.capg.mms.theatre.service;

import java.util.List;

import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Show;


public interface IShowService {
	Show addShow (Show show);
	Show updateShowById(Show show) throws TheatreException;
	boolean deleteShowById(int showId) throws TheatreException;
	List<Show> findAllShows() throws TheatreException;
	Show getShowById(int showId);
	boolean validateShowId(int showId,int theatreId,int screenId)throws TheatreException;
}
