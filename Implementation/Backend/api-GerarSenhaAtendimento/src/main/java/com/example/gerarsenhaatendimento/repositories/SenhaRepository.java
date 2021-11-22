package com.example.gerarsenhaatendimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.gerarsenhaatendimento.models.Senha;

public interface SenhaRepository extends JpaRepository<Senha, Long>{
	
	@Query(value = "SELECT seq_gerar_num_prioridade_normal.NEXTVAL FROM dual", nativeQuery = true)
	Long gerarNumSenhaPrioridadeNormal();

	@Query(value = "SELECT seq_gerar_num_prioridade_alta.NEXTVAL FROM dual", nativeQuery = true)
	Long gerarNumSenhaPrioridadeAlta();
	
	@Procedure(value = "reset_seq('seq_gerar_num_prioridade_alta')")
	void resetarGeradorDeSenhasPrioridadeAlta();
	
	@Procedure(value = "reset_seq('seq_gerar_num_prioridade_normal')")
	void resetarGeradorDeSenhasPrioridadeNormal();

}
