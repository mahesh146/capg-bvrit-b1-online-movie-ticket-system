package com.capg.mms.booking.service;

import java.util.List;

import com.capg.mms.booking.Exception.BookingBlockedException;
import com.capg.mms.booking.Exception.SeatNotFoundException;
import com.capg.mms.booking.Exception.TicketCancellationException;
import com.capg.mms.booking.Exception.TicketNotFoundException;
import com.capg.mms.booking.model.Booking;
import com.capg.mms.booking.model.Payment;
import com.capg.mms.booking.model.Seat;
import com.capg.mms.booking.model.Ticket;

public interface IBookingService {
	
	public List<Seat> chooseSeats(List<Integer> seatIds);
	public double calculateTotalCost(List<Seat> seats) throws SeatNotFoundException;
	public Payment choosePaymentMethod(Payment payment);
//	public boolean makePayment(Payment payment,double totalCost,List<Integer>seatIds);
	
//	public boolean cancelBookingBySeatId(int seatId) throws TicketCancellationException;
//	public Ticket showTicket(int ticketId);
//	public boolean cancelBookings(int seatId);

//	public List<Booking> getListOfSeats();
//	public Booking getSeatById(int seatId) throws BookingBlockedException;

//	public boolean cancelTicketById(int seatId) throws TicketCancellationException;
//	public Booking getTicketById(int ticketId) throws TicketNotFoundException;
	

}
