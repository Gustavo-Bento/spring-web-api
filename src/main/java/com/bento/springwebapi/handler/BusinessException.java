package com.bento.springwebapi.handler;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

    private final HttpStatus status;
    private final Object[] args;

    public BusinessException(String messageKey) {
        this(messageKey, HttpStatus.BAD_REQUEST, new Object[]{});
    }

    public BusinessException(String messageKey, HttpStatus status) {
        this(messageKey, status, new Object[]{});
    }

    public BusinessException(String messageKey, HttpStatus status, Object[] args) {
        super(messageKey);
        this.status = status;
        this.args = args;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Object[] getArgs() {
        return args;
    }
}