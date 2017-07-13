package com.mportal.ec.error;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mportal.ec.exception.ApplicationSpecificException;
import com.mportal.ec.exception.MyResourceNotFoundException;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSourceAccessor messageSource;

    @Autowired
    public DefaultExceptionHandler(MessageSourceAccessor messageSource) {
        Assert.notNull(messageSource, "messageSource must not be null");
        this.messageSource = messageSource;
     }

//      @ExceptionHandler(ApplicationSpecificException.class)
//      public ResponseEntity<Object> handleApplicationSpecificException(ApplicationSpecificException ex) {
//         final Error error = buildError(ex);
//         return handleExceptionInternal(ex, ex.getHttpStatus(), error);
//      }
      //expected Exceptions
      @ExceptionHandler(ApplicationSpecificException.class)
      protected ResponseEntity<Object> handleApplicationSpecificException(final RuntimeException ex, final WebRequest request) {
          final String bodyOfResponse = "This should be application specific";
          return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
      }

//       @ExceptionHandler(Exception.class)
//       public ResponseEntity<Object> handleException(Exception ex) {
//           final Error error = buildError(ex);
//           return handleExceptionInternal(ex, HttpStatus.INTERNAL_SERVER_ERROR, error);
//       }
       
      //unexpected Exceptions
      @ExceptionHandler(Exception.class)
      	protected ResponseEntity<Object> handleException(final RuntimeException ex, final WebRequest request) {
    	  final String bodyOfResponse = "This should be application specific";
    	  return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
      }
}