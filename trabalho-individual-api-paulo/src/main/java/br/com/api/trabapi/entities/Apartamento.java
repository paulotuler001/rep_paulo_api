package br.com.api.trabapi.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
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
//	@Column(length = 12)
//	@NotBlank
	private Double juros;
	@NotBlank
	private String descricao;
//	@Column(length = 12)
//	@NotBlank
	private Double valor;
	@Column(length = 12)
//	@NotBlank
	private Boolean mobilidado;
	@Column(length = 12)
//	@NotBlank
	private Boolean ativo;
	private Double valorUnitario;
	@Column(length = 9)
    @NotBlank
	private Integer qntdEstoque;
	@ElementCollection
	@CollectionTable(name = "aluguel_apartamento", joinColumns = @JoinColumn(name = "apartamento_id"))
	@MapKeyJoinColumn(name = "aluguel_id")
	private Map<Aluguel, AluguelApartamentoEntry> itemQuantidade = new HashMap<>();
	
//	@OneToOne
//	@JoinColumn(name="inquilino_id")
////	private Inquilino inquilino1;
//	
//	@OneToOne
//	@JoinColumn(name="proprietario_id")
//	private Proprietario proprietario1;
	
	public Apartamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public Apartamento(Integer id, @NotBlank String numero, @NotBlank String cor, Double juros,
			@NotBlank String descricao, Double valor, Boolean mobilidado, Boolean ativo, Double valorUnitario,
			@NotBlank Integer qntdEstoque, Map<Aluguel, AluguelApartamentoEntry> itemQuantidade) {
		super();
		this.id = id;
		this.numero = numero;
		this.cor = cor;
		this.juros = juros;
		this.descricao = descricao;
		this.valor = valor;
		this.mobilidado = mobilidado;
		this.ativo = ativo;
		this.valorUnitario = valorUnitario;
		this.qntdEstoque = qntdEstoque;
		this.itemQuantidade = itemQuantidade;
	}




	public Integer getQntdEstoque() {
		return qntdEstoque;
	}

	public void setQntdEstoque(Integer qntdEstoque) {
		this.qntdEstoque = qntdEstoque;
	}

	public Map<Aluguel, AluguelApartamentoEntry> getItemQuantidade() {
		return itemQuantidade;
	}

	public void setItemQuantidade(Map<Aluguel, AluguelApartamentoEntry> itemQuantidade) {
		this.itemQuantidade = itemQuantidade;
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




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public Double getValorUnitario() {
		return valorUnitario;
	}




	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}




	@Override
	public String toString() {
		return "Apartamento [id=" + id + ", numero=" + numero + ", cor=" + cor + ", juros=" + juros + ", descricao="
				+ descricao + ", valor=" + valor + ", mobilidado=" + mobilidado + ", ativo=" + ativo
				+ ", valorUnitario=" + valorUnitario + ", qntdEstoque=" + qntdEstoque + ", itemQuantidade="
				+ itemQuantidade + "]";
	}

	

	
	
}
