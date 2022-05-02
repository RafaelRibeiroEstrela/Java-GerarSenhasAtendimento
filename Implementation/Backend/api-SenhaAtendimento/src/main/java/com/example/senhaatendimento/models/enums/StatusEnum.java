package com.example.senhaatendimento.models.enums;

public enum StatusEnum {

	AGUARDANDO_ATENDIMENTO(1, "Aguardando atendimento"), 
	ATENDIMENTO(2, "Atendimento");

	private int cod;
	private String desc;

	private StatusEnum(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	public static StatusEnum toEnum(String desc) {

		if (desc == null) {
			return null;
		}

		for (StatusEnum index : StatusEnum.values()) {

			if (desc.equals(index.getDesc())) {
				return index;
			}
		}

		throw new IllegalArgumentException("Enum inválido: " + desc);
	}

	public static StatusEnum toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (StatusEnum index : StatusEnum.values()) {

			if (cod == index.getCod()) {
				return index;
			}
		}

		throw new IllegalArgumentException("Enum inválido: " + cod);
	}

}
