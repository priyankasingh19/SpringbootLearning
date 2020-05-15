package com.example.demo.controllers.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.model.ErrorModel;

@ControllerAdvice
public class DefaultExceptionHandler {

	@ExceptionHandler(value=RuntimeException.class)
	public ResponseEntity<ErrorModel> CustomException(RuntimeException exception) {
		String message = exception.getMessage();
		return new ResponseEntity<ErrorModel>(new ErrorModel("412", message),
				HttpStatus.BAD_REQUEST);
	

	}
	

	@ExceptionHandler(value = InvalidHeaderException.class)
	public ResponseEntity<ErrorModel> HandleInvalidHeaderException(InvalidHeaderException exception) {
		String message = exception.getMsg();
		return new ResponseEntity<ErrorModel>(new ErrorModel("412", message),
				HttpStatus.PRECONDITION_FAILED);
	

	}
	
	@ExceptionHandler(value= ResourceNotFoundException.class)
	public ResponseEntity<ErrorModel> HandleResourceNotFoundException(ResourceNotFoundException exception){
		String message= exception.getMessage();
		System.out.println("------------------------");
		System.out.println(message);
		return new ResponseEntity<ErrorModel>(new ErrorModel("404",message), 
				HttpStatus.NOT_FOUND);
		
		
	}
	
}
