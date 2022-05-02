package com.example.senhaatendimento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.senhaatendimento.models.Senha;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {
	
	@Query("SELECT se FROM Senha se "
			+ "WHERE se.status = 1 "
			+ "AND se.prioridade = :prioridade "
			+ "AND SUBSTRING(se.horario, 0, 10) = SUBSTRING(CURRENT_TIMESTAMP, 0, 10)"
			+ "ORDER BY se.id ASC ")
	List<Senha> chamarSenha(Integer prioridade);

}
