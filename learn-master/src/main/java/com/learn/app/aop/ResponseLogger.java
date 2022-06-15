package com.learn.app.aop;

import com.learn.app.controller.EmployeeService;
import com.learn.app.data.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResponseLogger {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.learn.app.controller.EmployeeService.getEmployee(..))")
    public void logRequest(JoinPoint joinPoint) throws Throwable {
        logger.info("value passed to {}",  joinPoint.getSignature().getName());
        logger.info("Input parameters passed {}",  joinPoint.getArgs());
    }

    @After("execution(* com.learn.app.controller.EmployeeService.getEmployee(..))")
    public void logResponse(JoinPoint joinPoint) throws Throwable {
        logger.info("value returned by {}",  joinPoint.getSignature().getName());
        logger.info("responded with parameters {}",  joinPoint.getTarget());
    }

    @Around("@annotation(PayloadLogger)")
    public Object logPayload(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("logPayload:Input parameters passed {}",  joinPoint.getArgs());
        Object employees = joinPoint.proceed();
        logger.info("logPayload:responded with parameters {}",  joinPoint.getTarget());
        return employees;
    }
}
