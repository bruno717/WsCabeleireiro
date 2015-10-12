package br.com.salaodebeleza.model;

import br.com.salaodebeleza.dto.FuncionarioDTO;

public class FuncionarioModel {

	public FuncionarioModel() {
		super();
	}

	public FuncionarioModel(String nome, Integer telefone, String email,
			String senha, Integer telefone2, String nascimento, Long cpf,
			String sexo, Integer cep, String logradouro, String numero,
			String bairro, String cidade, String estado, String pais) {

		super();
		this.pessoaFisica.getPessoa().setNome(nome);
		this.pessoaFisica.getPessoa().setTelefone(telefone);
		this.pessoaFisica.getPessoa().setEmail(email);
		this.pessoaFisica.getPessoa().setSenha(senha);
		this.pessoaFisica.getPessoa().setTelefone2(telefone2);
		this.pessoaFisica.getPessoa().setDtNascimento(nascimento);
		this.pessoaFisica.setCpf(cpf);
		this.pessoaFisica.getPessoa().setSexo(sexo);
		this.pessoaFisica.getPessoa().setCep(cep);
		this.pessoaFisica.getPessoa().setLogradouro(logradouro);
		this.pessoaFisica.getPessoa().setNumero(numero);
		this.pessoaFisica.getPessoa().setBairro(bairro);
		this.pessoaFisica.getPessoa().setCidade(cidade);
		this.pessoaFisica.getPessoa().setEstado(estado);
		this.pessoaFisica.getPessoa().setPais(pais);

	}

	private Integer id;
	private PessoaFisicaModel pessoaFisica = new PessoaFisicaModel();

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

	public FuncionarioModel toFuncionario(FuncionarioDTO dto) {

		FuncionarioModel funcionario = new FuncionarioModel();
		funcionario.pessoaFisica.getPessoa().setNome(dto.getNome());
		funcionario.pessoaFisica.getPessoa().setTelefone(dto.getTelefone());
		funcionario.pessoaFisica.getPessoa().setEmail(dto.getEmail());
		funcionario.pessoaFisica.getPessoa().setSenha(dto.getSenha());
		funcionario.pessoaFisica.getPessoa().setTelefone2(dto.getTelefone2());
		funcionario.pessoaFisica.getPessoa().setDtNascimento(
				dto.getNascimento());
		funcionario.pessoaFisica.setCpf(dto.getCpf());
		funcionario.pessoaFisica.getPessoa().setSexo(dto.getSexo());
		funcionario.pessoaFisica.getPessoa().setCep(dto.getCep());
		funcionario.pessoaFisica.getPessoa().setLogradouro(dto.getLogradouro());
		funcionario.pessoaFisica.getPessoa().setNumero(dto.getNumero());
		funcionario.pessoaFisica.getPessoa().setBairro(dto.getBairro());
		funcionario.pessoaFisica.getPessoa().setCidade(dto.getCidade());
		funcionario.pessoaFisica.getPessoa().setEstado(dto.getEstado());
		funcionario.pessoaFisica.getPessoa().setPais(dto.getPais());

		return funcionario;

	}

}
