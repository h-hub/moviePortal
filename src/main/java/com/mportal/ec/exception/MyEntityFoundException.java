package com.mportal.ec.exception;

public class MyEntityFoundException extends RuntimeException {
	
	public MyEntityFoundException() {
        super();
    }

    public MyEntityFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyEntityFoundException(final String message) {
        super(message);
    }

    public MyEntityFoundException(final Throwable cause) {
        super(cause);
    }
    
}
