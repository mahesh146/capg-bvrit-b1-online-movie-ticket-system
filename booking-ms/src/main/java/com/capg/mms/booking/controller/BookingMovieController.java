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
import com.capg.mms.booking.Exception.SeatNotFoundException;
import com.capg.mms.booking.Exception.TicketCancellationException;
import com.capg.mms.booking.model.Booking;
import com.capg.mms.booking.model.Payment;
import com.capg.mms.booking.model.Seat;
import com.capg.mms.booking.model.Ticket;
import com.capg.mms.booking.service.*;

@RestController
@RequestMapping("/booking")
public class BookingMovieController {
	@Autowired
	BookingServiceImpl service;
	
	@GetMapping("/id/{seatId}")	
	public ResponseEntity<Seat> calculateTotalCost(List<Seat> seats) throws SeatNotFoundException{
		double totalcost=service.calculateTotalCost(seats);
		return new ResponseEntity<Seat>(HttpStatus.OK);
	}
	
//	@GetMapping("/payment/all")
//	public ResponseEntity<Payment> makePayment(@PathVariable Payment payment, double totalCost,List<Integer>seatIds){
//		//List<Payment> PaymentMethod=service.makePayment(paymentMethod,totalcost);
//		//List<Payment> list=paymentMethod.getCardNumber();
		ResponseEntity<Payment> rt = null;
//		if(paymentMethod!=null) {
//			//service.getDetails(long cardnumber,int expmonth,int expyear,int cvc);
//			service.setCardNumber(cardnumber);
//			service.setExpMonth();
//			service.setExpYear();
//			service.setCvc();
//			rt = new ResponseEntity<Payment>(HttpStatus.OK);
//		}
//		else {
//			rt = new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
//		}
//		return rt;	
//	}
	

}
