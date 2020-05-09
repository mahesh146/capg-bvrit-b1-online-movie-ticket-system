package com.capg.mms.model;

import java.util.List;




public class Ticket {

	private int ticketId;
	private int noOfSeats;

	private List<String> seatName;
	
	private Booking booking;
	private boolean ticketStatus;
	private String screenName;

	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public List<String> getSeatName() {
		return seatName;
	}
	public void setSeatName(List<String> seatName) {
		this.seatName = seatName;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public boolean isTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public Ticket(int ticketId, int noOfSeats, List<String> seatName, Booking booking, boolean ticketStatus,
			String screenName) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.seatName = seatName;
		this.booking = booking;
		this.ticketStatus = ticketStatus;
		this.screenName = screenName;
	}
	public Ticket() {
		
	}

}
