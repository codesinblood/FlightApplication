package com.flightapp.user.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Actor Not Found")
public class IllegalAccessException extends Exception {

	private String code;
	private String message;
	
	public IllegalAccessException(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
