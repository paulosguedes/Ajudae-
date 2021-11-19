package br.com.Badrequest.ajudae.api.dto;

import br.com.Badrequest.ajudae.api.model.Ong;
import br.com.Badrequest.ajudae.api.model.Usuario;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class PostRetunDto {

    private Long id;

    private String titulo;

    private String descricao;

    private Long id_user;

    private Ong ong;

    private Usuario usuario;
}
