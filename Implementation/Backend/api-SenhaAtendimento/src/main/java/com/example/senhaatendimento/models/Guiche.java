package com.example.senhaatendimento.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.senhaatendimento.models.enums.PrioridadeEnum;

@Entity
@Table(name = "TB_GUICHE")
public class Guiche implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_GUICHE")
	private Long id;
	private Integer prioridade;
	
	public Guiche() {
		
	}

	public Guiche(Long id, Integer prioridade) {
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
		this.prioridade = prioridade.getCod();
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
		Guiche other = (Guiche) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
