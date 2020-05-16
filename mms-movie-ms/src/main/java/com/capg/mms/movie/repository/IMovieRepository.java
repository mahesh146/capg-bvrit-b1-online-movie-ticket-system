package com.capg.mms.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mms.movie.model.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
	public Movie getByMovieName(String movieName);
	public Movie getByMovieId(int movieId);
}
