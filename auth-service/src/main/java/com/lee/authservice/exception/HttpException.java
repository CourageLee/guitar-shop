package com.lee.authservice.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/26 14:55
 */
public class HttpException extends Exception{
    private final HttpStatus status;

    public HttpException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
