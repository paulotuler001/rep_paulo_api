package br.com.api.trabapi.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

//import br.com.api.trabapi.entities.Apartamento;

@Entity
@Table(name = "proprietario")
public class Proprietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer id;
	@Column(length = 60)
    @NotBlank
	private String nome;
	@Column(length = 11)
    @NotBlank
	private String telefone;
	@Column(length = 11)
    @NotBlank
	private String cpf;
	@Column()
    @NotBlank
	private Double valor_pagamento;
//	@Column()
//    @NotBlank
//	private Apartamento posses; //criar outra entity
	@Column()
    @NotBlank
	private Boolean ativo;
	
	
//	@OneToMany
//	@JoinColumn(name="proprietario_id")
//	private List<Apartamento> apartamentos;
	
	
	
	public Proprietario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proprietario(Integer id, String nome, String telefone, String cpf, Double valor_pagamento,
			 Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.valor_pagamento = valor_pagamento;
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
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return "Proprietario [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf
				+ ", valor_pagamento=" + valor_pagamento + ", ativo=" + ativo + "]";
	}
	
}
