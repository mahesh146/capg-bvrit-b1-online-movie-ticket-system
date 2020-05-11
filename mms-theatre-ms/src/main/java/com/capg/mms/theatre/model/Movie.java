package com.capg.mms.theatre.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Id;

public class Movie {

private int movieId;
private String movieName;
private List<Integer> movieGenre;
public Movie() {
	super();
}
public Movie(int movieId, String movieName, List<Integer> movieGenre, LocalDate movieDirector, int movieLength,
		List<String> languages, LocalDate movieReleaseDate) {
	super();
	this.movieId = movieId;
	this.movieName = movieName;
	this.movieGenre = movieGenre;
	this.movieDirector = movieDirector;
	this.movieLength = movieLength;
	this.languages = languages;
	this.movieReleaseDate = movieReleaseDate;
}
private LocalDate movieDirector;
private int movieLength;
private List<String> languages;
private LocalDate movieReleaseDate;
public int getMovieId() {
	return movieId;
}
public void setMovieId(int movieId) {
	this.movieId = movieId;
}
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public List<Integer> getMovieGenre() {
	return movieGenre;
}
public void setMovieGenre(List<Integer> movieGenre) {
	this.movieGenre = movieGenre;
}
public LocalDate getMovieDirector() {
	return movieDirector;
}
public void setMovieDirector(LocalDate movieDirector) {
	this.movieDirector = movieDirector;
}
public int getMovieLength() {
	return movieLength;
}
public void setMovieLength(int movieLength) {
	this.movieLength = movieLength;
}
public List<String> getLanguages() {
	return languages;
}
public void setLanguages(List<String> languages) {
	this.languages = languages;
}
public LocalDate getMovieReleaseDate() {
	return movieReleaseDate;
}
public void setMovieReleaseDate(LocalDate movieReleaseDate) {
	this.movieReleaseDate = movieReleaseDate;
}
@Override
public String toString() {
	return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre + ", movieDirector="
			+ movieDirector + ", movieLength=" + movieLength + ", languages=" + languages + ", movieReleaseDate="
			+ movieReleaseDate + "]";
}


}
