package br.com.salaodebeleza.util;

public class MyQuery {

	public static final String SELECT_RESPONSE_STATUS = "SELECT @response_status AS resp";

	// Usuario
	public static final String SELECT_USUARIO_TODOS_DADOS = "SELECT * FROM tb_usuarios AS u INNER JOIN tb_dados_usuarios AS d INNER JOIN tb_enderecos AS e ON u.id_usuario = d.id_usuario AND d.id_endereco = e.id_endereco WHERE u.ds_email = ?";
	public static final String UPDATE_INATIVAR_USUARIO = "UPDATE tb_usuarios AS u SET u.cd_status=2 WHERE u.ds_email = ?";
	//public static final String SELECT_USUARIOS = "SELECT * FROM tb_usuarios AS u INNER JOIN tb_dados_usuarios AS d INNER JOIN tb_enderecos AS e ON u.id_usuario = d.id_usuario AND d.id_endereco = e.id_endereco WHERE u.id_tipo_usuario = ? ORDER BY u.ds_nome";
	public static final String SELECT_USUARIOS = "SELECT * FROM tb_usuarios AS u LEFT JOIN tb_dados_usuarios AS d ON u.id_usuario = d.id_usuario LEFT JOIN tb_enderecos AS e ON d.id_endereco = e.id_endereco WHERE u.id_tipo_usuario = ? ORDER BY u.ds_nome";
	public static final String SELECT_USUARIOS_SIMPLES = "SELECT * FROM tb_usuarios WHERE id_tipo_usuario = ? ORDER BY ds_nome";

	// Funcionario
	public static final String INSERT_FUNCIONARIO_TB_USUARIOS_PROC = "CALL proc_insert_employee (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, @response_status)";
	public static final String UPDATE_FUNCIONARIO = "UPDATE tb_usuarios AS u, tb_dados_usuarios AS d, tb_enderecos AS e SET u.ds_nome=?, u.nr_telefone=?, u.ds_email=?, u.cd_senha=?, d.nr_telefone2=?, d.dt_nascimento=?, d.nr_cpf=?, d.ds_sexo=?, e.nr_cep=?, e.ds_logradouro=?, e.nr_numero=?, e.ds_bairro=?, e.ds_cidade=?, e.ds_estado=?, e.ds_pais=? WHERE u.id_usuario = ?";

	// Cliente
	public static final String INSERT_CLIENTE_TB_USUARIOS_PROC = "CALL proc_insert_client (?, ?, ?, ?, ?, ?, @response_status)";
	public static final String UPDATE_CLIENTE = "CALL proc_update_client (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, @response_status)";
	public static final String SELECT_CLIENTE_SIMPLES = "SELECT * FROM tb_usuarios WHERE ds_email = ?";
	
	// TipoProduto
	public static final String INSERT_TIPO_PRODUTO = "INSERT INTO tb_tipos_produtos (ds_tipo_produto, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?)";
	public static final String UPDATE_TIPO_PRODUTO = "UPDATE tb_tipos_produtos SET ds_tipo_produto=? WHERE id_tipo_produto = ?";
	public static final String SELECT_TIPO_PRODUTO = "SELECT * FROM tb_tipos_produtos WHERE id_tipo_produto = ?";
	public static final String SELECT_TIPOS_PRODUTOS = "SELECT * FROM tb_tipos_produtos ORDER BY ds_tipo_produto";
	
	// Produto
	public static final String INSERT_PRODUTO = "INSERT INTO tb_produtos (id_tipo_produto, ds_produto, ds_fabricante, vl_preco, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_PRODUTO = "UPDATE tb_produtos SET id_tipo_produto=?, ds_produto=?, ds_fabricante=?, vl_preco=? WHERE id_produto = ?";
	public static final String SELECT_PRODUTO = "SELECT * FROM tb_produtos WHERE id_produto = ?";
	public static final String SELECT_PRODUTOS = "SELECT * FROM tb_produtos ORDER BY ds_produto";
}
