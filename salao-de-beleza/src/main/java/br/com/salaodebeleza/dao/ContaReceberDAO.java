package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.salaodebeleza.model.ContaReceber;
import br.com.salaodebeleza.util.DataCorrente;
import br.com.salaodebeleza.util.MyQuery;

public class ContaReceberDAO {

	public Boolean inserirRecebimento(ContaReceber contaReceber) {

		String sql;
		Boolean resp = false;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_CONTA_RECEBER;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, contaReceber.getIdVenda());
			ps.setInt(2, contaReceber.getIdTipoConta());
			ps.setInt(3, contaReceber.getParcelas() == null ? 0 : contaReceber.getParcelas());
			ps.setInt(4, contaReceber.getParcelaAtual() == null ? 0 : contaReceber.getParcelaAtual());
			ps.setString(5, contaReceber.getDataVencimento().toString());
			ps.setDate(6, DataCorrente.CURRENT_DATE);
			ps.setInt(7, contaReceber.getDesconto() == null ? 0 : contaReceber.getDesconto().intValue());
			ps.setInt(8, contaReceber.getJuros() == null ? 0 : contaReceber.getJuros().intValue());
			ps.setDouble(9, contaReceber.getValorConta() == null ? 0 : contaReceber.getValorConta());
			ps.setDouble(10, contaReceber.getValorRecebido() == null ? 0 : contaReceber.getValorRecebido());
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
