package com.capg.mms.movie.service;

import com.capg.mms.movie.exception.MovieException;
import com.capg.mms.movie.model.Movie;

public interface IMovieService {
	public Movie addMovie(Movie movie)throws MovieException;

	public Movie updateMovie(Movie movie) throws MovieException;

	public Boolean deleteMovieById(int movieId) throws MovieException;

	public Movie getMovieById(int movieId);
	public boolean validateMovieId(int movieId)throws MovieException;
}
