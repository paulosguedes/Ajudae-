package br.com.Badrequest.ajudae.api.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class CreateUsuario {

    private String nome;

    private String cpf;

    private String telefone;

    private String endereco;

    private String email;

}
