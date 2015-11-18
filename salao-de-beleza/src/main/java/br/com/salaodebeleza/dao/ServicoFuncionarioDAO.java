package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salaodebeleza.model.ServicoFuncionario;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class ServicoFuncionarioDAO {

	public Boolean criarServicoFuncionario(ServicoFuncionario servicoFuncionario) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_ATIVIDADE;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, servicoFuncionario.getIdUsuario());
			ps.setInt(2, servicoFuncionario.getIdServico());
			ps.setInt(3, servicoFuncionario.getIdHorario());
			ps.setInt(4, StatusUsuario.USUARIO_ATIVO);
			ps.setDate(5, new java.sql.Date(new Date().getTime()));
			ps.setInt(6, TipoUsuario.ADM);
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public Boolean alterarServicoFuncionario(ServicoFuncionario servicoFuncionario) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_ATIVIDADE;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, servicoFuncionario.getIdUsuario());
			ps.setInt(2, servicoFuncionario.getIdServico());
			ps.setInt(3, servicoFuncionario.getIdHorario());
			ps.setInt(4, servicoFuncionario.getId());
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public ServicoFuncionario buscarServicoFuncionario(Integer id) {

		String sql;
		ServicoFuncionario servicoFuncionario = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_ATIVIDADE;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				servicoFuncionario = new ServicoFuncionario();
				servicoFuncionario.setId(rs.getInt("id_atividade"));
				servicoFuncionario.setIdUsuario(rs.getInt("id_usuario"));
				servicoFuncionario.setIdServico(rs.getInt("id_servico"));
				servicoFuncionario.setIdHorario(rs.getInt("id_horario"));
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servicoFuncionario;
	}

	public List<ServicoFuncionario> buscarServicoFuncionarios() {

		String sql;
		List<ServicoFuncionario> lista = new ArrayList<ServicoFuncionario>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_ATIVIDADES;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ServicoFuncionario servicoFuncionario = new ServicoFuncionario();

				servicoFuncionario.setId(rs.getInt("id_atividade"));
				servicoFuncionario.setIdUsuario(rs.getInt("id_usuario"));
				servicoFuncionario.setIdServico(rs.getInt("id_servico"));
				servicoFuncionario.setIdHorario(rs.getInt("id_horario"));

				lista.add(servicoFuncionario);
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