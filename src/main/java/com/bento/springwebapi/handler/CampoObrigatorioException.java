package com.bento.springwebapi.handler;

import org.springframework.http.HttpStatus;

public class CampoObrigatorioException extends BusinessException{
    public CampoObrigatorioException(String campo) {
        super("O campo %s é obrigatório", HttpStatus.BAD_REQUEST, new Object[]{campo});
    }
}