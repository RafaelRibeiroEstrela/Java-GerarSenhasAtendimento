package com.example.gerarsenhaatendimento.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerarsenhaatendimento.models.Senha;
import com.example.gerarsenhaatendimento.models.enums.PrioridadeEnum;
import com.example.gerarsenhaatendimento.models.enums.SenhaStatusEnum;
import com.example.gerarsenhaatendimento.repositories.SenhaRepository;

@Service
public class SenhaService {
	
	@Autowired
	private SenhaRepository senhaRepository;
	
	
	public List<Senha> buscarTodos(){
		return senhaRepository.findAll();
	}
	
	
	public Senha buscarPorId(Long id) {
		return senhaRepository.findById(id).get();
	}
	
	
	public List<Senha> buscarPorStatusEPrioridade(SenhaStatusEnum status, PrioridadeEnum prioridade){
		return senhaRepository.buscarPorStatusEPrioridade(status.getCod(), prioridade.getCod());
	}
	
	
	public Senha criar(Integer prioridade) {
		Senha senha = new Senha(null, PrioridadeEnum.toEnum(prioridade), LocalDateTime.now(), SenhaStatusEnum.AGUARDANDO_ATENDIMENTO);
		return senhaRepository.save(senha);
	}
	
	
	public Senha chamar() {
		List<Senha> senhas = senhaRepository.chamarSenha();
		if (senhas.size() == 0) {
			throw new RuntimeException("Nao há senhas disponiveis");
		}
		Senha senha = senhas.get(0);
		senha.setStatus(SenhaStatusEnum.EM_ATENDIMENTO);
		return senhaRepository.save(senha);
	}
	

}
