package com.capg.mms.theatre.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.actuate.autoconfigure.health.HealthProperties.Show;

public class Booking {
private int bookingId;
private int movieId;
private int showId;
private Show showRef;
private LocalDate bookingDate;
private int transactionId;
private double totalCost;
private List<Integer> seatList;
private Ticket ticket;
public Booking() {
	super();
}
public Booking(int bookingId, int movieId, int showId, Show showRef, LocalDate bookingDate, int transactionId,
		double totalCost, List<Integer> seatList, Ticket ticket) {
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
public Show getShowRef() {
	return showRef;
}
public void setShowRef(Show showRef) {
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
public List<Integer> getSeatList() {
	return seatList;
}
public void setSeatList(List<Integer> seatList) {
	this.seatList = seatList;
}
public Ticket getTicket() {
	return ticket;
}
public void setTicket(Ticket ticket) {
	this.ticket = ticket;
}
@Override
public String toString() {
	return "Booking [bookingId=" + bookingId + ", movieId=" + movieId + ", showId=" + showId + ", showRef=" + showRef
			+ ", bookingDate=" + bookingDate + ", transactionId=" + transactionId + ", totalCost=" + totalCost
			+ ", seatList=" + seatList + ", ticket=" + ticket + "]";
}

}
