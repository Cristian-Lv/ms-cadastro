package com.projetos.cristian.Cadastro.api;

import com.projetos.cristian.Cadastro.dto.ClienteDto;
import com.projetos.cristian.Cadastro.model.Cliente;
import com.projetos.cristian.Cadastro.service.CadastroClienteService;
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
@RequestMapping("/cliente")
public class CadastroClienteController {

    @Autowired
    private CadastroClienteService clienteService;

    @GetMapping("/listar")
    public Page<ClienteDto> listarClientes(@PageableDefault(size = 10) Pageable paginas) {
        return clienteService.listarClientes(paginas);
    }


//    Arrumar a service de cliente !!


    @PostMapping("/salvar")
    public ResponseEntity<ClienteDto> saveCliente(@RequestBody ClienteDto clienteDto, UriComponentsBuilder builder) {
        ClienteDto cliente = clienteService.saveCliente(clienteDto);

        URI endereco = builder.path("/buscar/{cpf}").buildAndExpand(cliente.getCpf()).toUri();

        return ResponseEntity.created(endereco).body(cliente);
    }

    @GetMapping("/buscar/{cpf}")
    public ResponseEntity<ClienteDto> detalharCliente(@PathVariable String cpf) {
        ClienteDto cliente = clienteService.obterClientePorCpf(cpf);

        return ResponseEntity.ok(cliente);
    }


}
