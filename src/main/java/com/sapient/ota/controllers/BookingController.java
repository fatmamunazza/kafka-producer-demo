package com.sapient.ota.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sapient.ota.entities.Ticket;
import com.sapient.ota.entities.TicketDTO;
import com.sapient.ota.services.BookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/booking")
@Slf4j
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	
	
	@PostMapping("/bookTicket")
	public ResponseEntity<String> addProductDetails(@Valid @RequestBody TicketDTO ticketDTO,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			//log.error(bindingResult.getFieldErrors().toString());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
		}
		Ticket ticket = bookingService.saveBookingDetails(ticketDTO);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(ticket.getUrn());
		
	}
	@GetMapping("/bookTicket/{urn}")
	public ResponseEntity<String> getProductDetails(@PathVariable String urn) {
		String url = "http://localhost:8086/api/booking/bookTicket/"+urn;
		Ticket ticket;
		try {
			
			ticket=new RestTemplate().getForObject(url,  
                    Ticket.class);
			log.info("elastic");
		}catch(Exception e){
			log.info("mongo");
			ticket = bookingService.getBookingDetails(urn);
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(ticket.getTourName());
		
	}
	
	
}
