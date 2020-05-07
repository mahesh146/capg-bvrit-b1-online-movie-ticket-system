package com.capg.mms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="seat")
public class Seat {
	@Id
private int seatId;
	
private SeatStatus seatStatus;

private double seatPrice;
public Seat() {
	// TODO Auto-generated constructor stub
}



public Seat(int seatId, SeatStatus seatStatus, double seatPrice) {
	super();
	this.seatId = seatId;
	this.seatStatus = seatStatus;
	this.seatPrice = seatPrice;
}



public int getSeatId() {
	return seatId;
}

public void setSeatId(int seatId) {
	this.seatId = seatId;
}



public SeatStatus getSeatStatus() {
	return seatStatus;
}



public void setSeatStatus(SeatStatus seatStatus) {
	this.seatStatus = seatStatus;
}



public double getSeatPrice() {
	return seatPrice;
}

public void setSeatPrice(double seatPrice) {
	this.seatPrice = seatPrice;
}



@Override
public String toString() {
	return "Seat [seatId=" + seatId + ", seatStatus=" + seatStatus + ", seatPrice=" + seatPrice + "]";
}




}