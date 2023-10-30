package br.com.api.trabapi.dto;

public class ApartamentoRespostaDTO {

	private String descricao;
	private Integer qntdEstoque;
	private Double valorUnitario;
	private String cor;
	private String numero;
	public ApartamentoRespostaDTO() {
		super();
	}
	
	public ApartamentoRespostaDTO(String descricao, Integer qntdEstoque, Double valorUnitario, String cor,
			String numero) {
		super();
		this.descricao = descricao;
		this.qntdEstoque = qntdEstoque;
		this.valorUnitario = valorUnitario;
		this.cor = cor;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
