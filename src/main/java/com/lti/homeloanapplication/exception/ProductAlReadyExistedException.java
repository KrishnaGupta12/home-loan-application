package com.lti.homeloanapplication.exception;

public class ProductAlReadyExistedException extends RuntimeException{

    private String message;
    public ProductAlReadyExistedException(String message) {
        super(message);
        this.message = message;
    }
    public ProductAlReadyExistedException() {
    }

    public String getMessage(){

        return "Product Already Exist";
    }
}
