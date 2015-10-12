package br.com.salaodebeleza.util;

public class MyQuery {
	public static final String INSERT_FUNCIONARIO_TB_USUARIOS_PROC = "CALL proc_insert_employee (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, @response_status)";
	public static final String INSERT_CLIENTE_TB_USUARIOS_PROC = "CALL proc_insert_client (?, ?, ?, ?, ?, ?, @response_status)";
	public static final String SELECT_RESPONSE_STATUS = "SELECT @response_status AS resp";

}
