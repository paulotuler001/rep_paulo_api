package br.com.api.trabapi.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluguel")
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // informa q é pk
	private Integer id;
	private LocalDate dataAluguel;
	private Boolean ativo;
	@ManyToMany // relacionamento muitos pra muitos
	@JoinTable( // cria a tabela de ligacao
			name = "aluguel_apartamento", // nomeia a tabela de ligacao
			joinColumns = @JoinColumn(name = "aluguel_id"), // referencia de chave estrangeira da tabela atual(Aluguel)
			inverseJoinColumns = @JoinColumn(name = "apartamento_id") // referencia de chave estrangeira da tabela de
																	// associacao(Apartamento)
	)
	private List<Apartamento> apartamentos;

	public Aluguel() {
		super();
	}

	public Aluguel(Integer id, LocalDate dataAluguel, Boolean ativo, List<Apartamento> apartamentos,
			List<Integer> quantidadePorApartamento) {
		super();
		this.id = id;
		this.dataAluguel = dataAluguel;
		this.ativo = ativo;
		this.apartamentos = apartamentos;
//		this.quantidadePorApartamento = quantidadePorApartamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
	@Override
	public String toString() {
		return "Aluguel [ apartamentos=" + apartamentos + "]";
	}

	

}