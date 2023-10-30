package br.com.api.trabapi.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.api.trabapi.entities.Apartamento;

public class AluguelRespostaDTO {

	private LocalDate dataAluguel;
	private Boolean ativo;
	private List<Apartamento> apartamentos;

	public AluguelRespostaDTO() {
		super();
	}

	public AluguelRespostaDTO(LocalDate dataAluguel, Boolean ativo, List<Apartamento> apartamentos) {
		super();
		this.dataAluguel = dataAluguel;
		this.ativo = ativo;
		this.apartamentos = apartamentos;
	}

	public LocalDate getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(LocalDate dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}

}
