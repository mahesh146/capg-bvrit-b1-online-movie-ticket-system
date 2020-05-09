package com.capg.mms.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mms.booking.Exception.BookingBlockedException;
import com.capg.mms.booking.Exception.TicketCancellationException;
import com.capg.mms.booking.model.Seat;
import com.capg.mms.booking.model.Ticket;
import com.capg.mms.booking.service.TicketServiceImpl;


@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	TicketServiceImpl ticketservice;
	
	@PostMapping("/add")
	public ResponseEntity<Ticket> addTicketById(@RequestBody Ticket ticket){
			return new ResponseEntity<Ticket>(ticketservice.addTicketById(ticket), HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{ticketId}")	
	public ResponseEntity<Ticket> showTicketById(@PathVariable int ticketId) throws BookingBlockedException{
		Ticket ticket= ticketservice.showTicketById(ticketId);
		return new ResponseEntity<Ticket>(ticketservice.showTicketById(ticketId),HttpStatus.OK);
	}
	
//	@PostMapping("/add")
//	public ResponseEntity<Seat> addBookingById(@PathVariable int seatId){
//			return new ResponseEntity<Seat>(ticketservice.addBookingById(seatId), HttpStatus.CREATED);
//	}
//	

	@DeleteMapping("/{ticketId}")
	public ResponseEntity<Ticket> cancelBookingById(@PathVariable int ticketId) throws TicketCancellationException {
		ResponseEntity<Ticket> rt = null;
		if (ticketId!=0) {
			ticketservice.cancelBookingById(ticketId);
			rt = new ResponseEntity<Ticket>(HttpStatus.OK);
		}
		else {
			rt = new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
		}
		return rt;
	}

}
