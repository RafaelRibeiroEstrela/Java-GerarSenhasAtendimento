package com.example.gerarsenhaatendimento.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerarsenhaatendimento.models.Senha;
import com.example.gerarsenhaatendimento.models.enums.SenhaPrioridadeEnum;
import com.example.gerarsenhaatendimento.repositories.SenhaRepository;

@Service
public class SenhaService {

	@Autowired
	private SenhaRepository repository;
	
	
	public Senha gerarSenhaNormal() {
		
		Long id = repository.gerarNumSenhaNormal();
		Senha senha = new Senha();
		senha.setId(id);
		senha.setCod(String.valueOf(senha.getId()) + "-" + SenhaPrioridadeEnum.NORMAL.getDesc());
		senha.setHorario(LocalDateTime.now());
		senha.setPrioridade(SenhaPrioridadeEnum.NORMAL);
		return repository.save(senha);
	}
	
	public Senha gerarSenhaPrioridade() {
		Long id = repository.gerarNumSenhaPrioridade();
		Senha senha = new Senha();
		senha.setId(id);
		senha.setCod(String.valueOf(senha.getId()) + "-" + SenhaPrioridadeEnum.PRIORIDADE.getDesc());
		senha.setHorario(LocalDateTime.now());
		senha.setPrioridade(SenhaPrioridadeEnum.PRIORIDADE);
		return repository.save(senha);
	}
	
	public void resetar() {
		repository.resetar();
	}

}
