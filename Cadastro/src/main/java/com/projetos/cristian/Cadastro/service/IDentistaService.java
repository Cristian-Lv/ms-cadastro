package com.projetos.cristian.Cadastro.service;

import com.projetos.cristian.Cadastro.dto.dentista.DentistaRequest;
import com.projetos.cristian.Cadastro.dto.dentista.DentistaResponse;
import com.projetos.cristian.Cadastro.handler.FuncionarioException;
import com.projetos.cristian.Cadastro.model.Dentista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDentistaService {

    DentistaResponse salvaDentista(DentistaRequest request) throws FuncionarioException;

    DentistaResponse atualizaDentista(DentistaRequest request) throws FuncionarioException;

    DentistaResponse obterDentistaPorCro(String cro);

    void deletaDentista(String cro);
    Page<Dentista> listarDentistaClinica(Pageable pageable);

}
