package com.example.gerarsenhaatendimento.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerarsenhaatendimento.models.Atendimento;
import com.example.gerarsenhaatendimento.models.Guiche;
import com.example.gerarsenhaatendimento.models.Senha;
import com.example.gerarsenhaatendimento.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;

	
	@Autowired
	private SenhaService senhaService;

	
	public List<Atendimento> buscarTodos(){
		return atendimentoRepository.findAll();
	}
	
	
	public Atendimento buscarPorId(Long id) {
		return atendimentoRepository.findById(id).get();
	}
	
	
	public Atendimento criar(Guiche guiche) {
		Senha senha = senhaService.chamar();
		Atendimento atendimento = new Atendimento(null, LocalDateTime.now(), senha, guiche);
		return atendimentoRepository.save(atendimento);
	}
	
	
}
