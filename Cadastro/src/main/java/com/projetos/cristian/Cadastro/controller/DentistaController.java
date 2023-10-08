package com.projetos.cristian.Cadastro.controller;

import com.projetos.cristian.Cadastro.dto.dentista.DentistaRequest;
import com.projetos.cristian.Cadastro.dto.dentista.DentistaResponse;
import com.projetos.cristian.Cadastro.model.Dentista;
import com.projetos.cristian.Cadastro.model.Funcionario;
import com.projetos.cristian.Cadastro.service.impl.DentistaServiceImpl;
import lombok.Getter;
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
@RequestMapping("/servico-dentista")
public class DentistaController {

    private final DentistaServiceImpl dentistaService;

    @PostMapping(value = "/novo/dentista")
    public ResponseEntity<?> salvarDentista(@RequestBody DentistaRequest request, UriComponentsBuilder uriBuilder) {
        DentistaResponse response = dentistaService.salvaDentista(request);

        URI endereco = uriBuilder.path("dentista/{cro}").buildAndExpand(response.getCro()).toUri();

        return ResponseEntity.created(endereco).body(response);
    }

    @GetMapping("/listar")
    public Page<Dentista> listarFuncionario() {
        Pageable pagina = PageRequest.of(0, 10);

        return dentistaService.listarDentistaClinica(pagina);
    }

    @GetMapping(value = "/dentista/{cro}")
    public ResponseEntity<?> buscaDentistaPorCro(@PathVariable("cro") String cro) {
        DentistaResponse response = dentistaService.obterDentistaPorCro(cro);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping(value = "/atualiza/dentista")
    public ResponseEntity<DentistaResponse> atualizaDentista(@RequestBody DentistaRequest request) {
        DentistaResponse response = dentistaService.atualizaDentista(request);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/deleta/{cro}")
    public ResponseEntity<?> deletaDentista(@PathVariable("cro") String cro) {
        dentistaService.deletaDentista(cro);

        return ResponseEntity.ok().build();
    }

}
