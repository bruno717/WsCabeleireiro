package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salaodebeleza.model.Agenda;
import br.com.salaodebeleza.util.FormatDateString;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class AgendaDAO {

	public Boolean criarAgenda(Agenda agenda) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_AGENDA;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, agenda.getIdHoraio());
			ps.setInt(2, agenda.getIdUsuario());
			ps.setInt(3, agenda.getIdAtividade());
			ps.setString(4, FormatDateString.formataDataBanco(FormatDateString.RetiraCaracteres(agenda.getDtReserva())));
			ps.setInt(5, StatusUsuario.USUARIO_ATIVO);
			ps.setDate(6, new java.sql.Date(new Date().getTime()));
			ps.setInt(7, TipoUsuario.ADM);
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public Boolean alterarAgenda(Agenda agenda) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_AGENDA;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, agenda.getIdHoraio());
			ps.setInt(2, agenda.getIdUsuario());
			ps.setInt(3, agenda.getIdAtividade());
			ps.setString(4, FormatDateString.formataDataBanco(FormatDateString.RetiraCaracteres(agenda.getDtReserva())));
			ps.setInt(5, agenda.getId());
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public Agenda buscarAgenda(Integer id) {

		String sql;
		Agenda agenda = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_AGENDA;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				agenda = new Agenda();
				agenda.setId(rs.getInt("id_agenda"));
				agenda.setIdHoraio(rs.getInt("id_horario"));
				agenda.setIdUsuario(rs.getInt("id_usuario"));
				agenda.setIdAtividade(rs.getInt("id_atividade"));
				agenda.setDtReserva(rs.getString("dt_reserva"));
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agenda;
	}

	public List<Agenda> buscarAgenda() {

		String sql;
		List<Agenda> lista = new ArrayList<Agenda>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_AGENDAS;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Agenda agenda = new Agenda();
				agenda.setId(rs.getInt("id_agenda"));
				agenda.setIdHoraio(rs.getInt("id_horario"));
				agenda.setIdUsuario(rs.getInt("id_usuario"));
				agenda.setIdAtividade(rs.getInt("id_atividade"));
				agenda.setDtReserva(rs.getString("dt_reserva"));

				lista.add(agenda);
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