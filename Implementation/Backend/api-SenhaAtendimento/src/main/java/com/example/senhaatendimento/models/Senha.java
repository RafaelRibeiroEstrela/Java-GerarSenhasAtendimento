package com.example.senhaatendimento.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.senhaatendimento.models.enums.PrioridadeEnum;
import com.example.senhaatendimento.models.enums.SenhaStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_SENHA")
public class Senha implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SENHA")
	@SequenceGenerator(name = "SEQ_SENHA", sequenceName = "SEQ_SENHA", allocationSize = 1)
	@Column(name = "ID_SENHA")
	private Long id;
	
	@Column(name = "PRIORIDADE")
	private Integer prioridade;
	
	@Column(name = "STATUS_SENHA")
	private Integer status;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:MM:ss")
	@Column(name = "HORARIRO_SENHA")
	private LocalDateTime horario;
	
	public Senha() {
		
	}

	public Senha(Long id, PrioridadeEnum prioridade, SenhaStatusEnum status, LocalDateTime horario) {
		super();
		this.id = id;
		this.prioridade = prioridade.getCod();
		this.status = status.getCod();
		this.horario = horario;
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

	public SenhaStatusEnum getStatus() {
		return SenhaStatusEnum.toEnum(status);
	}

	public void setStatus(SenhaStatusEnum status) {
		this.status = status.getCod();
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
	
	

}
