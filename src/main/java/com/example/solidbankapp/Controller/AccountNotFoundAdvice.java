package com.example.solidbankapp.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AccountNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String studentNotFound(Exception ex) {
        return ex.getMessage();
    }
}
