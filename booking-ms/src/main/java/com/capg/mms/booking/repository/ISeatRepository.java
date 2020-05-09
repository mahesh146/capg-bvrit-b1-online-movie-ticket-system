package com.capg.mms.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.mms.booking.model.Seat;
import com.capg.mms.booking.model.SeatStatus;

@Repository
public interface ISeatRepository extends JpaRepository<Seat, Integer> {

	@Query("from Seat where seatStatus=:seatStatus")
	public List<Seat> getAvailableSeats(SeatStatus seatStatus);
}
