package com.example.gerarsenhaatendimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerarsenhaatendimento.models.Senha;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long>{

}
