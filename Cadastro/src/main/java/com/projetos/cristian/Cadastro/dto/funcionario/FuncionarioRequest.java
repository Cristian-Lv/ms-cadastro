package com.projetos.cristian.Cadastro.dto.funcionario;

import com.projetos.cristian.Cadastro.model.Cargo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FuncionarioRequest {

    private String nome;
    private String cpf;
    private Cargo cargo;


}
