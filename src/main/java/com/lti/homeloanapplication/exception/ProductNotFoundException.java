package com.lti.homeloanapplication.exception;

public class ProductNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ProductNotFoundException() {
    }

    public String getMsg() {
        return "Product Not Found..!";
    }
}
