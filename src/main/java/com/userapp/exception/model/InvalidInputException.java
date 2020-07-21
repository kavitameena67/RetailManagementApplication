package com.userapp.exception.model;

public class InvalidInputException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}
	
	public InvalidInputException(String message) {
		super(message); 
		this.message = message;
	}

	public InvalidInputException() {
		super();
	}
}
