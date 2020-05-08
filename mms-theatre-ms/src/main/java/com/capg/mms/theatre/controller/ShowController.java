package com.capg.mms.theatre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Show;
import com.capg.mms.theatre.service.ShowServiceImpl;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/show")
public class ShowController {

	@Autowired
	ShowServiceImpl showService;

	/*
	 * public void addDummyShows(){ Show show=new Show(10111,
	 * LocalDateTime.of(2020,04,29,16,00), LocalDateTime.of(2020,04,29,19,00),
	 * Arrays.asList(201,202), "Cineplex Evening", 5011, 6011, 2011);
	 * showService.addShow(show); }
	 */

	@GetMapping("/all")
	public ResponseEntity<List<Show>> findAllShows() throws TheatreException {

		List<Show> list = showService.findAllShows();
		ResponseEntity<List<Show>> responseEntity = new ResponseEntity<List<Show>>(list, HttpStatus.OK);
		return responseEntity;

	}

	@PostMapping("/add")
	public ResponseEntity<Show> addShow(@RequestBody Show show, int showId, @PathVariable int screenId,
			@PathVariable int theatreId) throws TheatreException {

		if (showService.validateShowId(showId, theatreId, screenId))
			return new ResponseEntity<Show>(showService.addShow(show), HttpStatus.CREATED);
		return new ResponseEntity<Show>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/update")
	public ResponseEntity<Show> updateTheShowById(@RequestBody Show show) throws TheatreException {
		ResponseEntity<Show> responseEntity = null;

		if (show != null) {
			show = showService.updateShowById(show);
			responseEntity = new ResponseEntity<Show>(show, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<Show>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<Show> deleteShowById(@PathVariable("id") int showId) throws TheatreException {

		ResponseEntity<Show> responseEntity = null;

		if (showId != 0) {

			showService.deleteShowById(showId);

			responseEntity = new ResponseEntity<Show>(HttpStatus.OK);

		}

		else {
			responseEntity = new ResponseEntity<Show>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
