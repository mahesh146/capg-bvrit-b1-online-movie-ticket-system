package com.capg.mms.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mms.booking.model.Booking;
import com.capg.mms.booking.model.Payment;
import com.capg.mms.booking.model.Seat;


public interface BookingMovieRepository extends JpaRepository<Booking,Integer>{


	
}
