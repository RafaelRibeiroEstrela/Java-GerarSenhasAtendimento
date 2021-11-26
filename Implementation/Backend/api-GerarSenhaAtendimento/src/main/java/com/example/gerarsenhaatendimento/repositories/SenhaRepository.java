package com.example.gerarsenhaatendimento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gerarsenhaatendimento.models.Senha;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long>{
	
	@Query(value = "SELECT se FROM Senha se WHERE se.status = :status AND se.prioridade = :prioridade")
	List<Senha> buscarPorStatusEPrioridade(Integer status, Integer prioridade);
	
	@Query(value = "SELECT se FROM Senha se WHERE se.status = 1 ORDER BY se.id ASC")
	List<Senha> chamarSenha();

}
