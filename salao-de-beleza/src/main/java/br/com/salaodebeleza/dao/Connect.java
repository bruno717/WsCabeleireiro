package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	public static Connection getConexao() throws Exception {
		Connection con;

		//Banco local
		final String serverName = "localhost";
		final String mydatebase = "cabeleireiro_4";
		final String username = "root";
		final String password = "";
		
		//Banco Producao
		/*final String serverName = "cabeleireiro-4.mysql.uhserver.com";
		final String mydatebase = "cabeleireiro_4";
		final String username = "hairapp_2015";
		final String password = "hairapp2015*";*/

		final String driverName = "com.mysql.jdbc.Driver";
		Class.forName(driverName);

		String url = "jdbc:mysql://" + serverName + "/" + mydatebase;
		con = DriverManager.getConnection(url, username, password);
		return con;
	}
}
