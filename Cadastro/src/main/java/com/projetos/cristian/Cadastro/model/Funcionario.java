package com.projetos.cristian.Cadastro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ,generator = "funcionario_id_funcionario_seq")
    @SequenceGenerator(name = "funcionario_id_funcionario_seq", sequenceName = "funcionario_id_funcionario_seq", allocationSize = 1)
    @Column(name = "id_funcionario")
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String name;

    @NotEmpty
    @CPF
    @Column(name = "cpf", unique = true)
    @Size(message = "CPF invalido")
    private String cpf;

    @Column(name = "cargo")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;


}
