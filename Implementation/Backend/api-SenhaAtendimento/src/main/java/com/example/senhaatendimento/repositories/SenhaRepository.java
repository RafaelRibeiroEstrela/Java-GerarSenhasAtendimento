package com.example.senhaatendimento.repositories;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.senhaatendimento.models.Senha;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {
	
	//@Procedure("proc_chama_senha(:prioridade)")
	//Long chamarSenha(Integer prioridade);
	
	
	default Senha chamarSenha(Integer prioridade, EntityManager em) {
		String query = "SELECT se FROM Senha se WHERE se.status = 1 AND se.prioridade = :prioridade ORDER BY se.id ASC";
		
		TypedQuery<Senha> tq = em.createQuery(query, Senha.class);
		
		tq.setParameter("prioridade", prioridade);
		tq.setMaxResults(1);
		return tq.getSingleResult();
	}

}
