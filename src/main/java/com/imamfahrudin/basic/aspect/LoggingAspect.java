package com.imamfahrudin.basic.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging method executions in the service layer.
 * Provides AOP-based logging before service method calls.
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * Advice that executes before any method in the service layer.
     * Logs entry into service methods.
     */
    @Before("execution(* com.imamfahrudin.basic.service.*.*(..))")
    public void logBeforeService() {
        System.out.println(">>> AOP: Entering method in Service Layer");
    }

}