package com.capg.mms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.mms.model.Seat;
import com.capg.mms.service.SeatServiceImpl;


@RestController
@RequestMapping("/seat")
public class SeatController {

	
	@Autowired
	SeatServiceImpl seatService;
	



	
	/*********************************ADD SEAT***********************************************/
	@PostMapping("/add")
	public ResponseEntity<Seat> addSeat(@Valid @RequestBody Seat seat) {
		seatService.addSeat(seat);
		return new ResponseEntity<Seat>(seat, HttpStatus.CREATED);	
	}
	
	
	/******************************BOOK SEAT******************************************/

	@PutMapping("/book")
	public ResponseEntity<List<Seat>> bookSeat(@RequestBody List<Integer> seatIds){
		//Seat bookseat = seatService.bookSeatById(seatId);
		return new ResponseEntity<List<Seat>>(seatService.bookSeats(seatIds), HttpStatus.OK);
	}
	


 

	/****************************AVAILABLE SEATS**************************************/
//	
//
//@GetMapping("/all")
//public ResponseEntity<List<Flight>> getAllFlights() {
//	List<Flight> allFlights = flightservice.getAll();
//	return new ResponseEntity<List<Flight>>(allFlights, HttpStatus.OK);
//}
	@GetMapping("/all")
	public ResponseEntity<List<Seat>> AvailableSeats(){
		List<Seat> seats = seatService.getAvailableSeats();
		return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
	}
	
	
	@PutMapping("/block")
	public ResponseEntity<List<Seat>> blockSeat(@RequestBody List<Integer> seatIds){
		return new ResponseEntity<List<Seat>>(seatService.blockSeats(seatIds), HttpStatus.OK);
	}
	
	/*************************CANCEL SEATS******************************************/
	@PutMapping("/cancel")
	public ResponseEntity<List<Seat>> cancelSeat(@RequestBody List<Integer> seatIds){
		return new ResponseEntity<List<Seat>>(seatService.cancelSeats(seatIds), HttpStatus.OK);
	}


}





