package com.lti.homeloanapplication.exception;

public class EmiOfferAlReadyExistedException extends RuntimeException{

    @Override
    public String getMessage(){

        return "EmiOffer Already Exist";
    }
}
