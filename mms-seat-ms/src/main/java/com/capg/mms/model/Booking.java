package com.capg.mms.model;

import java.time.LocalDate;
import java.util.List;





public class Booking {
	
	private int bookingId;
	private int movieId;
	private int showId;
	private int showRef;
	
	private LocalDate bookingDate;
	private int transactionId;
	private double totalCost;

	private List<Long> seatList;

	private Ticket ticket;
	
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getShowRef() {
		return showRef;
	}
	public void setShowRef(int showRef) {
		this.showRef = showRef;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public List<Long> getSeatList() {
		return seatList;
	}
	public void setSeatList(List<Long> seatList) {
		this.seatList = seatList;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Booking(int bookingId, int movieId, int showId, int showRef, LocalDate bookingDate, int transactionId,
			double totalCost, List<Long> seatList, Ticket ticket) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.showId = showId;
		this.showRef = showRef;
		this.bookingDate = bookingDate;
		this.transactionId = transactionId;
		this.totalCost = totalCost;
		this.seatList = seatList;
		this.ticket = ticket;
	}
	
	public Booking() {
		
	}
	

}
