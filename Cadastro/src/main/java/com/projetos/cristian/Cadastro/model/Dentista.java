package com.projetos.cristian.Cadastro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "dentistas")
@Table(name = "dentistas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dentista {

    @Id
    @JoinColumn(name = "funcionario_cpf")
    private String funcionarioCpf;

    @Column(name = "cro", length = 11, nullable = false, unique = true)
    private String cro;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "especializacao")
    private Especializacao especializacao;

    @ManyToOne
    @JoinColumn(name = "funcionario_cpf_funcionario", referencedColumnName = "cpf")
    private Funcionario funcionario;

}
