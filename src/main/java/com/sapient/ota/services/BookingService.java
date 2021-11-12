package com.sapient.ota.services;

import org.springframework.stereotype.Service;

import com.sapient.ota.entities.Ticket;
import com.sapient.ota.entities.TicketDTO;

@Service
public interface BookingService {
	
	public Ticket getBookingDetails(String urn);
	public Ticket saveBookingDetails(TicketDTO ticketDTO);
}
