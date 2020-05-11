package com.capg.mms.booking.service;

import java.util.List;

import com.capg.mms.booking.Exception.TicketCancellationException;
import com.capg.mms.booking.Exception.TicketNotFoundException;
import com.capg.mms.booking.model.Booking;
import com.capg.mms.booking.model.Seat;
import com.capg.mms.booking.model.Ticket;

public interface ITicketService {
	
	public Ticket addTicketById(Ticket ticket);
	public Ticket showTicketById(int ticketId);


	//public Seat addBookingById(int seatId);

	public boolean cancelBookingById(int ticketId) throws TicketCancellationException;

//	public boolean cancelBookingById(int seatId) throws TicketCancellationException;


	

}
