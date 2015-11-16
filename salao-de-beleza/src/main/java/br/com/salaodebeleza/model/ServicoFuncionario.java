package br.com.salaodebeleza.model;

public class ServicoFuncionario {

	private Integer id;
	private Integer idUsuario;
	private Integer idServico;
	private String tempo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getIdHorario() {
		return tempo;
	}

	public void setIdHorario(String tempo) {
		this.tempo = tempo;
	}

}
