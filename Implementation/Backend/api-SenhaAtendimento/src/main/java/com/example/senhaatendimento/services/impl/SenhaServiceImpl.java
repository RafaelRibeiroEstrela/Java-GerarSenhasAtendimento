package com.example.senhaatendimento.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.senhaatendimento.exceptions.ApiException;
import com.example.senhaatendimento.models.Senha;
import com.example.senhaatendimento.models.enums.PrioridadeEnum;
import com.example.senhaatendimento.models.enums.StatusEnum;
import com.example.senhaatendimento.repositories.SenhaRepository;
import com.example.senhaatendimento.services.SenhaService;

@Service
public class SenhaServiceImpl implements SenhaService {

	@Autowired
	private SenhaRepository senhaRepository;

	@Override
	public List<Senha> findAll() {
		return senhaRepository.findAll();
	}

	@Override
	public Senha findById(Long id) {
		return senhaRepository.findById(id)
				.orElseThrow(() -> new ApiException("Não foi encontrado uma senha com id = " + id));
	}

	@Override
	public Senha gerarSenha(PrioridadeEnum prioridade) {
		return senhaRepository.save(new Senha(null, prioridade, StatusEnum.AGUARDANDO_ATENDIMENTO, LocalDateTime.now()));
	}

	@Override
	public Senha chamarSenha(PrioridadeEnum prioridade) {
		List<Senha> senhas = senhaRepository.chamarSenha(prioridade.getCod());
		Senha senha = senhas.get(0);
		senha.setStatus(StatusEnum.ATENDIMENTO);
		return senhaRepository.save(senha);
	}

}
