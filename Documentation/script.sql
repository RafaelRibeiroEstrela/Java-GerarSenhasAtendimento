CREATE TABLE tb_senha(

    id_senha NUMBER NOT NULL,
    horario_senha TIMESTAMP NOT NULL,
    prioridade NUMBER NOT NULL,
    status_senha NUMBER NOT NULL,
    CONSTRAINT tb_senha_id_senha_pk PRIMARY KEY(id_senha)

);

CREATE TABLE tb_guiche(

    id_guiche NUMBER NOT NULL,
    CONSTRAINT tb_guiche_id_guiche_pk PRIMARY KEY(id_guiche)

);


CREATE TABLE tb_atendimento(

    id_atendimento NUMBER NOT NULL,
    horario_atendimento TIMESTAMP NOT NULL,
    id_guiche NUMBER NOT NULL,
    id_senha NUMBER NOT NULL,
    CONSTRAINT tb_atendimento_id_atendimento_pk PRIMARY KEY(id_atendimento),
    CONSTRAINT tb_atendimento_id_guiche_fk FOREIGN KEY(id_guiche) REFERENCES tb_guiche(id_guiche),
    CONSTRAINT tb_atendimento_id_senha_fk FOREIGN KEY(id_senha) REFERENCES tb_senha(id_senha)

);

CREATE SEQUENCE seq_senha;
CREATE SEQUENCE seq_atendimento;