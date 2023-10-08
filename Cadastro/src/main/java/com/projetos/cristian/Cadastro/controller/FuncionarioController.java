package com.projetos.cristian.Cadastro.controller;

import com.projetos.cristian.Cadastro.dto.funcionario.FuncionarioRequest;
import com.projetos.cristian.Cadastro.dto.funcionario.FuncionarioResponse;
import com.projetos.cristian.Cadastro.model.Funcionario;
import com.projetos.cristian.Cadastro.service.impl.FuncionarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/servico-funcionario")
public class FuncionarioController {


    private final FuncionarioServiceImpl funcionarioService;

    @GetMapping(value = "/lista")
    public Page<Funcionario> listarFuncionarios() {
        Pageable pageable = PageRequest.of(0, 10);

        return funcionarioService.listaFuncionarios(pageable);
    }

    @PostMapping(value = "/novo/funcionario")
    public ResponseEntity<FuncionarioResponse> salvaNovoFuncionario(@RequestBody FuncionarioRequest request, UriComponentsBuilder uriBuilder) {
        FuncionarioResponse response = funcionarioService.salvaFuncionario(request);

        URI endereco = uriBuilder.path("/funcionario/{cpf}").buildAndExpand(response.getCpf()).toUri();

        return ResponseEntity.created(endereco).body(response);
    }

    @PutMapping(value = "/atualiza/funcionario")
    public ResponseEntity<FuncionarioResponse> atualizaFuncionario(@RequestBody FuncionarioRequest request) {
        FuncionarioResponse response = funcionarioService.atualizaFuncionario(request);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/funcionario/{cpf}")
    public ResponseEntity<FuncionarioResponse> buscaFuncionarioPorCpf(@PathVariable("cpf") String cpf) {
        FuncionarioResponse response = funcionarioService.obterFuncionarioPorCpf(cpf);

        return ResponseEntity.ok().body(response);
    }

}
