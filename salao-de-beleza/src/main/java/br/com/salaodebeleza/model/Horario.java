package br.com.salaodebeleza.model;

public class Horario {

	private Integer id;
	private Integer idTipoHorario;
	private String dsHorario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTipoHorario() {
		return idTipoHorario;
	}

	public void setIdTipoHorario(Integer idTipoHorario) {
		this.idTipoHorario = idTipoHorario;
	}

	public String getDsHorario() {
		return dsHorario;
	}

	public void setDsHorario(String dsHorario) {
		this.dsHorario = dsHorario;
	}

}
