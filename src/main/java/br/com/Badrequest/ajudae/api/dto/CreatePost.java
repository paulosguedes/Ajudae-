package br.com.Badrequest.ajudae.api.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class CreatePost {

    private String titulo;

    private String descricao;

    private String tipoUsuario;

    private Long id_user;
}
