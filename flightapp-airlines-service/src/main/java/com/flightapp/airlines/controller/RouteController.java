package com.flightapp.airlines.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.airlines.payload.RouteSDO;
import com.flightapp.airlines.service.RouteService;

@RestController
@RequestMapping("/v1.0/route")
public class RouteController {

	@Autowired
	RouteService routeService;

	@GetMapping
	public ResponseEntity<List<RouteSDO>> getRoutes(@RequestParam("from") String fromCity,
			@RequestParam("to") String toCity, @RequestParam("start") String departure,
			@RequestParam("end") String arrival, @RequestParam("roundtrip") String isRoundTrip) {

		System.out.println("arrival - " + arrival + "departure - " + departure);
		List<RouteSDO> allRoutes = routeService.getAllRoutes(fromCity, toCity, LocalTime.parse(arrival),
				LocalTime.parse(departure), isRoundTrip);
		return new ResponseEntity<List<RouteSDO>>(allRoutes, HttpStatus.OK);
	};

}
