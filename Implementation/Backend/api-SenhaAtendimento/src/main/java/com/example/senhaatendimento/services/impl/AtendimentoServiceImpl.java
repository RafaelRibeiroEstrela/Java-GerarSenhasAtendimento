package com.example.senhaatendimento.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.senhaatendimento.exceptions.ApiException;
import com.example.senhaatendimento.models.Atendimento;
import com.example.senhaatendimento.models.enums.PrioridadeEnum;
import com.example.senhaatendimento.repositories.AtendimentoRepository;
import com.example.senhaatendimento.services.AtendimentoService;
import com.example.senhaatendimento.services.GuicheService;
import com.example.senhaatendimento.services.SenhaService;

@Service
public class AtendimentoServiceImpl implements AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private SenhaService senhaService;

	@Autowired
	private GuicheService guicheService;

	@Override
	public List<Atendimento> findAll() {
		return atendimentoRepository.findAll();
	}

	@Override
	public Atendimento findById(Long id) {
		return atendimentoRepository.findById(id)
				.orElseThrow(() -> new ApiException("Não foi encontrado um atendimento com id = " + id));
	}

	@Override
	public Atendimento fazerAtendimento(Long idGuiche, PrioridadeEnum prioridade) {
		return atendimentoRepository.save(new Atendimento(null, LocalDateTime.now(),
				senhaService.chamarSenha(prioridade), guicheService.findById(idGuiche)));
	}
}
