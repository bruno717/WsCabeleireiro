package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.salaodebeleza.dto.UsuarioDTO;

public class LoginDAO {

	public UsuarioDTO loginWeb(String email, String senha) {

		UsuarioDTO dto = null;

		try {
			Connection con = Connect.getConexao();
			String sql = "SELECT * FROM tb_usuarios WHERE ds_email='" + email
					+ "' AND cd_senha='" + senha + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				dto = new UsuarioDTO();
				dto.setId(rs.getInt("id_usuario"));
				dto.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
				dto.setNome(rs.getString("ds_nome"));
				dto.setTelefone(rs.getInt("nr_telefone"));
				dto.setEmail(rs.getString("ds_email"));
				dto.setSenha(rs.getString("cd_senha"));
			}

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("ERRO:(listarFuncao) " + e.toString());
		}
		return dto;
	}
}
