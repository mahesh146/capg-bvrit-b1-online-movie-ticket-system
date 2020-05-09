package com.capg.mms.theatre.controller;

import java.util.List;

import javax.print.DocFlavor.READER;

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
import com.capg.mms.theatre.model.Theatre;
import com.capg.mms.theatre.service.TheatreServiceImpl;

import oracle.net.aso.r;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/theatres")
public class TheatreController {

	@Autowired
	TheatreServiceImpl theatreService;

	/*
	 * ----------------------THEATRE RESOURCES--------------------------------------------------------------------
	 * ---
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Theatre>> findAllTheatres() throws TheatreException {

		List<Theatre> list = theatreService.findAllTheatres();
		ResponseEntity<List<Theatre>> responseEntity = new ResponseEntity<List<Theatre>>(list, HttpStatus.OK);
		return responseEntity;

	}

	@PostMapping("/add")
	public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre)throws TheatreException {
		if(theatreService.validateTheatreId(theatre.getTheatreId()))
		return new ResponseEntity<Theatre>(theatreService.addTheatre(theatre), HttpStatus.CREATED);
		return new ResponseEntity<Theatre>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/update")
	public ResponseEntity<Theatre> updateTheaterById(@RequestBody Theatre theatre) throws TheatreException {
		ResponseEntity<Theatre> responseEntity = null;

		if (theatre != null) {
			theatre = theatreService.updateTheatreById(theatre);
			responseEntity = new ResponseEntity<Theatre>(theatre, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<Theatre>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Theatre> getTheatreById(@PathVariable("id")int theatreId) throws TheatreException{
		ResponseEntity<Theatre> responseEntity=null;
		if(theatreId!=0) {
			Theatre th=theatreService.getTheatreById(theatreId);
			responseEntity=new ResponseEntity<Theatre>(th,HttpStatus.OK);
		}
	
		else {
			responseEntity = new ResponseEntity<Theatre>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
		
	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<Theatre> deleteTheatreById(@PathVariable("id") int theatreId) throws TheatreException {

		ResponseEntity<Theatre> responseEntity = null;
		if (theatreId != 0) {
			theatreService.deleteTheatreById(theatreId);
			responseEntity = new ResponseEntity<Theatre>(HttpStatus.OK);

		}
		else {
			responseEntity = new ResponseEntity<Theatre>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Theatre> getByName(@PathVariable("name") String theatreName) throws TheatreException
	{
		ResponseEntity<Theatre> responseEntity = null;
			Theatre th=theatreService.getTheatreByName(theatreName);
			responseEntity = new ResponseEntity<Theatre>(th,HttpStatus.OK);

		return responseEntity;
	}
	/*
	 * @GetMapping("/id/{id}") public ResponseEntity<Theatre> getById(@PathVariable
	 * ("id") int theatreId) throws TheatreException{
	 * 
	 * 
	 * Theatre th=theatreService.getTheatreById(theatreId); return new
	 * ResponseEntity<Theatre>(HttpStatus.OK);
	 * 
	 * }
	 */
}
