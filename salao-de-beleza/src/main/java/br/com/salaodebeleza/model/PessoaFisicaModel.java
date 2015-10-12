package br.com.salaodebeleza.model;

public class PessoaFisicaModel {

	private Long cpf;
	private PessoaModel pessoa = new PessoaModel();

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public PessoaModel getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaModel pessoa) {
		this.pessoa = pessoa;
	}

}
