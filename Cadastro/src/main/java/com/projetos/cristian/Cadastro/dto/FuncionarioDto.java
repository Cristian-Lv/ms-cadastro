package com.projetos.cristian.Cadastro.dto;

import com.projetos.cristian.Cadastro.model.Cargos;
import com.projetos.cristian.Cadastro.model.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FuncionarioDto {

    private Long id;
    private String name;
    private String cpf;
    private Cargos cargos;
    private LocalDateTime dadaCadastro;


//    public Funcionario converte(Funcionario funcionario) {
//        funcionario.setName(this.getName());
//        funcionario.setCpf(this.getCpf());
//        funcionario.setCargo(Cargos.FUNCIONARIO);
//        funcionario.setDataCadastro(LocalDateTime.now());
//
//
//        return funcionario;
//    }

}
