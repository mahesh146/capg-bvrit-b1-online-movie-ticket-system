package com.capg.mms.register.service;

import java.util.List;

import com.capg.mms.register.model.BookingMovieBean;
import com.capg.mms.register.model.BookingMovieList;

public interface IBookingService {

	public BookingMovieBean addBooking(BookingMovieBean bean);
	public BookingMovieList getAllBookings();
	public BookingMovieBean getBookingById(int bookingId);
	public void cancelBookingById(int bookingId);
}
