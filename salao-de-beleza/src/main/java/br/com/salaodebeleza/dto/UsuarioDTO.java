package br.com.salaodebeleza.dto;

public class UsuarioDTO {
	
	public UsuarioDTO(){
		super();
	}
	
	public UsuarioDTO(String nome, String telefone, String email, String senha){
		super();
		this.nome = nome;
		this. telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	private Integer id;
	private Integer idTipoUsuario;
	private String nome;
	private String telefone;
	private String email;
	private String senha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
