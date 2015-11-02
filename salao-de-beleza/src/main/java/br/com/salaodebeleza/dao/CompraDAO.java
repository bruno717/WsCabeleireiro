package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.salaodebeleza.model.Compra;
import br.com.salaodebeleza.model.ProdutoCompradoCustomizado;
import br.com.salaodebeleza.util.DataCorrente;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusCompraPedido;
import br.com.salaodebeleza.util.TipoUsuario;

public class CompraDAO {

	public Boolean inserirCompra(Compra compra) {

		String sql;
		Compra compraCadastrada = null;
		Boolean resp = false;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_COMPRA;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, compra.getIdFuncionario() == null ? 0 : compra.getIdFuncionario());
			ps.setInt(2, compra.getTipoPagamento() == null ? 0 : compra.getTipoPagamento());
			ps.setInt(3, TipoUsuario.FUNCIONARIO);
			ps.setInt(4, StatusCompraPedido.EM_ABERTO);
			ps.setDate(5, DataCorrente.CURRENT_DATE);
			ps.execute();

			ps.close();
			con.close();
			resp = true;

		    compraCadastrada = buscarUltimaCompra();

			if (compraCadastrada != null) {
				compra.setId(compraCadastrada.getId());
				resp = inserirPrudutoComprado(compra);
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp = false;
		}

		return resp;
	}

	public Boolean atualizarStatusCompra(Integer id) {

		String sql;
		Boolean resp = false;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_STATUS_COMPRA;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, StatusCompraPedido.FINALIZADO);
			ps.setInt(2, id);
			ps.execute();

			ps.close();
			con.close();

			resp = atualizarPrudutoComprado(id);
		} catch (Exception e) {
			e.printStackTrace();
			resp = false;
		}

		return resp;
	}
	
	public ProdutoCompradoCustomizado buscaQdtProdutosComprados(Integer idCompra) {

		String sql;
		Integer qtd = 0;
		ProdutoCompradoCustomizado pcc = new ProdutoCompradoCustomizado();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_QUANTIDADE_PRODUTOS_COMPRADOS;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idCompra);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				qtd++;
				pcc.setId(rs.getInt("id_produto_comprado"));
				pcc.setIdCompra(rs.getInt("id_compra"));
				pcc.setIdProduto(rs.getInt("id_produto"));
				pcc.setIdServico(rs.getInt("id_servico"));
				pcc.setCdStatus(rs.getInt("cd_status"));
				pcc.setQtdProduto(qtd);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pcc;
	}

	private Boolean inserirPrudutoComprado(Compra compra) {

		String sql;
		Boolean resp = false;
		try {
			for (int i = 0; i < compra.getProdutos().size(); i++) {
				Connection con = Connect.getConexao();
				sql = MyQuery.INSERT_PRODUTOS_COMPRADOS;
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setInt(1, compra.getId());
				ps.setInt(2, compra.getProdutos().get(i).getId());
				ps.setInt(3, 1);
				ps.setInt(4, StatusCompraPedido.EM_ABERTO);
				ps.setDate(5, DataCorrente.CURRENT_DATE);
				ps.setInt(6, TipoUsuario.ADM);
				ps.execute();

				ps.close();
				con.close();

			}
			resp = true;

		} catch (Exception e) {
			e.printStackTrace();
			resp = false;
		}

		return resp;
	}

	private Boolean atualizarPrudutoComprado(Integer idCompra) {

		String sql;
		Boolean resp = false;
		try {

			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_STATUS_PRODUTOS_COMPRADOS;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, StatusCompraPedido.FINALIZADO);
			ps.setInt(2, idCompra);
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

	private Compra buscarUltimaCompra() {

		String sql;
		List<Compra> lista = new ArrayList<Compra>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_COMPRAS;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Compra compra = new Compra();
				compra.setId(rs.getInt("id_compra"));
				compra.setIdFuncionario(rs.getInt("id_usuario"));
				compra.setTipoPagamento(rs.getInt("id_tipo_pagamento"));
				lista.add(compra);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista.get(lista.size() - 1);
	}

}