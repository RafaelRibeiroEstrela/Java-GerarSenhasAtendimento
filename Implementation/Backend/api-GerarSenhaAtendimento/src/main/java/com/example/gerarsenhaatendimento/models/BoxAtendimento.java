package com.example.gerarsenhaatendimento.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.gerarsenhaatendimento.models.enums.PrioridadeEnum;

@Entity
@Table(name = "TB_BOX_ATENDIMENTO")
public class BoxAtendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BOX")
	private Long id;
	
	@Column(name = "PRIORIDADE_BOX")
	private String prioridade;
	
	public BoxAtendimento() {
		
	}

	public BoxAtendimento(Long id, String prioridade) {
		super();
		this.id = id;
		this.prioridade = prioridade;
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
		this.prioridade = prioridade.getDesc();
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
		BoxAtendimento other = (BoxAtendimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoxAtendimento [id=" + id + ", prioridade=" + prioridade + "]";
	}
	
	

}
