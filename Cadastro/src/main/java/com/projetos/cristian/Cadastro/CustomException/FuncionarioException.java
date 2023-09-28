package com.projetos.cristian.Cadastro.CustomException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FuncionarioException extends RuntimeException {


    public FuncionarioException(String message) {
        super(message);
    }

    private LocalDateTime timestamp;
    private int status;
    private String message;

}
