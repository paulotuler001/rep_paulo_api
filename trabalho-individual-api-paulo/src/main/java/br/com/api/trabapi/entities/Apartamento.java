package br.com.api.trabapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "apartamento")
public class Apartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer id;
	@Column(length = 9)
    @NotBlank
	private String numero;
	@Column(length = 12)
    @NotBlank
	private String cor;
	@Column(length = 12)
	@NotBlank
	private Double juros;
	@Column(length = 12)
	@NotBlank
	private String inquilino;//Inquilino inquilino
	@NotBlank
	private String proprietario; //Proprietario proprietario
	@Column(length = 12)
	@NotBlank
	private Double valor;
	@Column(length = 12)
	@NotBlank
	private Boolean mobilidado;
	@Column(length = 12)
	@NotBlank
	private Boolean ativo;
	
	@OneToOne
	@JoinColumn(name="inquilino_id")
	private Inquilino inquilino1;
	
	public Apartamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartamento(Integer id, String numero, String cor, Double juros, String inquilino,
			String proprietario, Double valor, Boolean mobilidado, Boolean ativo) {
		super();
		this.id = id;
		this.numero = numero;
		this.cor = cor;
		this.juros = juros;
		this.inquilino = inquilino;
		this.proprietario = proprietario;
		this.valor = valor;
		this.mobilidado = mobilidado;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getJuros() {
		return juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public String getInquilino() {
		return inquilino;
	}

	public void setInquilino(String inquilino) {
		this.inquilino = inquilino;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getMobilidado() {
		return mobilidado;
	}

	public void setMobilidado(Boolean mobilidado) {
		this.mobilidado = mobilidado;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Apartamento [id=" + id + ", numero=" + numero + ", cor=" + cor + ", juros=" + juros + ", inquilino="
				+ inquilino + ", proprietario=" + proprietario + ", valor=" + valor + ", mobilidado=" + mobilidado
				+ ", ativo=" + ativo + "]";
	}
	
}
