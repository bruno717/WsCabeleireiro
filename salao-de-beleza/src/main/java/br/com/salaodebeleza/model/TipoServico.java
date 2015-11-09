package br.com.salaodebeleza.model;

public class TipoServico {

	private Integer id;
	private String dsTipoServico;
	private Integer cdStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsTipoServico() {
		return dsTipoServico;
	}

	public void setDsTipoServico(String dsTipoServico) {
		this.dsTipoServico = dsTipoServico;
	}

	public Integer getCdStatus() {
		return cdStatus;
	}

	public void setCdStatus(Integer cdStatus) {
		this.cdStatus = cdStatus;
	}

}
