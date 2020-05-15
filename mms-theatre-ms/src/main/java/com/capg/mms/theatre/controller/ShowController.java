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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/show")
public class ShowController {

	@Autowired
	ShowServiceImpl showService;

	@GetMapping("/all")
	public ResponseEntity<List<Show>> findAllShows() {

		List<Show> list = showService.findAllShows();
		ResponseEntity<List<Show>> responseEntity = new ResponseEntity<List<Show>>(list, HttpStatus.OK);
		return responseEntity;

	}

	@PostMapping("/add")
	public ResponseEntity<Show> addShow(@RequestBody Show show) {
		return new ResponseEntity<Show>(showService.addShow(show), HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Show> updateTheShowById(@RequestBody Show show) {

		if (show != null) {
			show = showService.updateShowById(show);
			return new ResponseEntity<Show>(show, HttpStatus.OK);
		}
		return new ResponseEntity<Show>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<Show> deleteShowById(@PathVariable("id") Integer showId) {

		if (showId != 0) {

			showService.deleteShowById(showId);

			return new ResponseEntity<Show>(HttpStatus.OK);

		}

		return new ResponseEntity<Show>(HttpStatus.NOT_FOUND);

	}
}
