CREATE SEQUENCE seq_gerar_num_prioridade;
CREATE SEQUENCE seq_gerar_num_normal;

CREATE TABLE tb_senha(
    id_senha NUMBER,
    cod_senha VARCHAR2(20),
    prioridade_senha NUMBER,
    horario_senha TIMESTAMP,
    CONSTRAINT id_senha_pk PRIMARY KEY(id_senha),
    CONSTRAINT cod_senha_un UNIQUE(cod_senha)
);