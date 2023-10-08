package com.projetos.cristian.Cadastro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity(name = "funcionarios")
@Table(name = "funcionarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @CPF
    @Column(name = "cpf", length = 11, unique = true)
    private String cpf;

    @NotBlank
    @Column(name = "nome_completo")
    private String nome;

    @NotNull
    @Column(name = "cargo",length = 100)
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

}
