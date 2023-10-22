package br.com.api.trabapi.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "inquilino")
public class Inquilino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column()
	private Integer id;
	private String nome;
	private String telefone;
	private String cpf;
	private Double contracheque;
	private Endereco end_comercial;
	private Integer num_apartamento;
	private Double preco_aluguel;
	private Boolean ativo;
	
	@OneToMany
	@JoinColumn(name="inquilino_id")
	private List<Endereco> enderecos;
	
	
	public Inquilino() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inquilino(Integer id, String nome, String telefone, String cpf, Double contracheque, Endereco end_comercial,
			Integer num_apartamento, Double preco_aluguel, Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.contracheque = contracheque;
		this.end_comercial = end_comercial;
		this.num_apartamento = num_apartamento;
		this.preco_aluguel = preco_aluguel;
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
	public Double getContracheque() {
		return contracheque;
	}
	public void setContracheque(Double contracheque) {
		this.contracheque = contracheque;
	}
	public Endereco getEnd_comercial() {
		return end_comercial;
	}
	public void setEnd_comercial(Endereco end_comercial) {
		this.end_comercial = end_comercial;
	}
	public Integer getNum_apartamento() {
		return num_apartamento;
	}
	public void setNum_apartamento(Integer num_apartamento) {
		this.num_apartamento = num_apartamento;
	}
	public Double getPreco_aluguel() {
		return preco_aluguel;
	}
	public void setPreco_aluguel(Double preco_aluguel) {
		this.preco_aluguel = preco_aluguel;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return "Inquilino [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf + ", contracheque="
				+ contracheque + ", end_comercial=" + end_comercial + ", num_apartamento=" + num_apartamento
				+ ", preco_aluguel=" + preco_aluguel + ", ativo=" + ativo + "]";
	}
	
}
