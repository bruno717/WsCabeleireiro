package br.com.salaodebeleza.model;

public class Servico {

	private Integer id;
	private Integer idTipoServico;
	private String descricao;
	private Float vlPreco;
	private Integer cdStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTipoServico() {
		return idTipoServico;
	}

	public void setIdTipoServico(Integer idTipoServico) {
		this.idTipoServico = idTipoServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getVlPreco() {
		return vlPreco;
	}

	public void setVlPreco(Float vlPreco) {
		this.vlPreco = vlPreco;
	}

	public Integer getCdStatus() {
		return cdStatus;
	}

	public void setCdStatus(Integer cdStatus) {
		this.cdStatus = cdStatus;
	}

}
