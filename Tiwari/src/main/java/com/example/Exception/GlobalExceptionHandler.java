package com.example.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	//Customer exceptions	
		@ExceptionHandler(CustomerAlreadyPresentException.class)
		public ResponseEntity<ErrorDetails> handleCustomerAlreadyPresentException(CustomerAlreadyPresentException ex,WebRequest request)
		{
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), ex.getMessage());

			return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		}
		
//		Restaurant exceptions
		
		@ExceptionHandler(RestaurantAlreadyPresentException.class)
		public ResponseEntity<ErrorDetails> handleRestaurantAlreadyPresentException(RestaurantAlreadyPresentException ex,WebRequest request)
		{
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), ex.getMessage());

			return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(RestaurantNotFoundException.class)
		public ResponseEntity<ErrorDetails> handleRestaurantNotFoundExeption(RestaurantNotFoundException ex,WebRequest request)
		{
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

			return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		}
	
//		Food exceptions
		
		@ExceptionHandler(FoodAlreadyPresentException.class)
		public ResponseEntity<ErrorDetails> handleFoodAlreadyPresentException(FoodAlreadyPresentException ex,WebRequest request)
		{
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), ex.getMessage());

			return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(FoodNotFoundException.class)
		public ResponseEntity<ErrorDetails> handleFoodNotFoundExeption(FoodNotFoundException ex,WebRequest request)
		{
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

			return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		}
		
		//common exceptions
		
		@ExceptionHandler(ListEmptyException.class)
		public ResponseEntity<ErrorDetails> handleListEmptyException(ListEmptyException ex,WebRequest request)
		{
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

			return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(InvalidIdException.class)
		public ResponseEntity<ErrorDetails> handleInvalidIdException(InvalidIdException ex,WebRequest request)
		{
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

			return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		}
		

}
