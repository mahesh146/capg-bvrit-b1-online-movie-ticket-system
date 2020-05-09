package com.capg.mms.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mms.booking.model.Seat;
import com.capg.mms.booking.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {





}
