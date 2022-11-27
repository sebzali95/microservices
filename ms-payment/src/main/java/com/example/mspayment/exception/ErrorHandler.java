package com.example.mspayment.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.mspayment.model.constant.ExceptionConstants.UNEXPECTED_EXCEPTION_CODE;
import static com.example.mspayment.model.constant.ExceptionConstants.UNEXPECTED_EXCEPTION_MESSAGE;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleInternal(Exception exception) {
        log.error("Exception : ", exception);
        return new ExceptionResponse(UNEXPECTED_EXCEPTION_CODE, UNEXPECTED_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNotFound(NotFoundException exception) {
        log.error("NotFoundException : ", exception);
        return new ExceptionResponse(exception.getCode(), exception.getMessage());
    }
}
