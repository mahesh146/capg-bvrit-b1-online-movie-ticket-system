package com.capg.mms.user.register.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.web.client.RestClientException;

import com.capg.mms.user.register.model.Movie;
import com.capg.mms.user.register.model.Screen;
import com.capg.mms.user.register.model.Show;
import com.capg.mms.user.register.model.Theatre;

public interface IAdminService {

	Theatre addTheatre (Theatre theatre);
	void deleteTheatreById(int theatreId);
	Theatre updateTheatre(Theatre theatre) throws RestClientException, URISyntaxException;
	List<Theatre> findAllTheatres();
	
	
	

	  Movie addMovie(Movie movie); 
	  void deleteMovieById(int movieId); 
	  List<Movie> findAllMovies();
	  Movie updateMovie(Movie movie); 
	  Movie getMovieById(int movieId);
	 

	Screen addScreen (Screen screen);
	void deleteScreenById(int screenId);
	Screen updateScreen(Screen screen);
	List<Screen> findAllScreens();

	Show addShow (Show show);	
	Show updateShow(Show show) ;
	List<Show> findAllShows();
	void deleteShowById(int showId);
	
}
