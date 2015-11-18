package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.salaodebeleza.model.ContaPagar;
import br.com.salaodebeleza.util.DataCorrente;
import br.com.salaodebeleza.util.FormatDateString;
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
			ps.setDate(6, DataCorrente.CURRENT_DATE);
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
	
	public List<ContaPagar> buscarContasPagarDia(String data) {

		String sql;
		List<ContaPagar> lista = new ArrayList<ContaPagar>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_CONTAS_PAGAR_POR_DATA_DIA;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, FormatDateString.formataDataBanco(FormatDateString.RetiraCaracteres(data)));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ContaPagar contaPagar = new ContaPagar();
				contaPagar.setId(rs.getInt("id_conta_pagar"));
				contaPagar.setIdPedido(rs.getInt("id_pedido"));
				contaPagar.setIdTipoConta(rs.getInt("id_tipo_conta"));
				contaPagar.setParcelas(rs.getInt("nr_parcelas"));
				contaPagar.setParcelaAtual(rs.getInt("nr_parcela_atual"));
				contaPagar.setDesconto(rs.getDouble("qt_desconto"));
				contaPagar.setJuros(rs.getDouble("qt_juros"));
				contaPagar.setValorConta(rs.getDouble("vl_total_conta"));
				contaPagar.setValorPago(rs.getDouble("vl_total_pago"));

				lista.add(contaPagar);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<ContaPagar> buscarContasPagarPeriodo(String dataInicio, String dataFim) {

		String sql;
		List<ContaPagar> lista = new ArrayList<ContaPagar>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_CONTAS_PAGAR_POR_DATA_PERIODO;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, FormatDateString.formataDataBanco(FormatDateString.RetiraCaracteres(dataInicio)));
			ps.setString(2, FormatDateString.formataDataBanco(FormatDateString.RetiraCaracteres(dataFim)));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ContaPagar contaPagar = new ContaPagar();
				contaPagar.setId(rs.getInt("id_conta_pagar"));
				contaPagar.setIdPedido(rs.getInt("id_pedido"));
				contaPagar.setIdTipoConta(rs.getInt("id_tipo_conta"));
				contaPagar.setParcelas(rs.getInt("nr_parcelas"));
				contaPagar.setParcelaAtual(rs.getInt("nr_parcela_atual"));
				contaPagar.setDesconto(rs.getDouble("qt_desconto"));
				contaPagar.setJuros(rs.getDouble("qt_juros"));
				contaPagar.setValorConta(rs.getDouble("vl_total_conta"));
				contaPagar.setValorPago(rs.getDouble("vl_total_pago"));

				lista.add(contaPagar);
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
