package com.flightapp.booking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/booking/v1.0")
public class DefaultController {

	@GetMapping
	@Operation(summary = "Check app status")
	private String defaultHandler() {
		return "OK";
	}
}
