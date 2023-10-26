package br.com.api.trabapi.enums;

public enum TipoRoleEnum {

	ROLE_INQUILINO("INQUILINO"),
	ROLE_PROPRIETARIO("PROPRIETARIO"),
	ROLE_FIADOR("FIADOR");

	private String tipo;

	TipoRoleEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
