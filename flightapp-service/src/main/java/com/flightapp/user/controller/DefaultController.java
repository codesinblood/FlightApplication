package com.flightapp.user.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1.0")
public class DefaultController {

	@Value("${app.auth.username:user}")
	private String authUserName;

	@Value("${app.auth.password:user}")
	private String authPassword;

	@GetMapping
	@Operation(summary = "Check app status")
	private String defaultHandler() {
		return "OK";	
	}

	@GetMapping("/api/admin")
	private String defaultHandlerForAdmin(@RequestHeader("authorization") String authString) {
		byte[] decode = Base64.getDecoder().decode(authString.split(" ")[1]);
		String[] credentials = new String(decode).split(":");
		if (credentials[0].equalsIgnoreCase(authUserName) && credentials[1].equalsIgnoreCase(authPassword))
			return "OK";
		else
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");

	}
}
