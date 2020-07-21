package com.userapp.exception.model;

public class ProductDoesntExistsException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public ProductDoesntExistsException(String message) {
		super(message);
		this.message = message;
	}

	public ProductDoesntExistsException() {
		super();
	}
}
