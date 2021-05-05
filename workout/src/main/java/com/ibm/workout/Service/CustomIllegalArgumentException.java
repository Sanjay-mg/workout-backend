package com.ibm.workout.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomIllegalArgumentException extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;

	public CustomIllegalArgumentException(String string) {
		super(string);
	}

	@ExceptionHandler(value = { CustomIllegalArgumentException.class, IllegalArgumentException.class })
	public ResponseEntity<Object> handleconflict(Exception ex, WebRequest request) {
		String errorMsg= new String(" ");
		errorMsg += ex.getLocalizedMessage();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("error", errorMsg);
		return new ResponseEntity<>(errorMsg, httpHeaders, HttpStatus.BAD_REQUEST);

	}
}
