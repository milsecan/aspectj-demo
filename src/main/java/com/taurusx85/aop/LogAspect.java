package com.taurusx85.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.taurusx85.annotation.Log)")
    public void annotated() {}


    @Around("annotated()  &&  execution(* *(..))")
    public Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before");
        Object result = joinPoint.proceed(joinPoint.getArgs());
        System.out.println("After");
        return result;
    }

}
