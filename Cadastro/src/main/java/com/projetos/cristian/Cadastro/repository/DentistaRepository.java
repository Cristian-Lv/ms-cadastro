package com.projetos.cristian.Cadastro.repository;

import com.projetos.cristian.Cadastro.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, String> {

    Optional<Dentista> findByCro(String cro);
}
