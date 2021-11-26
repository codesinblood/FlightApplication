package com.flightapp.airlines.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Operation not allowed")
public class OperationNotAllowedException extends RuntimeException {

	private String code;
	private String message;

	public OperationNotAllowedException(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
