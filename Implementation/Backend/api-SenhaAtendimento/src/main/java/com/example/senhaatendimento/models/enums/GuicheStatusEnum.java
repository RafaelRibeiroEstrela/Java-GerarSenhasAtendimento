package com.example.senhaatendimento.models.enums;

public enum GuicheStatusEnum {

	ABERTO(1, "Aberto"), 
	FECHADO(0, "Fechado");

	private int cod;
	private String desc;

	private GuicheStatusEnum(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	public static GuicheStatusEnum toEnum(String desc) {

		if (desc == null) {
			return null;
		}

		for (GuicheStatusEnum index : GuicheStatusEnum.values()) {

			if (desc.equals(index.getDesc())) {
				return index;
			}
		}

		throw new IllegalArgumentException("Enum inválido: " + desc);
	}

	public static GuicheStatusEnum toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (GuicheStatusEnum index : GuicheStatusEnum.values()) {

			if (cod == index.getCod()) {
				return index;
			}
		}

		throw new IllegalArgumentException("Enum inválido: " + cod);
	}

}
