package com.capg.mms.booking.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.capg.mms.booking.Exception.SeatNotFoundException;
import com.capg.mms.booking.model.Payment;
import com.capg.mms.booking.model.Seat;
import com.capg.mms.booking.repository.*;

@Service
public class BookingServiceImpl implements IBookingService {
	@Autowired
    BookingMovieRepository bookingmovieRepo;
	
//	@Autowired
//	ITicketService ticketService;

	List<Seat> seats;
	
	@Autowired
	RestTemplate rt;

	@Override
	public List<Seat> chooseSeats(List<Integer> seatIds) {
		//make some put calls to seat service
		
		rt.put("http://seat-ms/seat/block", seatIds);
		Seat[] blockedSeats=rt.getForObject("http://seat-ms/seat/block",Seat[].class);
		return Arrays.asList(blockedSeats);
				
	}


	@Override
	public double calculateTotalCost(List<Seat> seats) throws SeatNotFoundException {
		return seats.stream().mapToDouble(s->s.getSeatPrice()).sum();
	}


	@Override
	public Payment choosePaymentMethod(Payment payment) {
		// TODO Auto-generated method stub
		return payment;
	}


//	@Override
//	public boolean makePayment(Payment payment, double totalCost,List<Integer>seatIds) {
//		// TODO Auto-generated method stub
//		rt.put("http://seat-ms/seat/book", seatIds);
//		ticketService.addBookingBySeatId(seatIds);
//	//	ticketService.cancelBookingBySeatId(seatIds);
//		return true;
//   }


	
//	@Override
//	public Booking getTicketById(int ticketId) {
//		// TODO Auto-generated method stub
//		return bookingmovieRepo.getOne(ticketId);
//	}
//
//	@Override
//	public boolean cancelTicketById(int seatId) throws TicketCancellationException {
//
//		boolean flag = false;
//		if (bookingmovieRepo.existsById(seatId)) {
//			// deleteTheatre = theatreRepo.findById(theatreId).get();
//			bookingmovieRepo.deleteById( seatId);
//		} else {
//			throw new TicketCancellationException("Cancellation Failed : Id not found");
//		}
//		return flag;
//
//	}

//	@Override
//	public Ticket showTicket(int ticketId){
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Boolean cancelBookings(int seatId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
