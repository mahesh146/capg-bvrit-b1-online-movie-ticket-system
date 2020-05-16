package com.capg.mms.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.movie.exception.MovieException;
import com.capg.mms.movie.model.Movie;
import com.capg.mms.movie.repository.IMovieRepository;


@Service
public class MovieServiceImpl implements IMovieService {
	@Autowired
	IMovieRepository movieRepo;

	@Override
	public Movie addMovie(Movie movie)throws MovieException {
		return movieRepo.save(movie);
	}

	@Override
	public Movie updateMovie(Movie movie) throws MovieException {
		
		
		Integer movieId = movie.getMovieId();
		if( movieRepo.existsById(movieId))
		{ 
			Movie updateMovie=movieRepo.getOne(movieId);		
		
			updateMovie.setMovieName(movie.getMovieName());
			updateMovie.setMovieDirector(movie.getMovieDirector());
			updateMovie.setMovieGenre(movie.getMovieGenre());
			updateMovie.setLanguages(movie.getLanguages());
			updateMovie.setMovieLength(movie.getMovieLength());
			updateMovie.setMovieReleaseDate(movie.getMovieReleaseDate());
			movieRepo.save(updateMovie);
		}
		return movie;
	}

	@Override
	public Boolean deleteMovieById(int movieId) throws MovieException {
		if (movieRepo.existsById(movieId)) {
			movieRepo.deleteById(movieId);
		} else {
			throw new MovieException("MovieId not Found");
		}
		return true;
	}

	@Override
	public Movie getMovieById(int movieId) {

		return movieRepo.getOne(movieId);
	}

	@Override
	public boolean validateMovieId(int movieId) throws MovieException {
		String movie = Integer.toString(movieId);
		if (!(movie.length() >= 3 && movie.charAt(0)=='3')) {
			throw new MovieException("MovieId must be minimum of 4 characters starting with 3");
		}
		return true;
	}

	@Override
	public Movie getByMovieName(String movieName) {
		
		return movieRepo.getByMovieName(movieName);
	}

	@Override
	public List<Movie> findAllMovies() {
		
		return movieRepo.findAll();
	}

}
