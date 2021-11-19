CREATE TABLE TB_AJUDAE_USUARIO (
    ID_USUARIO INT PRIMARY KEY auto_increment,
    NOME varchar(50) not null,
    CPF varchar(15) not null,
    TELEFONE varchar(15) not null,
    ENDERECO varchar(100) not null,
    EMAIL varchar(50) not null
);