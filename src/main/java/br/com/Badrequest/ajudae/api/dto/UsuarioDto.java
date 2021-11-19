package br.com.Badrequest.ajudae.api.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class UsuarioDto {

    private Long id;

    private String nome;

    private String cpf;

    private String telefone;

    private String endereco;

    private String email;

}
