package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.salaodebeleza.dto.ClienteDTO;
import br.com.salaodebeleza.dto.UsuarioDTO;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;

public class ClienteDAO {

	// Criar cliente
	public UsuarioDTO criarCliente(ClienteDTO cliente) {

		UsuarioDTO dto = null;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_CLIENTE_TB_USUARIOS_PROC;
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);

			ps.setInt(1, StatusUsuario.CLIENTE);
			ps.setString(2, cliente.getNome());
			ps.setInt(3, cliente.getTelefone());
			ps.setString(4, cliente.getEmail());
			ps.setString(5, cliente.getSenha());
			ps.setInt(6, StatusUsuario.USUARIO_ATIVO);

			ps.execute();

			sql = MyQuery.SELECT_RESPONSE_STATUS;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				if (rs.getString("resp").equals("5")) {
					dto = new LoginDAO().loginWeb(cliente.getEmail(),
							cliente.getSenha());
				}
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

}
