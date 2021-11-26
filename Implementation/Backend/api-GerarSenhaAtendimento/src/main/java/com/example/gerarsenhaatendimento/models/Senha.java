package com.example.gerarsenhaatendimento.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.gerarsenhaatendimento.models.enums.PrioridadeEnum;
import com.example.gerarsenhaatendimento.models.enums.SenhaStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_SENHA")
public class Senha implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SENHA")
	private Long id;
	
	@Column(name = "PRIORIDADE_SENHA")
	private Integer prioridade;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:MM:ss")
	@Column(name = "HORARIO_SENHA")
	private LocalDateTime horario;
	
	@Column(name = "STATUS_SENHA")
	private Integer status;
	
	public Senha() {
		
	}

	public Senha(Long id, PrioridadeEnum prioridade, LocalDateTime horario, SenhaStatusEnum status) {
		super();
		this.id = id;
		this.prioridade = prioridade.getCod();
		this.horario = horario;
		this.status = status.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PrioridadeEnum getPrioridade() {
		return PrioridadeEnum.toEnum(prioridade);
	}

	public void setPrioridade(PrioridadeEnum prioridade) {
		this.prioridade = prioridade.getCod();
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public SenhaStatusEnum getStatus() {
		return SenhaStatusEnum.toEnum(status);
	}

	public void setStatus(SenhaStatusEnum status) {
		this.status = status.getCod();
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
