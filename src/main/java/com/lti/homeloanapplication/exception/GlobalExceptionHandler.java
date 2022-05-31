package com.lti.homeloanapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ProductAlReadyExistedException.class)
    public ResponseEntity handleException(ProductAlReadyExistedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity handleException(ProductNotFoundException e) {
        return new ResponseEntity<>(e.getMsg(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmiOfferAlReadyExistedException.class)
    public ResponseEntity handleException(EmiOfferAlReadyExistedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = EmiOfferNotFoundException.class)
    public ResponseEntity handleException(EmiOfferNotFoundException e) {
        return new ResponseEntity<>(e.getMsg(), HttpStatus.NOT_FOUND);
    }

}

