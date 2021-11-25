package com.flightapp.airlines.controller;

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

import com.flightapp.airlines.error.NotFoundException;
import com.flightapp.airlines.payload.AirlineSDO;
import com.flightapp.airlines.service.AirlineService;


@RestController
@RequestMapping("/v1.0/airline")
public class AirlineController {

	@Autowired
	AirlineService airlineService;

	@GetMapping
	public ResponseEntity getAirline(@RequestParam("name") String name) throws NotFoundException {

		AirlineSDO findAirlineByName = airlineService.findAirlineByName(name);
		return new ResponseEntity<AirlineSDO>(findAirlineByName, HttpStatus.OK);
	}
	
	//Create Airline
	@PostMapping("/create")
	public ResponseEntity<String> createAirline(@RequestBody AirlineSDO airlineSDO) {
		
		airlineService.createAirline(airlineSDO);
		return ResponseEntity.ok("Airline created successfully");
	}
	
	//Block/Unblock Airline
	@PutMapping("/updatestatus")
	public ResponseEntity<String> updateAirlineStatus(@RequestBody AirlineSDO airlineSDO) {
		
		airlineService.updateAirline(airlineSDO);
		return ResponseEntity.ok("Airline updated successfully");
	}
	
}
