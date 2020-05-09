package com.capg.mms.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.capg.mms.booking.Exception.TicketCancellationException;
import com.capg.mms.booking.Exception.TicketNotFoundException;
import com.capg.mms.booking.model.Booking;
import com.capg.mms.booking.model.Seat;
import com.capg.mms.booking.model.Ticket;
import com.capg.mms.booking.repository.TicketRepo;

@Service
public class TicketServiceImpl implements ITicketService {
	@Autowired
    TicketRepo ticketRepo;
	
//	Lst<Seat> seats;

	@Override
	public Ticket showTicketById(int ticketId) {
		// TODO Auto-generated method stub
		return ticketRepo.getOne(ticketId);
	}
	
	@Override
	public Ticket addTicketById(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepo.save(ticket);
	}
	
//	@Override
//	public Seat addBookingById(int seatId) {
//		return ticketRepo.save(seatId);
//		
//	}

	@Override
	public boolean cancelBookingById(int ticketId) throws TicketCancellationException {

		//boolean flag = false;
		if (ticketRepo.existsById(ticketId)) 
		{
			ticketRepo.deleteById(ticketId);
		}
		else {
			throw new TicketCancellationException("Cancellation Failed : Id not found");
		}
		return true;

	}

}
