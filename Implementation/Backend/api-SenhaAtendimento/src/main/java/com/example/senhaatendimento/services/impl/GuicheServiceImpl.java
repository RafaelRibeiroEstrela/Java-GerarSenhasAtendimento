package com.example.senhaatendimento.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.senhaatendimento.exceptions.ApiException;
import com.example.senhaatendimento.models.Guiche;
import com.example.senhaatendimento.repositories.GuicheRepository;
import com.example.senhaatendimento.services.GuicheService;

@Service
public class GuicheServiceImpl implements GuicheService{
	
	@Autowired
	private GuicheRepository guicheRepository;

	@Override
	public List<Guiche> findAll() {
		return guicheRepository.findAll();
	}

	@Override
	public Guiche findById(Long id) {
		return guicheRepository.findById(id).orElseThrow(() -> new ApiException("Não foi encontrado um guiche com id = " + id));
	}
	
	

}
