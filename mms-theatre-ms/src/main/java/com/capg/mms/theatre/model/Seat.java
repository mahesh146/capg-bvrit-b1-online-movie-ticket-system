package com.capg.mms.theatre.model;

public class Seat {
private int seatId;
private Enum seatStatus;
private double seatPrice;
public Seat() {
	super();
}
public Seat(int seatId, Enum seatStatus, double seatPrice) {
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
public Enum getSeatStatus() {
	return seatStatus;
}
public void setSeatStatus(Enum seatStatus) {
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
