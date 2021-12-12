package com.example.senhaatendimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.senhaatendimento.models.Guiche;

@Repository
public interface GuicheRepository extends JpaRepository<Guiche, Long>{

}
