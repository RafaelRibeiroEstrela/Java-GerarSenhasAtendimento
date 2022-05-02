package com.example.senhaatendimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.senhaatendimento.models.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
	
}
