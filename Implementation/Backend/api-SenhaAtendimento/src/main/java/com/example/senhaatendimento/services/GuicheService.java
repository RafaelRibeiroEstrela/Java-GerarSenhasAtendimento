package com.example.senhaatendimento.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.senhaatendimento.exceptions.ApiException;
import com.example.senhaatendimento.models.Guiche;
import com.example.senhaatendimento.repositories.GuicheRepository;

@Service
public class GuicheService {

	@Autowired
	private GuicheRepository guicheRepository;
	
	public List<Guiche> findAll(){
		return guicheRepository.findAll();
	}
	
	public Guiche findById(Long id) {
		return guicheRepository.findById(id).orElseThrow(() -> new ApiException("Objeto não encontrado com id = " + id));
	}
	
	public Guiche save(Guiche guiche) {
		return guicheRepository.save(guiche);
	}
	
	public Guiche update(Long id, Guiche guiche) {
		Guiche guicheBd = findById(id);
		BeanUtils.copyProperties(guiche, guicheBd, "id");
		return guicheBd;
	}
	
	public void delete(Long id) {
		findById(id);
		guicheRepository.deleteById(id);
	}
	
}
