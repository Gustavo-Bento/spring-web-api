package com.bento.springwebapi.handler;

/**
 * Standardized error response body returned by {@link GlobalExceptionHandler}.
 *
 * <p>Serialized to JSON in the form:</p>
 * <pre>{@code
 * {
 *   "status": "error",
 *   "error": "O campo login é obrigatório",
 *   "statusCode": 400
 * }
 * }</pre>
 *
 * @author Gustavo Bento
 */
public class ResponseError {

    /** Fixed literal indicating an error response (currently always {@code "error"}). */
    private String status;

    /** Human-readable description of the error. */
    private String error;

    /** HTTP status code associated with the error, mirrored in the response body. */
    private int statusCode;

    /**
     * Returns the response status literal.
     *
     * @return the status, typically {@code "error"}
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the response status literal.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the error message.
     *
     * @return the error description
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error message.
     *
     * @param error the error description to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Returns the HTTP status code.
     *
     * @return the numeric HTTP status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the HTTP status code.
     *
     * @param statusCode the numeric HTTP status code to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
