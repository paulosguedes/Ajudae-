package br.com.Badrequest.ajudae.api.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class CreateOng {

    private String nome;

    private String cnpj;

    private String telefone;

    private String endereco;

    private String email;

}
