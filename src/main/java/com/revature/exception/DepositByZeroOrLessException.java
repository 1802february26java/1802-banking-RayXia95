package com.revature.exception;

public class DepositByZeroOrLessException extends IllegalArgumentException {

    /**
     *
     */
    private static final long serialVersionUID = 2342392308672174970L;

    public DepositByZeroOrLessException(String msg) {
	super(msg);
    }

}
