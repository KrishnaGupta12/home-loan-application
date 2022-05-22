package com.lti.homeloanapplication.customexception;

public class LoanException extends Exception{

    private static final long serialVersionUID = -1178473179850029571L;

    public LoanException() {
        super();
    }

    public LoanException(String message) {
        super(message);

    }
}