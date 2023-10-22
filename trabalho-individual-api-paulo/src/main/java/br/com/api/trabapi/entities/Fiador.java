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

@Entity
@Table(name="fiador")
public class Fiador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer id;
	@Column(length = 60)
    @NotBlank
	private String nome;
	@Column(length = 11)
    @NotBlank
	private String cpf;
	@Column(length = 11)
    @NotBlank
	private String telefone;
	@Column()
    @NotBlank
	private Endereco endereco;
	@Column()
    @NotBlank
	private Inquilino inquilino;
	@Column()
    @NotBlank
	private Boolean ativo;
	
	@OneToMany
	@JoinColumn(name="fiador_id")
	private List<Endereco> enderecos;
	
	
	public Fiador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fiador(Integer id, String nome, String cpf, String telefone, Endereco endereco, Inquilino inquilino,
			Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.inquilino = inquilino;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Inquilino getInquilino() {
		return inquilino;
	}
	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return "Fiador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", endereco="
				+ endereco + ", inquilino=" + inquilino + ", ativo=" + ativo + "]";
	}
	
}
