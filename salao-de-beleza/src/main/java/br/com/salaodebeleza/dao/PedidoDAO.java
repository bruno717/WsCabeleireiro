package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.salaodebeleza.model.Compra;
import br.com.salaodebeleza.model.Pedido;
import br.com.salaodebeleza.util.DataCorrente;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusCompraPedido;
import br.com.salaodebeleza.util.TipoUsuario;

public class PedidoDAO {

	public Boolean inserirPedido(Compra compra) {

		String sql;
		Boolean resp = false;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_PEDIDO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, compra.getId());
			ps.setInt(2, StatusCompraPedido.EM_ABERTO);
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

	public Boolean atualizarStatusPedido(Integer id) {

		String sql;
		Boolean resp = false;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_STATUS_PEDIDO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, StatusCompraPedido.FINALIZADO);
			ps.setInt(2, id);
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

	public Pedido buscaPedido(Integer id) {

		String sql;
		Pedido pedido = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_PEDIDO;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				pedido = new Pedido();
				
				pedido.setId(rs.getInt("id_pedido"));
				pedido.getCompra().setId(rs.getInt("id_compra"));
				pedido.setStatus(rs.getInt("cd_status"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pedido;
	}
}
