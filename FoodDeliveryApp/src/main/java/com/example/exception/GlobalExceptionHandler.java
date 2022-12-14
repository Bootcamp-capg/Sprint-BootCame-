package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {	
	//Customer exceptions	
	@ExceptionHandler(CustomerAlreadyPresentException.class)
	public ResponseEntity<ErrorDetails> handleEmployeeAlreadyPresentException(CustomerAlreadyPresentException ex,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), ex.getMessage());

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
