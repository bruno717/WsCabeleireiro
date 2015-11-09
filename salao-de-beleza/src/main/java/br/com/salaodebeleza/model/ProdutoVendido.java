package br.com.salaodebeleza.model;

public class ProdutoVendido {

	private Integer id;
	private Integer idVenda;
	private Integer idProduto;
	private Integer idServico;
	private Integer cdStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
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
