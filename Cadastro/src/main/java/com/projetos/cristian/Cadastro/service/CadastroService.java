package com.projetos.cristian.Cadastro.service;

import com.projetos.cristian.Cadastro.dto.FuncionarioDto;
import com.projetos.cristian.Cadastro.model.Cargo;
import com.projetos.cristian.Cadastro.model.Funcionario;
import com.projetos.cristian.Cadastro.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CadastroService {

    private FuncionarioRepository funcionarioRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CadastroService(FuncionarioRepository funcionarioRepository, ModelMapper modelMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.modelMapper = modelMapper;
    }

    public FuncionarioDto saveFuncionario(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = modelMapper.map(funcionarioDto, Funcionario.class);
        funcionario.setCargo(Cargo.FUNCIONARIO);
        funcionario.setDataCadastro(LocalDateTime.now());

        funcionarioRepository.save(funcionario);

        return modelMapper.map(funcionario, FuncionarioDto.class);
    }


    public FuncionarioDto obterFuncionarioId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(funcionario, FuncionarioDto.class);
    }

    public Page<FuncionarioDto> listarFuncionarios(Pageable pagina) {
        return funcionarioRepository.findAll(pagina).map(p -> modelMapper.map(p, FuncionarioDto.class));

    }

}
