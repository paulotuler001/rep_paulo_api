package br.com.api.trabapi.dto;

import java.util.List;

public class AluguelDeApartamentoDTO {

	private List<ApartamentoDeAluguelDTO> apartamentos;

	public AluguelDeApartamentoDTO() {
		super();
	}

	public AluguelDeApartamentoDTO(List<ApartamentoDeAluguelDTO> apartamentos) {
		super();
		this.apartamentos = apartamentos;
	}

	public List<ApartamentoDeAluguelDTO> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<ApartamentoDeAluguelDTO> apartamentos) {
		this.apartamentos = apartamentos;
	}

}