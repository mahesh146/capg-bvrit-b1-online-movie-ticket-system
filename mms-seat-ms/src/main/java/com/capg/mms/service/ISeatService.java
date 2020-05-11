package com.capg.mms.service;

import java.util.List;

import com.capg.mms.model.Seat;
import com.capg.mms.model.SeatReader;

public interface ISeatService {

	
	
	
	//Boolean deleteSeatById (int seatId);
	
	List<Seat> getAvailableSeats();
	
	 public List<Seat> bookSeats(List<Integer> seatIds);

		
	 public List<Seat> blockSeats(List<Integer> seatIds);

		
	 public List<Seat> cancelSeats(List<Integer> seatIds);

	Seat addSeat(SeatReader seatReader);
	
	//Seat blockSeatById(int seatId);
	
	//Seat cancelSeatById(int seatId);
	
}
