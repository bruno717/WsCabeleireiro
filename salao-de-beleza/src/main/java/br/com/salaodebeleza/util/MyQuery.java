package br.com.salaodebeleza.util;

public class MyQuery {

	public static final String SELECT_RESPONSE_STATUS = "SELECT @response_status AS resp";

	// Usuario
	public static final String SELECT_USUARIO_TODOS_DADOS = "SELECT * FROM tb_usuarios AS u INNER JOIN tb_dados_usuarios AS d INNER JOIN tb_enderecos AS e ON u.id_usuario = d.id_usuario AND d.id_endereco = e.id_endereco WHERE u.ds_email = ?";
	public static final String UPDATE_INATIVAR_USUARIO = "UPDATE tb_usuarios AS u SET u.cd_status=2 WHERE u.ds_email = ?";
	public static final String SELECT_USUARIOS = "SELECT * FROM tb_usuarios AS u INNER JOIN tb_dados_usuarios AS d INNER JOIN tb_enderecos AS e ON u.id_usuario = d.id_usuario AND d.id_endereco = e.id_endereco WHERE u.id_tipo_usuario = ?";

	// Funcionario
	public static final String INSERT_FUNCIONARIO_TB_USUARIOS_PROC = "CALL proc_insert_employee (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, @response_status)";
	public static final String UPDATE_FUNCIONARIO = "UPDATE tb_usuarios AS u, tb_dados_usuarios AS d, tb_enderecos AS e SET u.ds_nome=?, u.nr_telefone=?, u.ds_email=?, u.cd_senha=?, d.nr_telefone2=?, d.dt_nascimento=?, d.nr_cpf=?, d.ds_sexo=?, e.nr_cep=?, e.ds_logradouro=?, e.nr_numero=?, e.ds_bairro=?, e.ds_cidade=?, e.ds_estado=?, e.ds_pais=? WHERE u.id_usuario = ?";

	// Cliente
	public static final String INSERT_CLIENTE_TB_USUARIOS_PROC = "CALL proc_insert_client (?, ?, ?, ?, ?, ?, @response_status)";
	public static final String UPDATE_CLIENTE = "CALL proc_update_client (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, @response_status)";
	public static final String SELECT_CLIENTE_SIMPLES = "SELECT * FROM tb_usuarios WHERE ds_email = ?";


}
