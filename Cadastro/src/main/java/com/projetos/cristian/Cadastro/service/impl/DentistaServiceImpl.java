package com.projetos.cristian.Cadastro.service.impl;

import com.projetos.cristian.Cadastro.dto.dentista.DentistaRequest;
import com.projetos.cristian.Cadastro.dto.dentista.DentistaResponse;
import com.projetos.cristian.Cadastro.handler.FuncionarioException;
import com.projetos.cristian.Cadastro.model.Cargo;
import com.projetos.cristian.Cadastro.model.Dentista;
import com.projetos.cristian.Cadastro.model.Funcionario;
import com.projetos.cristian.Cadastro.repository.DentistaRepository;
import com.projetos.cristian.Cadastro.repository.FuncionarioRepository;
import com.projetos.cristian.Cadastro.service.IDentistaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DentistaServiceImpl implements IDentistaService {

    private final DentistaRepository dentistaRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ModelMapper modelMapper;


    @Override
    public DentistaResponse salvaDentista(DentistaRequest request) throws FuncionarioException {
        String funcionarioCpf = request.getCpf();

        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findByCpf(request.getCpf());

        if (funcionarioOpt.isPresent()) {
            Funcionario funcionario = funcionarioOpt.get();

            if (funcionario.getCargo() == Cargo.DENTISTA) {
                Dentista novoDentista = modelMapper.map(request, Dentista.class);
                novoDentista.setFuncionarioCpf(funcionario.getCpf());
//                novoDentista.setFuncionario(funcionario);

                dentistaRepository.save(novoDentista);

                return modelMapper.map(novoDentista, DentistaResponse.class);
            }
            throw new FuncionarioException("Funcionario nao é dentista");
        }
        throw new FuncionarioException("Funcionario nao encontrado");
    }

    @Override
    public DentistaResponse atualizaDentista(DentistaRequest request) throws FuncionarioException {
        String cro = request.getCro();

        Optional<Dentista> dentistaOpt = dentistaRepository.findByCro(cro);
        if (dentistaOpt.isPresent()) {
            Dentista dentistaAtualizado = modelMapper.map(dentistaOpt.get(), Dentista.class);
            dentistaRepository.save(dentistaAtualizado);

            return modelMapper.map(dentistaAtualizado, DentistaResponse.class);
        }
        throw new FuncionarioException("CRO nao encontrado");
    }

    @Override
    public DentistaResponse obterDentistaPorCro(String cro) throws FuncionarioException {
        Optional<Dentista> dentistaOpt = dentistaRepository.findByCro(cro);

        if (dentistaOpt.isPresent()) {
            Dentista dentista = dentistaOpt.get();

            return modelMapper.map(dentista, DentistaResponse.class);
        }
        throw new FuncionarioException("Dentista nao encontrado");

    }

    @Override
    public void deletaDentista(String cro) {
        Optional<Dentista> dentistaOpt = dentistaRepository.findByCro(cro);
        dentistaOpt.ifPresent(dentista -> {
            dentistaRepository.delete(dentistaOpt.get());
        });
    }

    @Override
    public Page<Dentista> listarDentistaClinica(Pageable pagina) {
        return dentistaRepository.findAll(pagina);
    }
}
