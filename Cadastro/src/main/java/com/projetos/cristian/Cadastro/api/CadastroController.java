package com.projetos.cristian.Cadastro.api;

import com.projetos.cristian.Cadastro.CustomException.FuncionarioException;
import com.projetos.cristian.Cadastro.dto.FuncionarioDto;
import com.projetos.cristian.Cadastro.service.CadastroFuncionarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroFuncionarioService cadastroService;


    @GetMapping(value = "/funcionario/{id}")
    public ResponseEntity<FuncionarioDto> detalharFuncionario(@PathVariable @NotNull Long id) {
        FuncionarioDto funcionario = cadastroService.obterFuncionarioId(id);

        return ResponseEntity.ok(funcionario);
    }

    @GetMapping(value = "/listar")
    public Page<FuncionarioDto> listaFuncionarios(@PageableDefault(size = 10) Pageable pagina) {
        return cadastroService.listarFuncionarios(pagina);
    }


    @PostMapping(value = "/save/funcionario")
    public ResponseEntity<FuncionarioDto> saveFuncionario(@RequestBody @Valid FuncionarioDto dto, UriComponentsBuilder uriBuilder) {
        FuncionarioDto funcionario = cadastroService.saveAssistente(dto);

        URI endereco = uriBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(endereco).body(funcionario);
    }


    @PutMapping(value = "/atualizar/funcionario")
    public ResponseEntity<FuncionarioDto> atualizaFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) {
        FuncionarioDto funcionarioAtualizado = cadastroService.updateFuncionario(funcionarioDto);

        return ResponseEntity.ok(funcionarioAtualizado);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<String> deletaFuncionario(@PathVariable Long id) {
        cadastroService.deletarFuncionario(id);

        return ResponseEntity.ok("Funcionario Deletado");
    }

}
