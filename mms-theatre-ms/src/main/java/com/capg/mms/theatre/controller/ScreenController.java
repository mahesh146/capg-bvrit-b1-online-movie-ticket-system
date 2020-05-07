package com.capg.mms.theatre.controller;

import java.util.List;

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

import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Screen;
import com.capg.mms.theatre.service.ScreenServiceImpl;


@RestController
@RequestMapping("/screen")

public class ScreenController {

	@Autowired
	ScreenServiceImpl screenService;

	public void addDummyScreens() {

		// Screen screen=new Screen(6011,2011,"4K Dolby Atmos",)
	}

	@GetMapping("/all")
	public ResponseEntity<List<Screen>> findAllScreens() throws TheatreException {

		List<Screen> list = screenService.findAllScreens();
		ResponseEntity<List<Screen>> rt = new ResponseEntity<List<Screen>>(list, HttpStatus.OK);
		return rt;

	}

	@PostMapping("/add")
	public ResponseEntity<Screen> addScreen(@RequestBody Screen screen) throws TheatreException {
		//if (screenService.validateScreenId(screenId, theatreId))
			return new ResponseEntity<Screen>(screenService.addScreen(screen), HttpStatus.CREATED);
		//return new ResponseEntity<Screen>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/update")
	public ResponseEntity<Screen> updateTheScreenById(@RequestBody Screen screen) throws TheatreException {
		ResponseEntity<Screen> rt = null;

		if (screen != null) {
			screen = screenService.updateScreenById(screen);
			rt = new ResponseEntity<Screen>(screen, HttpStatus.OK);
		} else {
			rt = new ResponseEntity<Screen>(HttpStatus.NOT_FOUND);
		}
		return rt;

	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<Screen> deleteScreenById(@PathVariable("id") int screenId) throws TheatreException {

		ResponseEntity<Screen> rt = null;

		if (screenId != 0) {

			screenService.deleteScreenById(screenId);
			rt = new ResponseEntity<Screen>(HttpStatus.OK);

		}

		else {
			rt = new ResponseEntity<Screen>(HttpStatus.NOT_FOUND);
		}
		return rt;
	}
}
