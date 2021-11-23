package com.example.gerarsenhaatendimento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.gerarsenhaatendimento.models.Senha;

public interface SenhaRepository extends JpaRepository<Senha, Long>{
	
	final String SEQ_PRIORIDADE_ALTA = "seq_gerar_num_prioridade_alta";
	final String SEQ_PRIORIDADE_NORMAL = "seq_gerar_num_prioridade_normal";
	
	@Query(value = "SELECT " + SEQ_PRIORIDADE_ALTA + ".NEXTVAL FROM dual", nativeQuery = true)
	Long gerarNumPrioridadeAlta();
	
	@Query(value = "SELECT " + SEQ_PRIORIDADE_NORMAL + ".NEXTVAL FROM dual", nativeQuery = true)
	Long gerarNumPrioridadeNormal();
	
	@Procedure(procedureName = "RESETAR_TUDO")
	void resetarTudo();
	
	List<Senha> findByCod(Long cod);

}
