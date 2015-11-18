package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.salaodebeleza.model.ContaReceber;
import br.com.salaodebeleza.util.DataCorrente;
import br.com.salaodebeleza.util.FormatDateString;
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
			ps.setDate(5, new Date(contaReceber.getDataVencimento().getTime()));
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
	
	public List<ContaReceber> buscarContasReceberDia(String data) {

		String sql;
		List<ContaReceber> lista = new ArrayList<ContaReceber>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_CONTAS_RECEBER_POR_DATA_DIA;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, FormatDateString.formataDataBanco(FormatDateString.RetiraCaracteres(data)));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ContaReceber contaReceber = new ContaReceber();
				contaReceber.setId(rs.getInt("id_conta_pagar"));
				contaReceber.setIdVenda(rs.getInt("id_venda"));
				contaReceber.setIdTipoConta(rs.getInt("id_tipo_conta"));
				contaReceber.setParcelas(rs.getInt("nr_parcelas"));
				contaReceber.setParcelaAtual(rs.getInt("nr_parcela_atual"));
				contaReceber.setDataVencimento(rs.getDate("dt_vencimento"));
				contaReceber.setDataRecebimento(rs.getDate("dt_recebimento"));
				contaReceber.setDesconto(rs.getDouble("qt_desconto"));
				contaReceber.setJuros(rs.getDouble("qt_juros"));
				contaReceber.setValorConta(rs.getDouble("vl_total_conta"));
				contaReceber.setValorRecebido(rs.getDouble("vl_total_recebido"));

				lista.add(contaReceber);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<ContaReceber> buscarContasReceberPeriodo(String dataInicio, String dataFim) {

		String sql;
		List<ContaReceber> lista = new ArrayList<ContaReceber>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_CONTAS_RECEBER_POR_DATA_PERIODO;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, FormatDateString.formataDataBanco(FormatDateString.RetiraCaracteres(dataInicio)));
			ps.setString(2, FormatDateString.formataDataBanco(FormatDateString.RetiraCaracteres(dataFim)));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ContaReceber contaReceber = new ContaReceber();
				contaReceber.setId(rs.getInt("id_conta_pagar"));
				contaReceber.setIdVenda(rs.getInt("id_venda"));
				contaReceber.setIdTipoConta(rs.getInt("id_tipo_conta"));
				contaReceber.setParcelas(rs.getInt("nr_parcelas"));
				contaReceber.setParcelaAtual(rs.getInt("nr_parcela_atual"));
				contaReceber.setDataVencimento(rs.getDate("dt_vencimento"));
				contaReceber.setDataRecebimento(rs.getDate("dt_recebimento"));
				contaReceber.setDesconto(rs.getDouble("qt_desconto"));
				contaReceber.setJuros(rs.getDouble("qt_juros"));
				contaReceber.setValorConta(rs.getDouble("vl_total_conta"));
				contaReceber.setValorRecebido(rs.getDouble("vl_total_recebido"));

				lista.add(contaReceber);
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
