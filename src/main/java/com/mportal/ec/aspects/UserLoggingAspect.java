package com.mportal.ec.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserLoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoggingAspect.class);
	
	
	@Around("execution(* com.mportal.ec.services.UserService.createUser (..))")
    public Object aroundCreateUser(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
 
		LOGGER.info("A request was issued for CreateUser:");
 
		Object value = null;
		
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking getName() method. Return value="+value);
		
		return value;
    }
}
