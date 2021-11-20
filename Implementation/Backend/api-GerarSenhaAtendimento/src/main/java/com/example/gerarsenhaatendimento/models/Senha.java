package com.example.gerarsenhaatendimento.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.gerarsenhaatendimento.models.enums.SenhaPrioridadeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_SENHA")
public class Senha implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_SENHA")
	private Long id;
	
	@Column(name = "COD_SENHA")
	private String cod;
	
	@Column(name = "PRIORIDADE_SENHA")
	private Integer prioridade;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:MM:ss")
	@Column(name = "HORARIO_SENHA")
	private LocalDateTime horario;
	
	public Senha() {
		
	}

	public Senha(Long id, String cod, SenhaPrioridadeEnum prioridade, LocalDateTime horario) {
		super();
		this.id = id;
		this.cod = cod;
		this.prioridade = prioridade.getCod();
		this.horario = horario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public SenhaPrioridadeEnum getPrioridade() {
		return SenhaPrioridadeEnum.toEnum(prioridade);
	}

	public void setPrioridade(SenhaPrioridadeEnum prioridade) {
		this.prioridade = prioridade.getCod();
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Senha [id=" + id + ", cod=" + cod + ", prioridade=" + prioridade + ", horario=" + horario + "]";
	}
	
	

}
