package com.lti.homeloanapplication.exception;

public class EmiOfferAlReadyExistedException extends RuntimeException{

    private String message;
    public EmiOfferAlReadyExistedException(String message) {
        super(message);
        this.message = message;
    }
    public EmiOfferAlReadyExistedException() {
    }

    public String getMessage(){

        return "Product Already Exist";
    }
}
