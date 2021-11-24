package com.example.gerarsenhaatendimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerarsenhaatendimento.models.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{

}
