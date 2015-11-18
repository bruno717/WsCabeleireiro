package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salaodebeleza.model.Horario;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class HorarioDAO {

	public Boolean criarHorario(Horario horario) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_HORARIO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, horario.getIdTipoHorario());
			ps.setString(2, horario.getDsHorario());
			ps.setInt(3, StatusUsuario.USUARIO_ATIVO);
			ps.setDate(4, new java.sql.Date(new Date().getTime()));
			ps.setInt(5, TipoUsuario.ADM);
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public Boolean alterarHorario(Horario horario) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_HORARIO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, horario.getIdTipoHorario());
			ps.setString(2, horario.getDsHorario());
			ps.setInt(3, horario.getId());
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public Horario buscarHorario(Integer id) {

		String sql;
		Horario horario = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_HORARIO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				horario = new Horario();
				horario.setId(rs.getInt("id_horario"));
				horario.setIdTipoHorario(rs.getInt("id_tipo_horario"));
				horario.setDsHorario(rs.getString("ds_horario"));
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return horario;
	}

	public List<Horario> buscarHorarios() {

		String sql;
		List<Horario> lista = new ArrayList<Horario>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_HORARIOS;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Horario horario = new Horario();
				horario.setId(rs.getInt("id_horario"));
				horario.setIdTipoHorario(rs.getInt("id_tipo_horario"));
				horario.setDsHorario(rs.getString("ds_horario"));

				lista.add(horario);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Horario> buscarHorarios(Integer idTipoHorario) {

		String sql;
		List<Horario> lista = new ArrayList<Horario>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_HORARIOS_POR_TIPO_HORARIO;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idTipoHorario);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Horario horario = new Horario();
				horario.setId(rs.getInt("id_horario"));
				horario.setIdTipoHorario(rs.getInt("id_tipo_horario"));
				horario.setDsHorario(rs.getString("ds_horario"));

				lista.add(horario);
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
