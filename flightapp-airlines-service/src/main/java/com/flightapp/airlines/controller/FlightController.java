package com.flightapp.airlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.airlines.constants.Status;
import com.flightapp.airlines.payload.FlightSDO;
import com.flightapp.airlines.service.FlightService;

@RestController
@RequestMapping("/v1.0/flight")
public class FlightController {

	@Autowired
	FlightService flightService;

	@GetMapping
	public ResponseEntity<FlightSDO> getFlight(@RequestParam int flightId) {

		FlightSDO flight = flightService.getFlightById(flightId);
		return new ResponseEntity<FlightSDO>(flight, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<FlightSDO>> getFlightByAirline(@RequestParam int airlineId,
			@RequestParam Status status) {

		List<FlightSDO> flights = flightService.getFlightsByAirlines(airlineId, status);
		return new ResponseEntity<List<FlightSDO>>(flights, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> createFlight(@RequestBody FlightSDO flightSDO) {

		int createFlight = flightService.createFlight(flightSDO);
		return ResponseEntity.ok("Flight created successfully");
	}

}
