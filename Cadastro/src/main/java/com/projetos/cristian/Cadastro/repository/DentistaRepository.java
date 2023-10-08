package com.projetos.cristian.Cadastro.repository;

import com.projetos.cristian.Cadastro.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, String> {
}
