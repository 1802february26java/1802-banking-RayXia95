package com.revature.exception;

public class InsufficientFundException extends IllegalArgumentException {

    /**
     *
     */
    private static final long serialVersionUID = -735022637200633839L;

    public InsufficientFundException(String msg) {
	super(msg);
    }
}
