package com.mportal.ec.exception;

import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFactory {

    private static final Logger LOG = Logger.getLogger(ExceptionFactory.class);

    public static ApplicationSpecificException create(final Throwable cause, final ExceptionType exceptionType, final Object... messageArguments) {
        LOG.error(MessageFormat.format(exceptionType.getMessage(), messageArguments), cause);
        return new ApplicationSpecificException (exceptionType, cause, messageArguments);
    }

    public static ApplicationSpecificException create(final ExceptionType exceptionType, final Object... messageArguments) {
        LOG.error(MessageFormat.format(exceptionType.getMessage(), messageArguments));
        return new ApplicationSpecificException(exceptionType, messageArguments);
    }
}
