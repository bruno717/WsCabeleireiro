package br.com.salaodebeleza.model;

public class Agenda {

	private Integer id;
	private Integer idHoraio;
	private Integer idUsuario;
	private Integer idAtividade;
	private String dtReserva;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdHoraio() {
		return idHoraio;
	}

	public void setIdHoraio(Integer idHoraio) {
		this.idHoraio = idHoraio;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Integer idAtividade) {
		this.idAtividade = idAtividade;
	}

	public String getDtReserva() {
		return dtReserva;
	}

	public void setDtReserva(String dtReserva) {
		this.dtReserva = dtReserva;
	}

}
