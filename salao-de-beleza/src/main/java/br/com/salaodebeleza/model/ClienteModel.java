package br.com.salaodebeleza.model;

public class ClienteModel {

	private Integer id;
	private PessoaFisicaModel pessoaFisica;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PessoaFisicaModel getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisicaModel pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

}
