package com.example.gerarsenhaatendimento.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GUICHE")
public class Guiche implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_GUICHE")
	private Long id;
	
	public Guiche() {
		
	}

	public Guiche(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Guiche other = (Guiche) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Guiche [id=" + id + "]";
	}
	
	

}
