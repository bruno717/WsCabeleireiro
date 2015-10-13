package br.com.salaodebeleza.model;

public class PessoaFisica {

	private Long cpf;
	private Pessoa pessoa = new Pessoa();

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
