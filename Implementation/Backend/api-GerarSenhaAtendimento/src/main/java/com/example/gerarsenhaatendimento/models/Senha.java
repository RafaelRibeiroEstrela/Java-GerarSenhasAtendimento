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

import com.example.gerarsenhaatendimento.models.enums.SenhaPrioridadeEnum;
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
	
	@Column(name = "COD_SENHA")
	private Long cod;
	
	@Column(name = "PRIORIDADE_SENHA")
	private String prioridade;
	
	@Column(name = "STATUS_SENHA")
	private String status;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:MM:ss")
	@Column(name = "HORARIO_SENHA")
	private LocalDateTime horario;
	
	public Senha() {
		
	}

	public Senha(Long id, Long cod, SenhaPrioridadeEnum prioridade, SenhaStatusEnum status, LocalDateTime horario) {
		super();
		this.id = id;
		this.cod = cod;
		this.prioridade = prioridade.getDesc();
		this.status = status.getDesc();
		this.horario = horario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public SenhaPrioridadeEnum getPrioridade() {
		return SenhaPrioridadeEnum.toEnum(prioridade);
	}

	public void setPrioridade(SenhaPrioridadeEnum prioridade) {
		this.prioridade = prioridade.getDesc();
	}
	
	public SenhaStatusEnum getStatus() {
		return SenhaStatusEnum.toEnum(status);
	}

	public void setStatus(SenhaStatusEnum status) {
		this.status = status.getDesc();
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

	@Override
	public String toString() {
		return "Senha [id=" + id + ", cod=" + cod + ", prioridade=" + prioridade + ", horario=" + horario + "]";
	}

	
	
	

}
