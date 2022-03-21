package com.yago.churrasco.error;

import org.springframework.http.HttpStatus;

public class ApiError {

    private int statusCode;
    private String error;
    private String message;

    public ApiError(ApiException e) {
        this.statusCode = e.getCode().value();
        this.error = e.getError();
        this.message = e.getMessage();
    }

    public ApiError(HttpStatus code, String error, String message) {
        this.statusCode = code.value();
        this.error = error;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}