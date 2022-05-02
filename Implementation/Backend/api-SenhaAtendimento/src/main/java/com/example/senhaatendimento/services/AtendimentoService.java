package com.example.senhaatendimento.services;

import java.util.List;

import com.example.senhaatendimento.models.Atendimento;
import com.example.senhaatendimento.models.enums.PrioridadeEnum;

public interface AtendimentoService {
	
	List<Atendimento> findAll();
	Atendimento findById(Long id);
	Atendimento fazerAtendimento(Long idGuiche, PrioridadeEnum prioridade);

}
