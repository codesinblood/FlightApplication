package com.flightapp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.user.dto.AirlineDTO;
import com.flightapp.user.dto.FlightDTO;
import com.flightapp.user.dto.RouteDTO;
import com.flightapp.user.service.AdminOpsService;

@RestController
@RequestMapping("/v1.0/admin")
public class AdminOpsController {

	@Autowired
	AdminOpsService adminOpsService;

	// Add airline
	@PostMapping("/airline/create")
	public ResponseEntity<String> createAirline(@RequestBody AirlineDTO airlineDto) {
		String ack = adminOpsService.createAirline(airlineDto);
		return ResponseEntity.ok(ack);
	}

	// Block/Unblock Airline
	@PutMapping("/updatestatus")
	public ResponseEntity<String> updateAirlineStatus(@RequestBody AirlineDTO airlineDto) {

		adminOpsService.updateAirline(airlineDto);
		return ResponseEntity.ok("Airline updated successfully");
	}

	// Add flight
	@PostMapping("/flight/create")
	public ResponseEntity<String> createAirline(@RequestBody FlightDTO flightDto) {
		String ack = adminOpsService.createFlight(flightDto);
		return ResponseEntity.ok(ack);
	}

	@PostMapping("/flight/route")
	public ResponseEntity<String> createRoute(@RequestBody RouteDTO routeDto) {
		String ack = adminOpsService.createRoute(routeDto);
		return ResponseEntity.ok(ack);
	}

}
