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
	private SenhaRepository senhaRepository;
	
	public Senha gerarSenha(String prioridade) {
		Senha senha = new Senha();
		
		if (prioridade.equals("NORMAL")) {
			senha.setId(senhaRepository.gerarNumSenhaPrioridadeNormal());
		} else {
			senha.setId(senhaRepository.gerarNumSenhaPrioridadeAlta());
		}
		senha.setPrioridade(SenhaPrioridadeEnum.toEnum(prioridade));
		senha.setHorario(LocalDateTime.now());
		return senhaRepository.save(senha);
	}
	
	public void resetarTodasAsSenhas() {
		senhaRepository.deleteAll();
		senhaRepository.resetarGeradorDeSenhasPrioridadeAlta();
		senhaRepository.resetarGeradorDeSenhasPrioridadeNormal();
	}
	
	
	

}
