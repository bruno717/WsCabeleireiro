package br.com.salaodebeleza.model;

public class ProdutoCompradoCustomizado {

	private Integer id;
	private Integer idCompra;
	private Integer idProduto;
	private Integer idServico;
	private Integer cdStatus;
	private Integer qtdProduto;

	public Integer getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Integer qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Integer getCdStatus() {
		return cdStatus;
	}

	public void setCdStatus(Integer cdStatus) {
		this.cdStatus = cdStatus;
	}

}
