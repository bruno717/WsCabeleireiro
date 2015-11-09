package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.salaodebeleza.util.MyQuery;

public class UsuarioDAO {

	public Boolean inativarUsuario(Integer id) {
		String sql;
		Boolean resp;

		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_INATIVAR_USUARIO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ps.execute();
			
			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
			resp = false;
		}

		return resp;
	}
}
