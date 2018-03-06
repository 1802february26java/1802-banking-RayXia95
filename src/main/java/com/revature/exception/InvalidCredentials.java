package com.revature.exception;

public class InvalidCredentials extends IllegalArgumentException {

    /**
     *
     */
    private static final long serialVersionUID = -6279317866678622006L;

    public InvalidCredentials(String msg) {
	super(msg);
    }
}
