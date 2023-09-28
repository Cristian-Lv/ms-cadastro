package com.projetos.cristian.Cadastro.service;

import com.projetos.cristian.Cadastro.CustomException.FuncionarioException;
import com.projetos.cristian.Cadastro.dto.FuncionarioDto;
import com.projetos.cristian.Cadastro.model.Funcionario;
import com.projetos.cristian.Cadastro.repository.FuncionarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CadastroFuncionarioService {

    private FuncionarioRepository funcionarioRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CadastroFuncionarioService(FuncionarioRepository funcionarioRepository, ModelMapper modelMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.modelMapper = modelMapper;
    }

    public FuncionarioDto saveAssistente(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = modelMapper.map(funcionarioDto, Funcionario.class);

        funcionario.setDataCadastro(LocalDateTime.now());

        funcionarioRepository.save(funcionario);

        return modelMapper.map(funcionario, FuncionarioDto.class);
    }


    public FuncionarioDto obterFuncionarioId(Long id) throws FuncionarioException {

        if (funcionarioRepository.findById(id).isPresent()) {
            Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

            return modelMapper.map(funcionario, FuncionarioDto.class);
        }


        throw new FuncionarioException("CPF nao encontrado");
    }

    public Page<FuncionarioDto> listarFuncionarios(Pageable pagina) {
        return funcionarioRepository.findAll(pagina).map(p -> modelMapper.map(p, FuncionarioDto.class));

    }


    public FuncionarioDto updateFuncionario(FuncionarioDto funcionarioDto) throws FuncionarioException {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(funcionarioDto.getId());

        try {
            Funcionario funcionario = modelMapper.map(funcionarioDto, Funcionario.class);
            funcionario.setDataCadastro(LocalDateTime.now());

            funcionarioRepository.save(funcionario);

            return modelMapper.map(funcionario, FuncionarioDto.class);

        } catch (Exception ex) {
            throw new FuncionarioException("Funcionario nao encontrado");
        }
    }


    public void deletarFuncionario(Long id) throws FuncionarioException {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(id);

        funcionarioOpt.ifPresent(f -> {
            funcionarioRepository.delete(funcionarioOpt.get());
        });

        throw new FuncionarioException("CPF não encontrado");
    }

}
