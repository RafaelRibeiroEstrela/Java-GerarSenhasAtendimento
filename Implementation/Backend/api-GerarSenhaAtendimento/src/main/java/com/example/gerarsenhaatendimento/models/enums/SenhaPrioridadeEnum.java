package com.example.gerarsenhaatendimento.models.enums;

public enum SenhaPrioridadeEnum {
	
	PRIORIDADE(1, "PRIORIDADE"),
	NORMAL(2, "NORMAL");
	
	private int cod;
	private String desc;
	
	private SenhaPrioridadeEnum(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public static SenhaPrioridadeEnum toEnum(String desc) {
		
		if (desc == null) {
			return null;
		}
		
		for (SenhaPrioridadeEnum index : SenhaPrioridadeEnum.values()) {
			
			if (desc.equals(index.getDesc())) {
				return index;
			}
		}
		
		throw new IllegalArgumentException("Enum inválido: " + desc);
	}
	
public static SenhaPrioridadeEnum toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (SenhaPrioridadeEnum index : SenhaPrioridadeEnum.values()) {
			
			if (cod == index.getCod()) {
				return index;
			}
		}
		
		throw new IllegalArgumentException("Enum inválido: " + cod);
	}

}
