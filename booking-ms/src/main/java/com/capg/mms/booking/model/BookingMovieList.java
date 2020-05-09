package com.capg.mms.booking.model;

import java.util.List;

public class BookingMovieList {

	private List BookingMovieBean;
	
	public BookingMovieList() {
		// TODO Auto-generated constructor stub
	}
	public BookingMovieList(List bookingMovieBean) {
		super();
		BookingMovieBean = bookingMovieBean;
	}
	public List getBookingMovieBean() {
		return BookingMovieBean;
	}
	public void setBookingMovieBean(List bookingMovieBean) {
		BookingMovieBean = bookingMovieBean;
	}
	
}
