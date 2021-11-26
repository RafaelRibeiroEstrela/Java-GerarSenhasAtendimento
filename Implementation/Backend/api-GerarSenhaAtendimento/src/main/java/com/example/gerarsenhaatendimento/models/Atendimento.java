package com.example.gerarsenhaatendimento.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ATENDIMENTO")
public class Atendimento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ATENDIMENTO")
	private Long id;
	
	@Column(name = "HORARIO_ATENDIMENTO")
	private LocalDateTime horario;
	
	@OneToOne
	@JoinColumn(name = "ID_SENHA")
	private Senha senha;
	
	@OneToOne
	@JoinColumn(name = "ID_GUICHE")
	private Guiche guiche;
	
	public Atendimento() {
		
	}

	public Atendimento(Long id, LocalDateTime horario, Senha senha, Guiche guiche) {
		super();
		this.id = id;
		this.horario = horario;
		this.senha = senha;
		this.guiche = guiche;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
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
		Atendimento other = (Atendimento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Atendimento [id=" + id + ", horario=" + horario + "]";
	}
	
	

}
