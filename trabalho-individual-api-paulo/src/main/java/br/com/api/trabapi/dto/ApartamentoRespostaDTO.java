package br.com.api.trabapi.dto;

public class ApartamentoRespostaDTO {

	private String descricao;
	private Boolean ativo;
	private String nome;
	private Integer qntdEstoque;
	private Double valorUnitario;
	public ApartamentoRespostaDTO() {
		super();
	}
	public ApartamentoRespostaDTO( String descricao, Boolean ativo, String nome,
			Integer qntdEstoque, Double valorUnitario) {
		super();
		this.descricao = descricao;
		this.ativo = ativo;
		this.nome = nome;
		this.qntdEstoque = qntdEstoque;
		this.valorUnitario = valorUnitario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
}
