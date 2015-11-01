package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.salaodebeleza.model.Compra;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusCompraPedido;

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


}
