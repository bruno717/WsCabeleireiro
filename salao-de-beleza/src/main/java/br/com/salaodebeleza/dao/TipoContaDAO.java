package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.salaodebeleza.model.TipoConta;
import br.com.salaodebeleza.util.DataCorrente;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class TipoContaDAO {
	
	public Boolean inserirTipoConta(TipoConta tipoConta) {

		String sql;
		Boolean resp = false;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_TIPO_CONTA;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, tipoConta.getDsTipoConta());
			ps.setInt(2, StatusUsuario.USUARIO_ATIVO);
			ps.setDate(3, DataCorrente.CURRENT_DATE);
			ps.setInt(4, TipoUsuario.ADM);
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
	
	public Boolean alterarTipoConta(TipoConta tipoConta) {

		String sql;
		Boolean resp = false;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_TIPO_CONTA;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, tipoConta.getDsTipoConta());
			ps.setInt(2, tipoConta.getId());
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
	
	public List<TipoConta> buscarTipoContas() {

		String sql;
		List<TipoConta> lista = new ArrayList<TipoConta>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_TIPO_CONTAS;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TipoConta tipoConta = new TipoConta();

				tipoConta.setId(rs.getInt("id_tipo_conta"));
				tipoConta.setDsTipoConta(rs.getString("ds_tipo_conta"));

				lista.add(tipoConta);
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
