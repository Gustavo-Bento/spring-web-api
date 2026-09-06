package com.bento.springwebapi.handler;

import org.springframework.http.HttpStatus;

/**
 * Business exception thrown when a required field is missing from a request.
 *
 * <p>Always resolves to {@link HttpStatus#BAD_REQUEST} and produces a
 * message in the form {@code "O campo <campo> é obrigatório"}.</p>
 *
 * @author Gustavo Bento
 */
public class CampoObrigatorioException extends BusinessException{

    /**
     * Creates the exception for the given missing field.
     *
     * @param campo the name of the required field that was not provided
     *              (e.g. {@code "login"}, {@code "id"})
     */
    public CampoObrigatorioException(String campo) {
        super("O campo %s é obrigatório", HttpStatus.BAD_REQUEST, new Object[]{campo});
    }
}
