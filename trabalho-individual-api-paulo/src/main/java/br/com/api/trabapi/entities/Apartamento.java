package br.com.api.trabapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "apartamento")
public class Apartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private String cor;
	private Double juros;
	private Inquilino inquilino;
	private Proprietario proprietario;
	private Double valor;
	private Boolean mobilidado;
	private Boolean ativo;
	
	@OneToOne
	@JoinColumn(name="inquilino_id")
	private Inquilino inquilino1;
	
	public Apartamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartamento(Integer id, Integer numero, String cor, Double juros, Inquilino inquilino,
			Proprietario proprietario, Double valor, Boolean mobilidado, Boolean ativo) {
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
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

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
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
