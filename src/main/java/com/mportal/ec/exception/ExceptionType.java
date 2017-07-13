package com.mportal.ec.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionType {

    HTTP_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An internal server error occurred."),
	ENTITY_EXISTS(HttpStatus.INTERNAL_SERVER_ERROR, "Entity already found");
    //you can specify your own exception types...

    private HttpStatus status;
    private String message;

    ExceptionType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
