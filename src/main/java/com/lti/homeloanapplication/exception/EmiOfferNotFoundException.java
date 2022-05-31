package com.lti.homeloanapplication.exception;

public class EmiOfferNotFoundException extends RuntimeException {
    public String getMsg() {
        return "EmiOffer Not Found..!";
    }
}
