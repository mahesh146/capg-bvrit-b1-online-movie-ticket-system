package com.capg.mms.booking.service;

import java.util.List;

import com.capg.mms.booking.model.Seat;

public interface ISeatService {
	
	Seat addSeat (Seat seat);
	
	List<Seat> getAvailableSeats();
	
//	 public List<Seat> bookSeats(List<Integer> seatIds);
//
//		
//	 public List<Seat> blockSeats(List<Integer> seatIds);
//
//		
//	 public List<Seat> cancelSeats(List<Integer> seatIds);
	
	
}
