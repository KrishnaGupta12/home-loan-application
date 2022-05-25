package com.lti.homeloanapplication.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.lti.homeloanapplication.exception.MyException;
import com.lti.homeloanapplication.exception.OwnerAddException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(MyException.class)
	public ResponseEntity<String> handleEmptyInput(MyException myException){
		return new ResponseEntity<String>("Input fields can't be empty or null", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OwnerAddException.class)
	public ResponseEntity<String> handleEmptyInputOwner(OwnerAddException ownerex){
		return new ResponseEntity<String>("Salary and name can't be empty", HttpStatus.BAD_REQUEST);
	}
	}
