package br.com.api.trabapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proprietario")
public class Proprietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String cpf;
	private Double valor_pagamento;
	private Apartamento posses; //criar outra entity
	private Boolean ativo;
	public Proprietario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proprietario(Integer id, String nome, String telefone, String cpf, Double valor_pagamento,
			Apartamento posses, Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.valor_pagamento = valor_pagamento;
		this.posses = posses;
		this.ativo = ativo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getValor_pagamento() {
		return valor_pagamento;
	}
	public void setValor_pagamento(Double valor_pagamento) {
		this.valor_pagamento = valor_pagamento;
	}
	public Apartamento getPosses() {
		return posses;
	}
	public void setPosses(Apartamento posses) {
		this.posses = posses;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return "Proprietario [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf
				+ ", valor_pagamento=" + valor_pagamento + ", posses=" + posses + ", ativo=" + ativo + "]";
	}
	
}
