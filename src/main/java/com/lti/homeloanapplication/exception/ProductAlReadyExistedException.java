package com.lti.homeloanapplication.exception;

public class ProductAlReadyExistedException extends RuntimeException {


    public ProductAlReadyExistedException() {
    }

    public String getMessage() {

        return "Product Already Exist";
    }
}
