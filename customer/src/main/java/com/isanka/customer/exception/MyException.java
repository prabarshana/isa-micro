package com.isanka.customer.exception;

public class MyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5936531586332561278L;

	public MyException() {
		super();
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
	}
	
	

}
