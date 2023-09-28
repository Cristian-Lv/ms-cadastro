package com.projetos.cristian.Cadastro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @CPF
    @Column(name = "cpf_clientes", unique = true)
    private String cpf;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nomes_clientes")
    private String nome;

    @NotEmpty
    @Email
    @Column(name = "email_clientes")
    private String email;


}
