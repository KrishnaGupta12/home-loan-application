package com.lti.homeloanapplication.exception;

public class EmiOfferNotFoundException extends RuntimeException{
    private String message;
    public EmiOfferNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public EmiOfferNotFoundException() {
    }

    public String getMsg() {
        return "EmiOffer Not Found..!";
    }
}
