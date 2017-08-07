package com.mportal.ec.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.mportal.ec.services.UserService.createUser (java.lang.String,java.lang.String,java.lang.String)) && args(username,email,password)")
    public void beforeCreateUser(String username, String email,String password) {
 
        LOGGER.info("A request was issued for CreateUser: "+username+", "+email+", "+password);
    }
}
