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

/**
 * Centralized exception handling for all REST controllers.
 *
 * <p>Converts {@link BusinessException} instances and any other unhandled
 * exception into a consistent {@link ResponseError} JSON payload, so
 * clients never receive raw stack traces or framework-specific error
 * formats.</p>
 *
 * @author Gustavo Bento
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /** Resolves generic, non-business error messages (e.g. {@code error.server}). */
    @Resource
    private MessageSource messageSource;

    /**
     * Builds the standard JSON headers used on every error response.
     *
     * @return headers with {@code Content-Type: application/json}
     */
    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    /**
     * Builds a {@link ResponseError} body for the given message and status.
     *
     * @param message    the error message to expose to the client
     * @param statusCode the HTTP status associated with the error
     * @return the populated {@link ResponseError}
     */
    private ResponseError responseError(String message, HttpStatus statusCode) {
        ResponseError responseError = new ResponseError();
        responseError.setStatus("error");
        responseError.setError(message);
        responseError.setStatusCode(statusCode.value());
        return responseError;
    }

    /**
     * Handles {@link BusinessException} thrown directly by a controller or
     * service method.
     *
     * @param e       the business exception raised
     * @param request the current web request, used to resolve the locale
     * @return a {@link ResponseEntity} with the exception's status and message
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessExceptionDirect(BusinessException e, WebRequest request) {
        return handleBusinessException(e, request);
    }

    /**
     * Fallback handler for any exception not otherwise handled.
     *
     * <p>Also unwraps {@link BusinessException}s that reach this handler
     * wrapped in an {@link UndeclaredThrowableException} (a side effect of
     * some dynamic proxies, e.g. from {@code @Transactional} methods).</p>
     *
     * @param e       the exception raised
     * @param request the current web request, used to resolve the locale
     * @return a {@link ResponseEntity} describing the error
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e, WebRequest request) {
        return handleGeneral(e, request);
    }

    /**
     * Resolves the appropriate error response for a generic exception,
     * delegating to {@link #handleBusinessException} when the root cause is
     * a {@link BusinessException} wrapped by a dynamic proxy.
     *
     * @param e       the exception raised
     * @param request the current web request, used to resolve the locale
     * @return a {@link ResponseEntity} with status {@code 500} for truly
     *         unexpected errors, or the business exception's own status
     *         when one is found
     */
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

    /**
     * Builds the response for a {@link BusinessException}, formatting its
     * message with any provided arguments.
     *
     * @param e       the business exception to handle
     * @param request the current web request, used to resolve the locale
     *                for the fallback default message
     * @return a {@link ResponseEntity} carrying the exception's own HTTP status
     */
    private ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest request) {
        String message;
        if (e.getMessage() != null) {
            message = (e.getArgs() != null && e.getArgs().length > 0)
                    ? String.format(e.getMessage(), e.getArgs())
                    : e.getMessage();
        } else {
            message = messageSource.getMessage("error.business.default", null, request.getLocale());
        }
        ResponseError responseError = responseError(message, e.getStatus());
        return new ResponseEntity<>(responseError, headers(), e.getStatus());
    }
}
