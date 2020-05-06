package com.capg.mms.register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.mms.register.model.BookingMovieBean;
import com.capg.mms.register.model.BookingMovieList;
@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	RestTemplate rt;
	@Override
	public BookingMovieBean addBooking(BookingMovieBean bean) {
		
		return rt.postForObject("http://booking-ms/booking/addbooking", bean, BookingMovieBean.class);
	}

	@Override
	public BookingMovieList getAllBookings() {
		
		return rt.getForObject("http://booking-ms/booking/all", BookingMovieList.class);
	}

	@Override
	public BookingMovieBean getBookingById(int bookingid) {
		
		return rt.getForObject("http://booking-ms/booking/"+bookingid, BookingMovieBean.class);
	}

	@Override
	public void cancelBookingById(int bookingId) {
		// TODO Auto-generated method stub
		 rt.delete("http://booking-ms/booking/"+bookingId);
	}

}
