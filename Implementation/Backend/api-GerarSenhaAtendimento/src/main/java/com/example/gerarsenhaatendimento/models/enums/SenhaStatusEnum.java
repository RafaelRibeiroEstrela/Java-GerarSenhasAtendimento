package com.example.gerarsenhaatendimento.models.enums;

public enum SenhaStatusEnum {
	
	AGUARDANDO_ATENDIMENTO(1, "Aguardando atendimento"),
	EM_ATENDIMENTO(2, "EM atendimento"),
	CONCLUIDO(3, "Concluido");

	private int cod;
	private String desc;

	private SenhaStatusEnum(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	public static SenhaStatusEnum toEnum(String desc) {

		if (desc == null) {
			return null;
		}

		for (SenhaStatusEnum index : SenhaStatusEnum.values()) {

			if (desc.equals(index.getDesc())) {
				return index;
			}
		}

		throw new IllegalArgumentException("Enum inválido: " + desc);
	}

	public static SenhaStatusEnum toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (SenhaStatusEnum index : SenhaStatusEnum.values()) {

			if (cod == index.getCod()) {
				return index;
			}
		}

		throw new IllegalArgumentException("Enum inválido: " + cod);
	}

}
