
CREATE SEQUENCE seq_gerar_num_prioridade_alta;
CREATE SEQUENCE seq_gerar_num_prioridade_normal;
CREATE SEQUENCE seq_atendimento;
CREATE SEQUENCE seq_senha;



CREATE TABLE tb_senha(
    id_senha NUMBER DEFAULT seq_senha.NEXTVAL,
    cod_senha NUMBER,
    prioridade_senha VARCHAR(50),
    status_senha VARCHAR(50)
    horario_senha TIMESTAMP,
    CONSTRAINT id_senha_pk PRIMARY KEY(id_senha)
);

CREATE TABLE tb_box_atendimento(

    id_box NUMBER,
    prioridade_box VARCHAR2(50),
    CONSTRAINT id_box_pk PRIMARY KEY(id_box)
);


CREATE TABLE tb_atendimento(

    id_atendimento NUMBER DEFAULT seq_atendimento.NEXTVAL,
    horario_atendimento TIMESTAMP,
    id_senha NUMBER,
    id_box NUMBER,
    CONSTRAINT id_atendimento_pk PRIMARY KEY(id_atendimento),
    CONSTRAINT id_senha_fk FOREIGN KEY(id_senha) REFERENCES tb_senha(id_senha),
    CONSTRAINT id_box_fk FOREIGN KEY(id_box) REFERENCES tb_box_atendimento(id_box)
);