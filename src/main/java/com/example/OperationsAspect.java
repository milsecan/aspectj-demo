package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class OperationsAspect {

    private static final Logger logger = LoggerFactory.getLogger(OperationsAspect.class);

    @Before("execution(* com.example.OperationsService.sum(..))")
    public void logBeforeSum(JoinPoint joinPoint) {
        logger.info("Sum method called with arguments: {}", joinPoint.getArgs());
    }
}
