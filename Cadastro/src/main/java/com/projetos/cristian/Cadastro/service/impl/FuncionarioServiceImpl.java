package com.projetos.cristian.Cadastro.service.impl;

import com.projetos.cristian.Cadastro.dto.funcionario.FuncionarioRequest;
import com.projetos.cristian.Cadastro.dto.funcionario.FuncionarioResponse;
import com.projetos.cristian.Cadastro.handler.FuncionarioException;
import com.projetos.cristian.Cadastro.model.Funcionario;
import com.projetos.cristian.Cadastro.repository.FuncionarioRepository;
import com.projetos.cristian.Cadastro.service.IFuncionarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FuncionarioServiceImpl implements IFuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final ModelMapper modelMapper;


    @Override
    public FuncionarioResponse salvaFuncionario(FuncionarioRequest request) throws FuncionarioException {
        Optional<Funcionario> funcionarioOpt;

        funcionarioOpt = funcionarioRepository.findByCpf(request.getCpf());

        funcionarioOpt.ifPresent(funcionario -> {
            throw new FuncionarioException("cpf ja cadastrado");
        });

        Funcionario funcionario = modelMapper.map(request, Funcionario.class);
        funcionario.setDataCadastro(LocalDate.now());

        funcionarioRepository.save(funcionario);

        return modelMapper.map(funcionario, FuncionarioResponse.class);
    }

    @Override
    public FuncionarioResponse atualizaFuncionario(FuncionarioRequest request) throws FuncionarioException{
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findByCpf(request.getCpf());

        if (funcionarioOpt.isPresent()) {
            Funcionario updateFuncionario = modelMapper.map(funcionarioOpt.get(), Funcionario.class);
            updateFuncionario.setDataCadastro(LocalDate.now());

            funcionarioRepository.save(updateFuncionario);
            return modelMapper.map(updateFuncionario, FuncionarioResponse.class);
        }

        throw new FuncionarioException("funcionario nao atualizado");
    }

    @Override
    public FuncionarioResponse obterFuncionarioPorCpf(String cpf) throws FuncionarioException {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findByCpf(cpf);

        if (funcionarioOpt.isPresent()) {
            return modelMapper.map(funcionarioOpt.get(), FuncionarioResponse.class);
        }
        throw new FuncionarioException("cpf nao encontrado");
    }

    @Override
    public Page<Funcionario> listaFuncionarios(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);
    }

    @Override
    public void deletaFuncionarioPorCpf(String cpf) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findByCpf(cpf);
        try {
            funcionarioOpt.ifPresent(funcionarioRepository::delete);
        } catch (Exception ex) {
            throw new FuncionarioException("funcionario nao deletado");
        }
    }
}