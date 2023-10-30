package br.com.api.trabapi.dto;

public class ApartamentoDTO {

	private String numero;
	private String descricao;
	private String cor;
	private Double juros;
	private Integer qntdEstoque;
	private Double valorUnitario;

	public ApartamentoDTO() {
		super();
	}

	

	public ApartamentoDTO(String numero, String descricao, String cor, Double juros, Integer qntdEstoque,
			Double valorUnitario) {
		super();
		this.numero = numero;
		this.descricao = descricao;
		this.cor = cor;
		this.juros = juros;
		this.qntdEstoque = qntdEstoque;
		this.valorUnitario = valorUnitario;
	}



	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQntdEstoque() {
		return qntdEstoque;
	}

	public void setQntdEstoque(Integer qntdEstoque) {
		this.qntdEstoque = qntdEstoque;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
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
	

}
