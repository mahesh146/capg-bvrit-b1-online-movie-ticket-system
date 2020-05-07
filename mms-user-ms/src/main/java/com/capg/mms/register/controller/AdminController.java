package com.capg.mms.register.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.capg.mms.register.model.Movie;
import com.capg.mms.register.model.Screen;
import com.capg.mms.register.model.Show;
import com.capg.mms.register.model.Theatre;
import com.capg.mms.register.service.IAdminService;
@RestController
@RequestMapping("/users")
public class AdminController {

	@Autowired
	IAdminService adminService;
//	//////////////////////////screen controller//////////////
	@PostMapping("/add/screen")
	public Screen addScreen(@RequestBody Screen screen) {
		return adminService.addScreen(screen);
	}
	@DeleteMapping("/delete/screen/id/{screenId}")
	public void deleteScreenById(@PathVariable int screenId) {
		 adminService.deleteScreenById(screenId);
		 
	}
	@PutMapping("/update/screen")
	public Screen updateScreen(Screen screen) {
		return adminService.updateScreenById(screen);
	}
	@GetMapping("/get/all/screen")
	public List<Screen> findAllScreens() {
		return adminService.findAllScreens();
	}
//	////////////////////////theatre controller/////////
	
	@PostMapping("/add/theatre")
	public Theatre addTheatre(@RequestBody Theatre theatre) {
		return adminService.addTheatre(theatre);
	}
	@DeleteMapping("/delete/theatre/id/{theatreId}")
	public void deleteTheatreById(@PathVariable int theatreId) {
		 adminService.deleteTheatreById(theatreId);
	}
	@PutMapping("/update/theatre")
	public Theatre updateTheatre(@RequestBody Theatre theatre) throws RestClientException, URISyntaxException {
		return adminService.updateTheatre(theatre);
	}
	@GetMapping("/get/all/theatre")
	public List<Theatre> findAllTheatres() {
		return adminService.findAllTheatres();
	}
//	/////////////////////////show controller/////////////
//	
	@PostMapping("/add/show")
	public Show addShow(@RequestBody Show show) {
		return adminService.addShow(show);
	}
	@PostMapping("/delete/show/id/{showId}")
	public void deleteShowById(@PathVariable int showId) {
		 adminService.deleteShowById(showId);
	}
	@PutMapping("/update/show")
	public Show updateShow(Show show) {
		return adminService.updateShowById(show);
	}
	@GetMapping("/get/all/show")
	public List<Show> findAllShows() {
		return adminService.findAllShows();
	}
	
//	/////////////////////////movie controller///////////////done
	@PostMapping("/add/movie")
	public Movie addMovie(@RequestBody Movie movie) {
		return adminService.addMovie(movie);
	}
	//done integrating
	@DeleteMapping("/delete/movie/id/{movieId}")
	public void deleteMovieById(@PathVariable int movieId) {
		adminService.deleteMovieById(movieId);
	}
	@PutMapping("/update/movie")
	public Movie updateMovie(Movie movie) {
		return adminService.updateMovie(movie);
	}
	@GetMapping("/get/movieId/{movieId}")
	public Movie getMovieById(int movieId) {
		
		return adminService.getMovieById(movieId);
	}
	
}
