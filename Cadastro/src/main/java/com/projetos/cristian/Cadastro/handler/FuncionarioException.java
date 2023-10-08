package com.projetos.cristian.Cadastro.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FuncionarioException extends RuntimeException {
    public FuncionarioException(String message) {
        super(message);
    }
}
