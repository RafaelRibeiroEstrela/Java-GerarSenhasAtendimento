package com.example.senhaatendimento.services;

import java.util.List;

import com.example.senhaatendimento.models.Senha;
import com.example.senhaatendimento.models.enums.PrioridadeEnum;

public interface SenhaService {
	
	List<Senha> findAll();
	Senha findById(Long id);
	Senha gerarSenha(PrioridadeEnum prioridade);
	Senha chamarSenha(PrioridadeEnum prioridade);

}
