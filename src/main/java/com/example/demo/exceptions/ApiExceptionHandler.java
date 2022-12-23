package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(UserNotFoundException e) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = {CategoryNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(CategoryNotFoundException e) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = {LimitExceededException.class})
    public ResponseEntity<Object> handleApiRequestException(LimitExceededException e) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.NOT_ACCEPTABLE);
    }
}
