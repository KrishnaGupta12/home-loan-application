package com.lti.homeloanapplication.exception;

public class ProductNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String productType;
    public ProductNotFoundException(String productType) {
        super(productType);
        this.productType = productType;
    }
    public ProductNotFoundException() {
    }

    public String getMsg() {
        return "Product Not Found..!";
    }
}
