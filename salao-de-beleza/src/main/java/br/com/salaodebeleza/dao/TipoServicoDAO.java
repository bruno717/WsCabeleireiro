package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salaodebeleza.model.TipoServico;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class TipoServicoDAO {

	public Boolean criarTipoServico(TipoServico tipoServico) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_TIPO_SERVICO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, tipoServico.getDsTipoServico());
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

	public Boolean alterarTipoServico(TipoServico tipoServico) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_TIPO_SERVICO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, tipoServico.getDsTipoServico());
			ps.setInt(2, tipoServico.getId());
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public TipoServico buscarTipoServico(Integer id) {

		String sql;
		TipoServico tipoServico = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_TIPO_SERVICO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				tipoServico = new TipoServico();
				tipoServico.setId(rs.getInt("id_tipo_servico"));
				tipoServico.setDsTipoServico(rs.getString("ds_tipo_servico"));
				tipoServico.setCdStatus(rs.getInt("cd_status"));
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoServico;
	}

	public List<TipoServico> buscarTipoServicos() {

		String sql;
		List<TipoServico> lista = new ArrayList<TipoServico>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_TIPOS_SERVICOS;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TipoServico tipoServico = new TipoServico();

				tipoServico.setId(rs.getInt("id_tipo_servico"));
				tipoServico.setDsTipoServico(rs.getString("ds_tipo_servico"));
				tipoServico.setCdStatus(rs.getInt("cd_status"));
				
				lista.add(tipoServico);
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
