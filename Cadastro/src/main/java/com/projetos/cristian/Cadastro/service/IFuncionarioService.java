package com.projetos.cristian.Cadastro.service;

import com.projetos.cristian.Cadastro.dto.funcionario.FuncionarioRequest;
import com.projetos.cristian.Cadastro.dto.funcionario.FuncionarioResponse;
import com.projetos.cristian.Cadastro.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFuncionarioService {

    FuncionarioResponse salvaFuncionario(FuncionarioRequest request);

    FuncionarioResponse atualizaFuncionario(FuncionarioRequest request);

    FuncionarioResponse obterFuncionarioPorCpf(String cpf);

    void deletaFuncionarioPorCpf(String cpf);

    Page<Funcionario> listaFuncionarios(Pageable pageable);
}
