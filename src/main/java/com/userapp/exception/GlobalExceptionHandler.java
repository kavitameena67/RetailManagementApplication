package com.userapp.exception;

import java.util.Date;

import com.userapp.controller.ProductController;
import com.userapp.exception.model.ProductDoesntExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.userapp.exception.model.InvalidInputException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
		
		logger.debug("Exception : "+ex.getMessage());

	    if (ex instanceof InvalidInputException) {

	    	InvalidInputException e = (InvalidInputException) ex;
	        ExceptionDetails errorDetails = new ExceptionDetails(
					new Date(), e.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	    }
	    else if (ex instanceof ProductDoesntExistsException) {
			
			ProductDoesntExistsException e = (ProductDoesntExistsException) ex;
			String message = ErrorCodes.PRODUCT_NOT_EXISTS;
			ExceptionDetails errorDetails = new ExceptionDetails(
					new Date(), message, request.getDescription(false));
			return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
		}

	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
		
}
