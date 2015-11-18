package br.com.salaodebeleza.service;

import java.util.List;

import br.com.salaodebeleza.dao.ContaPagarDAO;
import br.com.salaodebeleza.dao.ContaReceberDAO;
import br.com.salaodebeleza.dto.MovimentacaoDiaDTO;
import br.com.salaodebeleza.model.ContaPagar;
import br.com.salaodebeleza.model.ContaReceber;

public class FinanceiroService {

	public MovimentacaoDiaDTO movimentacaoDia(String data) {

		MovimentacaoDiaDTO diaDTO = new MovimentacaoDiaDTO();

		List<ContaReceber> contasReceber = new ContaReceberDAO()
				.buscarContasReceberDia(data);
		for (ContaReceber contaReceber : contasReceber) {
			diaDTO.setRecebimentoTotal(contaReceber.getValorRecebido());
		}

		List<ContaPagar> contasPagar = new ContaPagarDAO().buscarContasPagarDia(data);

		for (ContaPagar contaPagar : contasPagar) {
			diaDTO.setGastoTotal(contaPagar.getValorPago());
		}

		diaDTO.setValorLiquidoTotal(diaDTO.getRecebimentoTotal() - diaDTO.getGastoTotal());

		return diaDTO;
	}

	public MovimentacaoDiaDTO movimentacaoPeriodo(String dataInicio,
			String dataFim) {

		MovimentacaoDiaDTO diaDTO = new MovimentacaoDiaDTO();

		List<ContaReceber> contasReceber = new ContaReceberDAO() .buscarContasReceberPeriodo(dataInicio, dataFim);
		for (ContaReceber contaReceber : contasReceber) {
			diaDTO.setRecebimentoTotal(contaReceber.getValorRecebido());
		}

		List<ContaPagar> contasPagar = new ContaPagarDAO() .buscarContasPagarPeriodo(dataInicio, dataFim);
		for (ContaPagar contaPagar : contasPagar) {
			diaDTO.setGastoTotal(contaPagar.getValorPago());
		}

		diaDTO.setValorLiquidoTotal(diaDTO.getRecebimentoTotal() - diaDTO.getGastoTotal());

		return diaDTO;
	}

}
