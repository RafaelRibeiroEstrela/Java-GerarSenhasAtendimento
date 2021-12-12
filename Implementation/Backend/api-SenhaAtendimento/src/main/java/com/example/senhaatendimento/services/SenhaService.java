package com.example.senhaatendimento.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.senhaatendimento.models.Senha;
import com.example.senhaatendimento.models.enums.PrioridadeEnum;
import com.example.senhaatendimento.models.enums.SenhaStatusEnum;
import com.example.senhaatendimento.repositories.SenhaRepository;

@Service
public class SenhaService {

	@Autowired
	private SenhaRepository senhaRepository;
	
	
	public List<Senha> findAll(){
		return senhaRepository.findAll();
	}
	
	public Senha findById(Long id) {
		Senha senha = senhaRepository.findById(id).get();
		if (senha == null) {
			throw new RuntimeException("Objeto não encontrado com id = " + id);
		}
		return senha;
	}
	
	public List<Senha> findByStatusAndPrioridade(Integer status, Integer prioridade){
		return senhaRepository.findByStatusAndPrioridade(status, prioridade);
	}
	
	public Senha save(PrioridadeEnum prioridade) {
		Senha senha = new Senha(null, prioridade, SenhaStatusEnum.AGUARDANDO_ATENDIMENTO, LocalDateTime.now());
		return senhaRepository.save(senha);
	}
	
	public Senha alterarSenhaStatus(Senha senha) {
		senha.setStatus(SenhaStatusEnum.ATENDIMENTO);
		return senhaRepository.save(senha);
	}
	
}
