package com.flightapp.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/v1.0/app")
public class DefaultController {

	@GetMapping("/test")
	@Operation(summary = "Check app status")
	private String checkAppStatus() {
		return "OK";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Check admin access after login")
	public String checkAuthStatus() {
		return "Auth Ok";
	}
}
