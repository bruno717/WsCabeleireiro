package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salaodebeleza.model.Servico;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class ServicoDAO {

	public Boolean criarServico(Servico servico) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_SERVICO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, servico.getIdTipoServico());
			ps.setString(2, servico.getDescricao());
			ps.setFloat(3, servico.getVlPreco());
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

	public Boolean alterarServico(Servico servico) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_SERVICO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, servico.getId());
			ps.setString(2, servico.getDescricao());
			ps.setFloat(3, servico.getVlPreco());
			ps.setInt(4, servico.getId());
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public Servico buscarServico(Integer id) {

		String sql;
		Servico servico = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_SERVICO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				servico = new Servico();
				servico.setId(rs.getInt("id_servico"));
				servico.setDescricao(rs.getString("ds_servico"));
				servico.setIdTipoServico(rs.getInt("id_tipo_servico"));
				servico.setVlPreco(rs.getFloat("vl_preco"));
				servico.setCdStatus(rs.getInt("cd_status"));
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servico;
	}

	public List<Servico> buscarServicos() {

		String sql;
		List<Servico> lista = new ArrayList<Servico>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_SERVICOS;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Servico servico = new Servico();

				servico.setId(rs.getInt("id_servico"));
				servico.setDescricao(rs.getString("ds_servico"));
				servico.setIdTipoServico(rs.getInt("id_tipo_servico"));
				servico.setVlPreco(rs.getFloat("vl_preco"));
				servico.setCdStatus(rs.getInt("cd_status"));

				lista.add(servico);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Servico> buscarServicos(Integer idTipoServico) {

		String sql;
		List<Servico> lista = new ArrayList<Servico>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_SERVICOS_POR_TIPO_SERVICO;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idTipoServico);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Servico servico = new Servico();

				servico.setId(rs.getInt("id_servico"));
				servico.setDescricao(rs.getString("ds_servico"));
				servico.setIdTipoServico(rs.getInt("id_tipo_servico"));
				servico.setVlPreco(rs.getFloat("vl_preco"));
				servico.setCdStatus(rs.getInt("cd_status"));

				lista.add(servico);
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
