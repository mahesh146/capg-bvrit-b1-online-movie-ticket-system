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
import com.capg.mms.theatre.model.Screen;
import com.capg.mms.theatre.service.ScreenServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/screen")

public class ScreenController {

	@Autowired
	ScreenServiceImpl screenService;

	public void addDummyScreens() {

		// Screen screen=new Screen(6011,2011,"4K Dolby Atmos",)
	}

	@GetMapping("/all")
	public ResponseEntity<List<Screen>> findAllScreens() {

		List<Screen> list = screenService.findAllScreens();
		ResponseEntity<List<Screen>> responseEntity = new ResponseEntity<List<Screen>>(list, HttpStatus.OK);
		return responseEntity;

	}

	@PostMapping("/add")
	public ResponseEntity<Screen> addScreen(@RequestBody Screen screen) {

		return new ResponseEntity<Screen>(screenService.addScreen(screen), HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Screen> updateTheScreenById(@RequestBody Screen screen) {

		if (screen != null) {
			screen = screenService.updateScreenById(screen);
			return new ResponseEntity<Screen>(screen, HttpStatus.OK);
		}
		return new ResponseEntity<Screen>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<Screen> deleteScreenById(@PathVariable("id") int screenId) {

		if (screenId != 0) {

			screenService.deleteScreenById(screenId);
			return new ResponseEntity<Screen>(HttpStatus.OK);

		}

		return new ResponseEntity<Screen>(HttpStatus.NOT_FOUND);

	}
}
