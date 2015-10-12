package br.com.salaodebeleza.util;

public class MyQuery {

	/*public static final String INSERT_TB_USUARIOS = "IF NOT EXISTS (SELECT * FROM tb_usuarios WHERE ds_email = ?) THEN "
			+ "INSERT INTO tb_usuarios "
			+ "(id_tipo_usuario, ds_nome, nr_telefone, ds_email, cd_senha, cd_status, dt_operacao) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?) END IF";*/
	
	/*public static final String INSERT_FUNCIONARIO_TB_USUARIOS_PROC = "CALL proc_insert_employee "
			+ "(2,  'lucas',  '1144445555',  'teste@teste717.com',  '*123', 1, 1,  '1155554444',  '1994-04-17',  '555555555555',  "
			+ "'Masculino',  '1111111111111', '22222222222222',  '333333333333333', 0, 07130010,  'Rua Andre Fernandes',  '108',  "
			+ "'Cocaia',  'Guarilhos',  'São Paulo',  'Brasil', @response_status)";*/
	
	public static final String INSERT_FUNCIONARIO_TB_USUARIOS_PROC = "CALL proc_insert_employee (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, @response_status)";
	public static final String SELECT_RESPONSE_STATUS = "SELECT @response_status AS resp";
	
	
	/*public static final String INSERT_TB_USUARIOS = "INSERT INTO tb_usuarios "
			+ "(id_tipo_usuario, ds_nome, nr_telefone, ds_email, cd_senha, cd_status, dt_operacao) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?)";*/

}
