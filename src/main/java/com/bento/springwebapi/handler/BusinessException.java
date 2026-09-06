package com.bento.springwebapi.handler;

import org.springframework.http.HttpStatus;

/**
 * Base exception for business-rule violations.
 *
 * <p>Carries the HTTP status to be returned to the client along with an
 * optional message template and formatting arguments, so that
 * {@link GlobalExceptionHandler} can build a consistent
 * {@link ResponseError} response. Subclasses (such as
 * {@link CampoObrigatorioException}) should model specific business rules.</p>
 *
 * @author Gustavo Bento
 */
public class BusinessException extends RuntimeException {

    /** HTTP status to be returned when this exception is handled. */
    private final HttpStatus status;

    /** Optional arguments used to format {@link #getMessage()} via {@link String#format}. */
    private final Object[] args;

    /**
     * Creates a business exception with {@link HttpStatus#BAD_REQUEST} and no
     * formatting arguments.
     *
     * @param messageKey the exception message, optionally containing
     *                    {@code String.format} placeholders
     */
    public BusinessException(String messageKey) {
        this(messageKey, HttpStatus.BAD_REQUEST, new Object[]{});
    }

    /**
     * Creates a business exception with a custom HTTP status and no
     * formatting arguments.
     *
     * @param messageKey the exception message, optionally containing
     *                    {@code String.format} placeholders
     * @param status     the HTTP status to return to the client
     */
    public BusinessException(String messageKey, HttpStatus status) {
        this(messageKey, status, new Object[]{});
    }

    /**
     * Creates a business exception with a custom HTTP status and message
     * formatting arguments.
     *
     * @param messageKey the exception message, optionally containing
     *                    {@code String.format} placeholders (e.g. {@code %s})
     * @param status     the HTTP status to return to the client
     * @param args       values used to fill the placeholders in {@code messageKey}
     */
    public BusinessException(String messageKey, HttpStatus status, Object[] args) {
        super(messageKey);
        this.status = status;
        this.args = args;
    }

    /**
     * Returns the HTTP status to be returned to the client.
     *
     * @return the HTTP status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Returns the arguments used to format the exception message.
     *
     * @return the formatting arguments; may be an empty array but never {@code null}
     */
    public Object[] getArgs() {
        return args;
    }
}
