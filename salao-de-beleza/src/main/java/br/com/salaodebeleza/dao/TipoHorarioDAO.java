package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salaodebeleza.model.TipoHorario;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class TipoHorarioDAO {
	
	public Boolean criarTipoHorario(TipoHorario tipoHorario) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_TIPO_HORARIO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, tipoHorario.getDsTipoHorario());
			ps.setInt(2, StatusUsuario.USUARIO_ATIVO);
			ps.setDate(3, new java.sql.Date(new Date().getTime()));
			ps.setInt(4, TipoUsuario.ADM);
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public Boolean alterarTipoHorario(TipoHorario tipoHorario) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_TIPO_HORARIO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, tipoHorario.getDsTipoHorario());
			ps.setInt(2, tipoHorario.getId());
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public TipoHorario buscarTipoHorario(Integer id) {

		String sql;
		TipoHorario tipoHorario = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_TIPO_HORARIO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				tipoHorario = new TipoHorario();
				tipoHorario.setId(rs.getInt("id_tipo_horario"));
				tipoHorario.setDsTipoHorario(rs.getString("ds_tipo_horario"));
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoHorario;
	}

	public List<TipoHorario> buscarTipoHorarios() {

		String sql;
		List<TipoHorario> lista = new ArrayList<TipoHorario>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_TIPOS_HORARIOS;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TipoHorario tipoHorario = new TipoHorario();

				tipoHorario.setId(rs.getInt("id_tipo_horario"));
				tipoHorario.setDsTipoHorario(rs.getString("ds_tipo_horario"));

				lista.add(tipoHorario);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

}
