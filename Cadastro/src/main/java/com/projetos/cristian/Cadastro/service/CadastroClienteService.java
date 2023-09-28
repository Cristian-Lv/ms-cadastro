package com.projetos.cristian.Cadastro.service;

import com.projetos.cristian.Cadastro.dto.ClienteDto;
import com.projetos.cristian.Cadastro.model.Cliente;
import com.projetos.cristian.Cadastro.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ModelMapper modelMapper;


    public ClienteDto saveCliente(ClienteDto clienteDto) {
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);

        clienteRepository.save(cliente);

        return modelMapper.map(cliente, ClienteDto.class);
    }


    public ClienteDto obterClientePorCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(cliente, ClienteDto.class);
    }

    public Page<ClienteDto> listarClientes(Pageable paginas) {
        return clienteRepository.findAll(paginas).map(p -> modelMapper.map(p, ClienteDto.class));
    }


}
