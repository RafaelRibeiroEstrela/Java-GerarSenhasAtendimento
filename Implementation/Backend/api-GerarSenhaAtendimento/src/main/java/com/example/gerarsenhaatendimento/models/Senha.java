package com.example.gerarsenhaatendimento.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.gerarsenhaatendimento.models.enums.SenhaPrioridadeEnum;

@Entity
@Table(name = "TB_SENHA")
public class Senha implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUM_SENHA")
	private Long id;
	
	@Column(name = "PRIORIDADE_SENHA")
	private String prioridade;
	
	@Column(name = "HORARIO_SENHA")
	private LocalDateTime horario;
	
	public Senha() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SenhaPrioridadeEnum getPrioridade() {
		return SenhaPrioridadeEnum.toEnum(prioridade);
	}

	public void setPrioridade(SenhaPrioridadeEnum prioridade) {
		this.prioridade = prioridade.getDesc();
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Senha other = (Senha) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
