package com.capg.mms.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

//import com.capg.mms.exceptions.CannotBlockSeatException;
//import com.capg.mms.exceptions.CannotBookSeatException;
//import com.capg.mms.exceptions.CannotCancelSeatException;
//import com.capg.mms.exceptions.SeatAlreadyExistException;
//import com.capg.mms.exceptions.SeatException;
//import com.capg.mms.exceptions.SeatNotFoundException;
//import com.capg.mms.register.model.Ticket;
import com.capg.mms.booking.model.Seat;
import com.capg.mms.booking.model.SeatStatus;

import com.capg.mms.booking.repository.ISeatRepository;

@Service
public class SeatServiceImpl implements ISeatService {

	@Autowired
	ISeatRepository seatRepo;
	@Autowired
	RestTemplate rt;
	private Seat bookseat1;
	
	@Override
	public Seat addSeat(Seat seat) {
		
		return rt.postForObject("http://seat-ms/seat/add", seat, Seat.class);
	}
	@Override
	public List<Seat> getAvailableSeats() {
		
		return (List<Seat>) rt.getForObject("http://seat-ms/seat/all", Seat.class);
	}
//	@Override
//	public List<Seat> bookSeats(List<Integer> seatIds) {
//		// TODO Auto-generated method stub
//		return rt.put("https://seat-ms/seat/book/"+seatIds);
//	}
//	@Override
//	public List<Seat> blockSeats(List<Integer> seatIds) {
//		
//		return rt.put("https://seat-ms/seat/block/" +seatIds);
//	}
//	@Override
//	public List<Seat> cancelSeats(List<Integer> seatIds) {
//		
//		return rt.delete("http://seat-ms/seat/cancel/"+seatIds);
//	}
//
//			

		

	}
