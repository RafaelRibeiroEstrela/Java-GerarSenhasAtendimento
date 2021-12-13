package com.example.senhaatendimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.senhaatendimento.models.Senha;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {
	
	@Procedure("proc_chama_senha(:prioridade)")
	Long chamarSenha(Integer prioridade);

}
