
CREATE SEQUENCE seq_gerar_num_prioridade_alta;
CREATE SEQUENCE seq_gerar_num_prioridada_normal;
CREATE SEQUENCE seq_senha;



CREATE TABLE tb_senha(
    id_senha NUMBER DEFAULT seq_senha.NEXTVAL,
    cod_senha NUMBER,
    prioridade_senha VARCHAR(50),
    horario_senha TIMESTAMP,
    CONSTRAINT id_senha_pk PRIMARY KEY(id_senha)
);
