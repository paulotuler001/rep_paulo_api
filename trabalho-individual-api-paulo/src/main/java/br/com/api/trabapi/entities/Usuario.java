package br.com.api.trabapi.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // informa q é pk
	private Integer id;
	@NotNull(message = "Nome não pode ser nulo.")
	@NotBlank(message = "Nome não pode ser vazio.")
	@Size(max = 50)
	private String nome;
	@NotNull(message = "Nome de usuario não pode ser nulo.")
	@NotBlank(message = "Nome de usuario não pode ser vazio.")
	@Size(max = 50)
	private String nomeUsuario;
	@NotNull(message = "EMAIL não pode ser nulo.")
	@NotBlank(message = "EMAIL não pode ser vazio.")
	@Email
	@Column(unique = true)
	private String email;
	@NotNull(message = "CPF não pode ser nulo.")
	@NotBlank(message = "CPF não pode ser vazio.")
	@Size(max = 11)
	private String cpf;
	private LocalDate dataNascimento;
	private Boolean ativo;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@OneToMany
	@JoinColumn(name = "usuario_id")
	private List<Aluguel> aluguels;
	@OneToMany
	@JoinColumn(name = "usuario_id")
	private List<Apartamento> apartamentos;
	@OneToMany
	@JoinColumn(name = "usuario_id")
	private List<Endereco> endereco;
	@ManyToMany
	@JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nome, String nomeUsuario, String email, String cpf, LocalDate dataNascimento,
			Boolean ativo, String password,List<Aluguel> aluguels, List<Apartamento> apartamentos, List<Endereco> endereco,
			Set<Role> roles) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.ativo = ativo;
		this.password = password;
		this.aluguels=aluguels;
		this.apartamentos = apartamentos;
		this.endereco = endereco;
		this.roles = roles;
	}

	public List<Aluguel> getAluguels() {
		return aluguels;
	}

	public void setAluguels(List<Aluguel> aluguels) {
		this.aluguels = aluguels;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
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

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ", cpf="
				+ cpf + ", dataNascimento=" + dataNascimento + ", ativo=" + ativo + ", password=" + password
				+ ", aluguels=" + aluguels + ", apartamentos=" + apartamentos + ", endereco=" + endereco + ", roles="
				+ roles + "]";
	}

	
}