package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.salaodebeleza.model.Estoque;
import br.com.salaodebeleza.util.MyQuery;

public class EstoqueDAO {

	public Boolean inserirProdutoEstoque(Integer id) {

		String sql;
		Boolean resp;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_PRODUTO_ESTOQUE;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ps.setInt(2, 0);
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

	public Boolean alterarProdutoEstoque(Estoque estoque) {

		String sql;
		Boolean resp;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_PRODUTO_ESTOQUE;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, estoque.getQuantidade());
			ps.setInt(2, estoque.getId());
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
	
	public Boolean somarProdutoEstoquePorIdProduto(Integer qtd, Integer idProduto) {

		String sql;
		Boolean resp;
		List<Estoque> listaEstoque = new ArrayList<Estoque>();

		listaEstoque = getListaProdutoEstoque();
		
		for (int i = 0; i < listaEstoque.size(); i++) {
			if(listaEstoque.get(i).getIdProduto() == idProduto){
				qtd = qtd + listaEstoque.get(i).getQuantidade();
				break;
			}
		}
		
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_PRODUTO_ESTOQUE_ID_PRODUTO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, qtd);
			ps.setInt(2, idProduto);
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
	
	public Boolean subtrairProdutoEstoquePorIdProduto(Integer qtd, Integer idProduto) {

		String sql;
		Boolean resp;
		List<Estoque> listaEstoque = new ArrayList<Estoque>();

		listaEstoque = getListaProdutoEstoque();
		
		for (int i = 0; i < listaEstoque.size(); i++) {
			if(listaEstoque.get(i).getIdProduto() == idProduto){
				qtd = listaEstoque.get(i).getQuantidade() - qtd;
				break;
			}
		}
		
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_PRODUTO_ESTOQUE_ID_PRODUTO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, qtd);
			ps.setInt(2, idProduto);
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

	public Boolean excluirProdutoEstoque(Integer id) {

		String sql;
		Boolean resp;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.DELETE_PRODUTO_ESTOQUE;
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

	public Estoque getProdutoEstoque(Integer id) {

		String sql;
		Estoque estoque = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_PRODUTO_ESTOQUE;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				estoque = new Estoque();

				estoque.setId(rs.getInt("id_estoque"));
				estoque.setIdProduto(rs.getInt("id_produto"));
				estoque.setQuantidade(rs.getInt("qt_produto"));

			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return estoque;
	}
	
	public List<Estoque> getListaProdutoEstoque() {

		String sql;
		List<Estoque> list = new ArrayList<Estoque>();
		Estoque estoque = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_PRODUTOS_ESTOQUE;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				estoque = new Estoque();

				estoque.setId(rs.getInt("id_estoque"));
				estoque.setIdProduto(rs.getInt("id_produto"));
				estoque.setQuantidade(rs.getInt("qt_produto"));
				list.add(estoque);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
