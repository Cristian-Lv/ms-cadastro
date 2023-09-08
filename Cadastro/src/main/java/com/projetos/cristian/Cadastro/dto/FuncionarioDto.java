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
