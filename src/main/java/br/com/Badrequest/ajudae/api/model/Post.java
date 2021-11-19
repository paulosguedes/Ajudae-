package br.com.Badrequest.ajudae.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Table(name = "TB_AJUDAE_Post")
@SequenceGenerator(name = "post", sequenceName = "SQ_TB_AJUDAE_POST", allocationSize = 1)
public class Post {

    @Id
    @GeneratedValue(generator = "post", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_POST")
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "DESCRICAO", nullable = false, length = 1000)
    private String descricao;

    @Column(name = "TIPO_USUARIO", nullable = false)
    private String tipoUsuario;

    @Column(name = "ID_USER", nullable = false)
    private Long id_user;
}
