package com.learn.app.controller.advice;

import com.learn.app.data.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {
    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private ErrorInfo notFoundError;

    @Autowired
    private ErrorInfo userNotFound;
    @Autowired
    private ErrorInfo invalidCredentials;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    ErrorInfo unhandled() {
        return notFoundError;
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidCreditalsException.class)
    @ResponseBody
    ErrorInfo invalidCredentials() {
        return invalidCredentials;
    }

//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    @org.springframework.web.bind.annotation.ExceptionHandler(UsernameNotFoundException.class)
//    @ResponseBody
//    ErrorInfo userNotException() {
//        return userNotFound;
//    }

}
