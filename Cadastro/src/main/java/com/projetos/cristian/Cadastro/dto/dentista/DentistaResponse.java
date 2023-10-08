package com.projetos.cristian.Cadastro.dto.dentista;

import com.projetos.cristian.Cadastro.model.Especializacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistaResponse {
    private String nome;
    private String cro;
    private Especializacao especializacao;

}
