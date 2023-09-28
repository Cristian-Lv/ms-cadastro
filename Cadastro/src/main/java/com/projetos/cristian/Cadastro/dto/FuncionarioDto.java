package com.projetos.cristian.Cadastro.dto;

import com.projetos.cristian.Cadastro.model.Cargo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FuncionarioDto {

    private Long id;
    private String name;
    private String cpf;
    private Cargo cargo;
    private LocalDateTime dataCadastro;


}
