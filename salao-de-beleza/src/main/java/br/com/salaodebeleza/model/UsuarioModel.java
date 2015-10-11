package br.com.salaodebeleza.model;

public class UsuarioModel {

	private Integer id;
	private Float salario;
	private PessoaFisicaModel pessoaFisica;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public PessoaFisicaModel getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisicaModel pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

}
