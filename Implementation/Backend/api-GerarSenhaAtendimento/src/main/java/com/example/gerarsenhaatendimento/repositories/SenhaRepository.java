package com.example.gerarsenhaatendimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.gerarsenhaatendimento.models.Senha;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {

	@Query(value = "SELECT seq_gerar_num_prioridade.NEXTVAL FROM dual", nativeQuery = true)
	Long gerarNumSenhaPrioridade();

	@Query(value = "SELECT seq_gerar_num_normal.NEXTVAL FROM dual", nativeQuery = true)
	Long gerarNumSenhaNormal();

	@Procedure(value = "resetar_senhas")
	void resetar();
}
