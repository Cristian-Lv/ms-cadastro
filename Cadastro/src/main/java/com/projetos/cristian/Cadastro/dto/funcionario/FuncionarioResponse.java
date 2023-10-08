package com.projetos.cristian.Cadastro.dto.funcionario;

import com.projetos.cristian.Cadastro.model.Cargo;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FuncionarioResponse {

    private String nome;
    private String cpf;
    private Cargo cargo;
    private LocalDate dataCadastro;
}
