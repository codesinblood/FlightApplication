package com.flightapp.airlines.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Entity Not Found")
public class NotFoundException extends RuntimeException {

	private String code;
	private String message;

	public NotFoundException(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
