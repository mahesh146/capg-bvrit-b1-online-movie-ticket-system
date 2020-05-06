package com.capg.mms.register.service;



import java.util.List;

import com.capg.mms.register.model.Movie;
import com.capg.mms.register.model.Screen;
import com.capg.mms.register.model.Show;
import com.capg.mms.register.model.Theatre;



public interface IAdminService {

	Theatre addTheatre (Theatre theatre);
	void deleteTheatreById(int theatreId);
	Theatre updateTheatre(Theatre theatre);
	List<Theatre> findAllTheatres();
	
	
	
	Movie addMovie(Movie movie);
	void deleteMovieById(int movieId);
	Movie updateMovie(Movie movie);
	Movie getMovieById(int movieId);

	Screen addScreen (Screen screen);
	void deleteScreenById(int screenId);
	Screen updateScreenById(Screen screen);
	List<Screen> findAllScreens();
//////	
////
	Show addShow (Show show);	
	Show updateShowById(Show show);
	List<Show> findAllShows();
	void deleteShowById(int showId);
////	
}
