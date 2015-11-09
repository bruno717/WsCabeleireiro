package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.salaodebeleza.model.Venda;
import br.com.salaodebeleza.util.DataCorrente;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusCompraPedido;
import br.com.salaodebeleza.util.TipoUsuario;

public class VendaDAO {

	public Venda inserirVenda(Venda venda) {

		String sql;
		Venda vendaCadastrada = null;
		Boolean resp = false;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_VENDA;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, venda.getIdUsuario() == null ? 0 : venda.getIdUsuario());
			ps.setInt(2, venda.getIdTipoRecebimento() == null ? 0 : venda.getIdTipoRecebimento());
			ps.setInt(3, TipoUsuario.FUNCIONARIO);
			ps.setInt(4, StatusCompraPedido.EM_ABERTO);
			ps.setDate(5, DataCorrente.CURRENT_DATE);
			ps.execute();

			ps.close();
			con.close();
			resp = true;

			vendaCadastrada = buscarUltimaVenda();

			if (vendaCadastrada.getProdutos() != null) {
				venda.setId(vendaCadastrada.getId());
				resp = inserirProdutoServicoVendido(venda);
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp = false;
		}

		return resp ? venda : null;
	}

	public Boolean atualizarStatusVenda(Integer id) {

		String sql;
		Boolean resp = false;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_STATUS_VENDA;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, StatusCompraPedido.FINALIZADO);
			ps.setInt(2, id);
			ps.execute();

			ps.close();
			con.close();

			resp = atualizarPrudutoVendido(id);
		} catch (Exception e) {
			e.printStackTrace();
			resp = false;
		}

		return resp;
	}

	private Boolean atualizarPrudutoVendido(Integer idVenda) {

		String sql;
		Boolean resp = false;
		try {

			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_STATUS_PRODUTOS_VENDIDOS;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, StatusCompraPedido.FINALIZADO);
			ps.setInt(2, idVenda);
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

	private Boolean inserirProdutoServicoVendido(Venda venda) {

		String sql;
		Boolean resp = false;
		try {
			for (int i = 0; i < venda.getProdutos().size(); i++) {
				Connection con = Connect.getConexao();
				sql = MyQuery.INSERT_PRODUTOS_VENDIDOS;
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setInt(1, venda.getId());
				ps.setInt(2, venda.getProdutos().get(i).getId() == null ? 0
						: venda.getProdutos().get(i).getId());
				ps.setInt(3, venda.getServicos().get(i).getId() == null ? 0
						: venda.getServicos().get(i).getId());
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

	private Venda buscarUltimaVenda() {

		String sql;
		List<Venda> lista = new ArrayList<Venda>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_VENDAS;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Venda venda = new Venda();
				venda.setId(rs.getInt("id_venda"));
				venda.setIdUsuario(rs.getInt("id_usuario"));
				venda.setIdTipoRecebimento(rs.getInt("id_tipo_recebimento"));
				lista.add(venda);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista.get(lista.size() - 1);
	}

	public Venda getVenda(Integer id) {

		String sql;
		Venda venda = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_VENDA;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				venda = new Venda();
				venda.setId(rs.getInt("id_venda"));
				venda.setIdUsuario(rs.getInt("id_usuario"));
				venda.setIdTipoRecebimento(rs.getInt("id_tipo_recebimento"));
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return venda;
	}

}
