package com.capg.mms.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mms.register.model.BookingMovieBean;
import com.capg.mms.register.model.BookingMovieList;
import com.capg.mms.register.service.IBookingService;

@RestController
@RequestMapping("/users")
public class BookingController {
	
	@Autowired
	IBookingService bookingService;
//done	
	@PostMapping("/addbooking")
	public BookingMovieBean addBooking(@RequestBody BookingMovieBean bean) {
		return bookingService.addBooking(bean);
	}
//done
	@GetMapping("/{bookingid}")
	public BookingMovieBean getBookingById(@PathVariable int bookingid) {
		return bookingService.getBookingById(bookingid);
	}
//done
	@DeleteMapping("/{bookingId}")
	public void deleteBooking(@PathVariable int bookingId) {
		bookingService.cancelBookingById(bookingId);
	}
//done
	@GetMapping("/getall")
	public BookingMovieList getAllBookings(){
		return bookingService.getAllBookings();
	}

}
