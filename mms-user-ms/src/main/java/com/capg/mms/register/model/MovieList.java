package com.capg.mms.register.model;

import java.util.List;

public class MovieList {

	private List<Movie> movieList;
	public MovieList() {
		// TODO Auto-generated constructor stub
	}
	public MovieList(List<Movie> movieList) {
		super();
		this.movieList = movieList;
	}
	public List<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
}
