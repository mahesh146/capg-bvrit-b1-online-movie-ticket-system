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
	public List<Screen> findAllScreens() {

		return screenService.findAllScreens();

	}

	@PostMapping("/add")
	public Screen addScreen(@RequestBody Screen screen) {
		if (screenService.validateScreenId(screen.getScreenId())) {
			Screen screen1 = screenService.addScreen(screen);
			screen = screen1;
		}
		return screen;

	}

	@PutMapping("/update")
	public Screen updateTheScreenById(@RequestBody Screen screen) {

		return screenService.updateScreenById(screen);

	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteScreenById(@PathVariable("id") int screenId) {

		screenService.deleteScreenById(screenId);

	}
}
