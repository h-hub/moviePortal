package com.mportal.ec.exception;
 
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFactory {

	private static final Logger LOG =   LoggerFactory.getLogger(ExceptionFactory.class);

    public static ApplicationSpecificException create(final Throwable cause, final ExceptionType exceptionType, final Object... messageArguments) {
        LOG.error(MessageFormat.format(exceptionType.getMessage(), messageArguments), cause);
        return new ApplicationSpecificException (exceptionType, cause, messageArguments);
    }

    public static ApplicationSpecificException create(final ExceptionType exceptionType, final Object... messageArguments) {
        LOG.error(MessageFormat.format(exceptionType.getMessage(), messageArguments));
        return new ApplicationSpecificException(exceptionType, messageArguments);
    }
}
