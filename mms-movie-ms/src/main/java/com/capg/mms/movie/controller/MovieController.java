package com.capg.mms.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mms.movie.exception.MovieException;
import com.capg.mms.movie.model.Movie;
import com.capg.mms.movie.service.MovieServiceImpl;




@RestController
@RequestMapping("/movie")
public class MovieController {
@Autowired
MovieServiceImpl service;
@GetMapping("/get/id/{id}")
public Movie getMovieById(@PathVariable("id") int movieId) {
	return service.getMovieById(movieId);
}
@PostMapping("/add")
public ResponseEntity<Movie> addMovie(@RequestBody Movie movie,@PathVariable int movieId)throws MovieException {
	if(service.validateMovieId(movieId))
	return new ResponseEntity<Movie>(service.addMovie(movie), HttpStatus.CREATED);
	return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
}
@PutMapping("/update")
public ResponseEntity<Movie>updateMovie(@RequestBody Movie movie) throws MovieException {
	
	ResponseEntity<Movie> rt = null;

	if (movie != null) {
		service.updateMovie(movie);
		rt = new ResponseEntity<Movie>(HttpStatus.OK);
	} else {
		rt = new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
	}
	return rt;

}
@DeleteMapping("/delete/id/{id}")
public ResponseEntity<Movie>deleteMovie(@PathVariable("id") int movieId) throws MovieException {
	ResponseEntity<Movie> rt = null;
	if (movieId != 0) {
		service.deleteMovieById(movieId);
		rt = new ResponseEntity<Movie>(HttpStatus.OK);

	}
	
	else {
		rt = new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
	}
	return rt;
}

}
