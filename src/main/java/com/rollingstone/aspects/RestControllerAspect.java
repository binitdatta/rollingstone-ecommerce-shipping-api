package com.rollingstone.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

@Aspect
@Component
public class RestControllerAspect {

	private final Logger logger = LoggerFactory.getLogger("RestControllerAspect");
	
	Counter userCreatedCounter = Metrics.counter("com.rollingstone.user.created");
	
	@Before("execution(public * com.rollingstone.spring.controller.*Controller.*(..))")
	public void generalAllMethodASpect() {
		logger.info("All Method Calls invoke this general aspect method");
	}
	
	@AfterReturning("execution(public * com.rollingstone.spring.controller.*Controller.createUser(..))")
	public void getsCalledOnUserSave() {
		logger.info("This aspect is fired when the createUser method of the controller is called");
		userCreatedCounter.increment();
	}
}
