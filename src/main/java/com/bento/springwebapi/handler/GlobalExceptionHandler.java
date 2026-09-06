package com.bento.springwebapi.handler;

import jakarta.annotation.Resource;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Resource
    private MessageSource messageSource;

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ResponseError responseError(String message, HttpStatus statusCode) {
        ResponseError responseError = new ResponseError();
        responseError.setStatus("error");
        responseError.setError(message);
        responseError.setStatusCode(statusCode.value());
        return responseError;
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessExceptionDirect(BusinessException e, WebRequest request) {
        return handleBusinessException(e, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e, WebRequest request) {
        return handleGeneral(e, request);
    }

    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        if (e instanceof UndeclaredThrowableException) {
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            return handleBusinessException((BusinessException) exception.getUndeclaredThrowable(), request);
        } else {
            String message = messageSource.getMessage("error.server", new Object[]{}, request.getLocale());
            ResponseError responseError = responseError(message, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(responseError, headers(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest request) {
        String defaultMessage = messageSource.getMessage("error.business.default", null, request.getLocale());
        String message = messageSource.getMessage(e.getMessage(), e.getArgs(), defaultMessage, request.getLocale());
        ResponseError responseError = responseError(message, e.getStatus());
        return new ResponseEntity<>(responseError, headers(), e.getStatus());
    }
}