package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salaodebeleza.model.TipoProduto;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class TipoProdutoDAO {

	public Boolean criarTipoProduto(TipoProduto tipoProduto) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_TIPO_PRODUTO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, tipoProduto.getDescricao());
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

	public Boolean alterarTipoProduto(TipoProduto tipoProduto) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_TIPO_PRODUTO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, tipoProduto.getDescricao());
			ps.setInt(2, tipoProduto.getId());
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public TipoProduto buscarTipoProduto(Integer id) {

		String sql;
		TipoProduto tipoProduto = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_TIPO_PRODUTO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				tipoProduto = new TipoProduto();
				tipoProduto.setId(rs.getInt("id_tipo_produto"));
				tipoProduto.setDescricao(rs.getString("ds_tipo_produto"));
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoProduto;
	}

	public List<TipoProduto> buscarTipoProdutos() {

		String sql;
		List<TipoProduto> lista = new ArrayList<TipoProduto>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_TIPOS_PRODUTOS;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TipoProduto tipoProduto = new TipoProduto();

				tipoProduto.setId(rs.getInt("id_tipo_produto"));
				tipoProduto.setDescricao(rs.getString("ds_tipo_produto"));

				lista.add(tipoProduto);
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
