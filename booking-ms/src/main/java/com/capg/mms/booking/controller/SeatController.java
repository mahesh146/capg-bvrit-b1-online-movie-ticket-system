package com.capg.mms.booking.controller;

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


import com.capg.mms.booking.model.Seat;
import com.capg.mms.booking.service.SeatServiceImpl;


@RestController
@RequestMapping("/booking")
public class SeatController {
	
	@Autowired
	SeatServiceImpl seatService;
	
	@PostMapping("/add/seat")
	public ResponseEntity<Seat> addSeat(@Valid @RequestBody Seat seat) {
		seatService.addSeat(seat);
		return new ResponseEntity<Seat>(seat, HttpStatus.CREATED);	
	}
	
//    @PutMapping("/book/seats")
//	public ResponseEntity<List<Seat>> bookSeat(@RequestBody List<Integer> seatIds){
//		
//		return new ResponseEntity<List<Seat>>(seatService.bookSeats(seatIds), HttpStatus.OK);
//	}

	@GetMapping("/all/seats")
	public ResponseEntity<List<Seat>> AvailableSeats(){
		List<Seat> seats = seatService.getAvailableSeats();
		return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
	}	
	
//	@PutMapping("/block/seats")
//	public ResponseEntity<List<Seat>> blockSeat(@RequestBody List<Integer> seatIds){
//		return new ResponseEntity<List<Seat>>(seatService.blockSeats(seatIds), HttpStatus.OK);
//	}
//
//	@PutMapping("/cancel/seats")
//	public ResponseEntity<List<Seat>> cancelSeat(@RequestBody List<Integer> seatIds){
//		return new ResponseEntity<List<Seat>>(seatService.cancelSeats(seatIds), HttpStatus.OK);
//	}


}





