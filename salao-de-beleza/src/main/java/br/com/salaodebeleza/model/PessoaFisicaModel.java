package br.com.salaodebeleza.model;

public class PessoaFisicaModel {

	private Integer cpf;
	private PessoaModel pessoa;

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public PessoaModel getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaModel pessoa) {
		this.pessoa = pessoa;
	}

}
