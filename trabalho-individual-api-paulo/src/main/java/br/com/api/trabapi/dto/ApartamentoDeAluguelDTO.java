package br.com.api.trabapi.dto;

public class ApartamentoDeAluguelDTO {

	private Integer id;
	private Integer quantidadePorApartamento;
	
	public ApartamentoDeAluguelDTO() {
		super();
	}


	public ApartamentoDeAluguelDTO(Integer id, Integer quantidadePorApartamento) {
		super();
		this.id = id;
		this.quantidadePorApartamento = quantidadePorApartamento;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	


	public Integer getQuantidadePorApartamento() {
		return quantidadePorApartamento;
	}
	


	public void setQuantidadePorApartamento(Integer quantidadePorApartamento) {
		this.quantidadePorApartamento = quantidadePorApartamento;
	}

	
}
