package com.flightapp.user.controller;

import java.util.List;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.flightapp.user.dto.BookTicketDTO;
import com.flightapp.user.dto.RouteDTO;
import com.flightapp.user.dto.TicketDTO;
import com.flightapp.user.service.UserOpsService;

@RestController
@RequestMapping("/v1.0/user")
public class UserOpsController {

	@Autowired
	UserOpsService userOpsService;

	// Search flight
	@GetMapping("/search/route/")
	public ResponseEntity<List<RouteDTO>> searchFlights(@RequestParam("from") String from,
			@RequestParam("to") String to, @RequestParam("start") Optional<String> start,
			@RequestParam("end") Optional<String> end, @RequestParam("roundtrip") String roundtrip)
			throws JsonMappingException, JsonProcessingException {

		List<RouteDTO> searchRoutes = userOpsService.searchRoutes(from, to, start.isPresent() ? start.get() : null,
				end.isPresent() ? end.get() : null, roundtrip);
		return new ResponseEntity<List<RouteDTO>>(searchRoutes, HttpStatus.OK);
	}

	// Book ticket by flightId
	@PostMapping("/ticket/book")
	public String bookTicket(@RequestBody BookTicketDTO ticketDTO) {
		return userOpsService.bookTicket(ticketDTO);
	}

	// Search ticket by PNR
	@GetMapping("/ticket/search")
	public ResponseEntity<TicketDTO> searchTicket(@RequestParam("pnr") Optional<String> pnr,
			@RequestParam("email") Optional<String> email) throws JsonMappingException, JsonProcessingException {
		TicketDTO ticketDto = userOpsService.searchTicket(email.isPresent() ? email.get() : null,
				pnr.isPresent() ? pnr.get() : null);
		return new ResponseEntity<TicketDTO>(ticketDto, HttpStatus.OK);
	}

	@PutMapping("/ticket/cancel")
	public ResponseEntity<String> cancelTicket(@RequestParam String pnr)
			throws JsonMappingException, JsonProcessingException {
		userOpsService.cancelTicket(pnr);
		return ResponseEntity.ok("Ticket canceled successfully");
	}

}
