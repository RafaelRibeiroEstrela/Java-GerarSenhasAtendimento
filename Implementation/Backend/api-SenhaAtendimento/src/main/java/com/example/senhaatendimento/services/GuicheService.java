package com.example.senhaatendimento.services;

import java.util.List;

import com.example.senhaatendimento.models.Guiche;

public interface GuicheService {
	
	List<Guiche> findAll();
	Guiche findById(Long id);

}
