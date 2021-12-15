package com.example.senhaatendimento.models.dto;

import java.io.Serializable;

import com.example.senhaatendimento.models.Guiche;
import com.example.senhaatendimento.models.enums.PrioridadeEnum;

public class AtendimentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Guiche guiche;
	
	private PrioridadeEnum prioridade;

	public Guiche getGuiche() {
		return guiche;
	}

	public void setGuiche(Guiche guiche) {
		this.guiche = guiche;
	}

	public PrioridadeEnum getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeEnum prioridade) {
		this.prioridade = prioridade;
	}
	
	

}
