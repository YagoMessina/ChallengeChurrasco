package com.yago.churrasco.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        String firstErrorMessage = e.getAllErrors().get(0).getDefaultMessage();
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, "Invalid Argument.", firstErrorMessage);
        return ResponseEntity.status(error.getStatusCode()).body(error);
    }

    @ExceptionHandler(ApiException.class)
    private ResponseEntity<ApiError> handleApiException(ApiException e) {
        ApiError error = new ApiError(e);
        return ResponseEntity.status(error.getStatusCode()).body(error);
    }
}
