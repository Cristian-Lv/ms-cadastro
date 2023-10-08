package com.projetos.cristian.Cadastro.repository;

import com.projetos.cristian.Cadastro.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {

    Optional<Funcionario> findByCpf(String cpf);
}
