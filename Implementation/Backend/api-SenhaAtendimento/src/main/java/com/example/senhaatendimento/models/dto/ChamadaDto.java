package com.example.senhaatendimento.models.dto;

import java.io.Serializable;

import com.example.senhaatendimento.models.Guiche;
import com.example.senhaatendimento.models.Senha;

public class ChamadaDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Senha senha;
	private Guiche guiche;
	
	public ChamadaDto() {
		
	}

	public ChamadaDto(Senha senha, Guiche guiche) {
		super();
		this.senha = senha;
		this.guiche = guiche;
	}

	public Senha getSenha() {
		return senha;
	}

	public void setSenha(Senha senha) {
		this.senha = senha;
	}

	public Guiche getGuiche() {
		return guiche;
	}

	public void setGuiche(Guiche guiche) {
		this.guiche = guiche;
	}
	
	

}
