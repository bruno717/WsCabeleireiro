package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.salaodebeleza.model.ContaPagar;
import br.com.salaodebeleza.util.MyQuery;

public class ContaPagarDAO {

	public Boolean inserirPagamento(ContaPagar contaPagar) {

		String sql;
		Boolean resp = false;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_CONTA_PAGAR;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, contaPagar.getIdPedido());
			ps.setInt(2, contaPagar.getIdTipoConta());
			ps.setInt(3, contaPagar.getParcelas() == null ? 0 : contaPagar.getParcelas());
			ps.setInt(4, contaPagar.getParcelaAtual() == null ? 0 : contaPagar.getParcelaAtual());
			ps.setString(5, contaPagar.getDataVencimento().toString());
			ps.setDate(6, Date.valueOf(contaPagar.getDataPagamento().toString()));
			ps.setInt(7, contaPagar.getDesconto() == null ? 0 : contaPagar.getDesconto().intValue());
			ps.setInt(8, contaPagar.getJuros() == null ? 0 : contaPagar.getJuros().intValue());
			ps.setDouble(9, contaPagar.getValorConta() == null ? 0 : contaPagar.getValorConta());
			ps.setDouble(10, contaPagar.getValorPago() == null ? 0 : contaPagar.getValorPago());
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
