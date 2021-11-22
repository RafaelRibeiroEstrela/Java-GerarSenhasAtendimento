package com.example.gerarsenhaatendimento.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerarsenhaatendimento.models.Senha;
import com.example.gerarsenhaatendimento.models.enums.SenhaPrioridadeEnum;
import com.example.gerarsenhaatendimento.models.enums.SenhaStatusEnum;
import com.example.gerarsenhaatendimento.repositories.SenhaRepository;

@Service
public class SenhaService {

	@Autowired
	private SenhaRepository senhaRepository;
	
	public List<Senha> findAll(){
		return senhaRepository.findAll();
	}
	
	public List<Senha> findByCod(Long cod) {
		return senhaRepository.findByCod(cod);
	}
	
	public Senha gerarSenhaPrioridadeAlta() {
		Senha senha = new Senha();
		senha.setId(null);
		senha.setCod(senhaRepository.gerarNumPrioridadeAlta());
		senha.setPrioridade(SenhaPrioridadeEnum.ALTA);
		senha.setStatus(SenhaStatusEnum.AGUARDANDO_ATENDIMENTO);
		senha.setHorario(LocalDateTime.now());
		return senhaRepository.save(senha);
	}
	
	public Senha gerarSenhaPrioridadeNormal() {
		Senha senha = new Senha();
		senha.setId(null);
		senha.setCod(senhaRepository.gerarNumPrioridadeNormal());
		senha.setPrioridade(SenhaPrioridadeEnum.NORMAL);
		senha.setStatus(SenhaStatusEnum.AGUARDANDO_ATENDIMENTO);
		senha.setHorario(LocalDateTime.now());
		return senhaRepository.save(senha);
	}
	
	public void resetarTodasAsSenhas() {
		senhaRepository.deleteAll();
		senhaRepository.resetarSenhaPrioridadeAlta();
		senhaRepository.resetarSenhaPrioridadeNormal();
		senhaRepository.resetarSenha();
	}
	
	
	

}
