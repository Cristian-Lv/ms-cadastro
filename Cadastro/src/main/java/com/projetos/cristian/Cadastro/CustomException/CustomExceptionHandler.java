package com.projetos.cristian.Cadastro.CustomException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FuncionarioException.class)
    public ResponseEntity<FuncionarioException> handlerFuncionario(FuncionarioException ex) {
        FuncionarioException exception = new FuncionarioException(
                LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage()
        );

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }


}
