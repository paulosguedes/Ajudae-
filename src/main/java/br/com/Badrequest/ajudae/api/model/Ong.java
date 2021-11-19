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
@Table(name = "TB_AJUDAE_ONG")
@SequenceGenerator(name = "ong", sequenceName = "SQ_TB_AJUDAE_ONG", allocationSize = 1)
public class Ong {
    //nome, cpf/cnpj, telefone, endereço e email

    @Id
    @GeneratedValue(generator = "ong", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ONG")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CNPJ", nullable = false)
    private String cnpj;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "ENDERECO", nullable = false)
    private String endereco;

    @Column(name = "EMAIL", nullable = false)
    private String email;

}
