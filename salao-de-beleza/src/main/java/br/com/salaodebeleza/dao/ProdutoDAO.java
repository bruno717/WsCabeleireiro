package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salaodebeleza.model.Produto;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class ProdutoDAO {

	public Boolean criarProduto(Produto produto) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_PRODUTO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, produto.getTipoProduto());
			ps.setString(2, produto.getDescricao());
			ps.setString(3, produto.getFabricante());
			ps.setString(4, produto.getPreco());
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

	public Boolean alterarProduto(Produto produto) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_PRODUTO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, produto.getTipoProduto());
			ps.setString(2, produto.getDescricao());
			ps.setString(3, produto.getFabricante());
			ps.setString(4, produto.getPreco());
			ps.setInt(5, produto.getId());
			ps.execute();

			ps.close();
			con.close();
			resp = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	public Produto buscarProduto(Integer id) {

		String sql;
		Produto produto = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_PRODUTO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id_produto"));
				produto.setTipoProduto(rs.getInt("id_tipo_produto"));
				produto.setDescricao(rs.getString("ds_produto"));
				produto.setFabricante(rs.getString("ds_fabricante"));
				produto.setPreco(rs.getString("vl_preco"));
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produto;
	}

	public List<Produto> buscarProdutos() {

		String sql;
		List<Produto> lista = new ArrayList<Produto>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_PRODUTOS;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id_produto"));
				produto.setTipoProduto(rs.getInt("id_tipo_produto"));
				produto.setDescricao(rs.getString("ds_produto"));
				produto.setFabricante(rs.getString("ds_fabricante"));
				produto.setPreco(rs.getString("vl_preco"));

				lista.add(produto);
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
