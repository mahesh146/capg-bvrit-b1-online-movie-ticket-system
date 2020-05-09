package com.capg.mms.register.model;

public class Seat {
private int seatId;
private Enum seatStatus;
private double seatPrice;
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
