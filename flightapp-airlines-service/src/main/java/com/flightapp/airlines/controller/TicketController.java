package com.flightapp.airlines.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.airlines.payload.CreateTicketSDO;
import com.flightapp.airlines.payload.TicketSDO;
import com.flightapp.airlines.service.TicketService;

@RestController
@RequestMapping("/v1.0/ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping
	public ResponseEntity<TicketSDO> getTicket(@RequestParam("email") Optional<String> email,
			@RequestParam("pnr") Optional<String> pnr) {

		TicketSDO ticket = ticketService.getTicket(pnr.isPresent() ? pnr.get() : null,
				email.isPresent() ? email.get() : null);
		return new ResponseEntity<TicketSDO>(ticket, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> bookTicket(@RequestBody CreateTicketSDO ticketSDO) {

		String pnr = ticketService.bookTicket(ticketSDO);
		return ResponseEntity.ok("Ticket created successfully. Pnr - " + pnr);
	}

	@PutMapping("/cancel")
	public ResponseEntity<String> cancelTicket(@RequestParam String pnr) {
		ticketService.cancelTicket(pnr);
		return ResponseEntity.ok("Ticket canceled successfully");
	}

}
