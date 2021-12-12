package com.example.senhaatendimento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.senhaatendimento.models.Senha;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {

	@Query("SELECT se FROM Senha se WHERE se.status = :status AND se.prioridade = :prioridade ORDER BY se.id ASC")
	List<Senha> findByStatusAndPrioridade(Integer status, Integer prioridade);

}
