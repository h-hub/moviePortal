package com.mportal.ec.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mportal.ec.exception.ApplicationSpecificException;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

      //expected Exceptions
      @ExceptionHandler(ApplicationSpecificException.class)
      protected ResponseEntity<Object> handleApplicationSpecificException(final RuntimeException ex, final WebRequest request) {
          final String bodyOfResponse = "This should be application specific";
          return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
      }

       
      //unexpected Exceptions
      @ExceptionHandler(Exception.class)
      	protected ResponseEntity<Object> handleException(final RuntimeException ex, final WebRequest request) {
    	  final String bodyOfResponse = "This should be application specific";
    	  return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
      }
}