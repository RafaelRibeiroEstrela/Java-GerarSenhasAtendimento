package com.example.gerarsenhaatendimento.models.enums;

public enum PrioridadeEnum {
	
	ALTA(1, "ALTA"),
	NORMAL(2, "NORMAL");

	private int cod;
	private String desc;

	private PrioridadeEnum(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	public static PrioridadeEnum toEnum(String desc) {

		if (desc == null) {
			return null;
		}

		for (PrioridadeEnum index : PrioridadeEnum.values()) {

			if (desc.equals(index.getDesc())) {
				return index;
			}
		}

		throw new IllegalArgumentException("Enum inválido: " + desc);
	}

	public static PrioridadeEnum toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (PrioridadeEnum index : PrioridadeEnum.values()) {

			if (cod == index.getCod()) {
				return index;
			}
		}

		throw new IllegalArgumentException("Enum inválido: " + cod);
	}

}
