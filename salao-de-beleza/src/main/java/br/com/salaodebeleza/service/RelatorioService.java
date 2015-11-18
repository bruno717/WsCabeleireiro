package br.com.salaodebeleza.service;

import br.com.salaodebeleza.dao.ClienteDAO;
import br.com.salaodebeleza.dao.ProdutoDAO;
import br.com.salaodebeleza.dto.RelatorioDTO;
import br.com.salaodebeleza.model.Produto;

public class RelatorioService {

	public RelatorioDTO relatorioPeriodo() {

		RelatorioDTO relatorioDTO = new RelatorioDTO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		relatorioDTO.setQtdClientes(new ClienteDAO().buscarClientes().size());
		Produto produto = produtoDAO.buscarProdutosMaisVendido();
		relatorioDTO.setProdutoMaisVendidoNome(produto.getDescricao());
		relatorioDTO.setProdutoMaisVendidoQtd(produtoDAO.buscarProdutosMaisVendidosQtd(produto.getId()));
		
		/*for (ContaReceber contaReceber : contasReceber) {
			diaDTO.setRecebimentoTotal(contaReceber.getValorRecebido());
		}

		List<ContaPagar> contasPagar = new ContaPagarDAO().buscarContasPagarDia(data);

		for (ContaPagar contaPagar : contasPagar) {
			diaDTO.setGastoTotal(contaPagar.getValorPago());
		}

		diaDTO.setValorLiquidoTotal(diaDTO.getRecebimentoTotal() - diaDTO.getGastoTotal());*/

		return relatorioDTO;
	}
	
}
