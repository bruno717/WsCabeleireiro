package br.com.salaodebeleza.service;

import br.com.salaodebeleza.dao.ContaReceberDAO;
import br.com.salaodebeleza.dao.EstoqueDAO;
import br.com.salaodebeleza.dao.VendaDAO;
import br.com.salaodebeleza.model.ContaReceber;
import br.com.salaodebeleza.model.Venda;

public class VendaService {

	private VendaDAO vendaDAO;
	private ContaReceberDAO contaReceberDAO;
	private EstoqueDAO estoqueDAO;

	public Boolean registrarVenda(Venda venda, ContaReceber contaReceber) {

		Boolean resp = false;
		vendaDAO = new VendaDAO();
		contaReceberDAO = new ContaReceberDAO();
		estoqueDAO = new EstoqueDAO();

		venda = vendaDAO.inserirVenda(venda);

		if (venda.getId() != null) {
			contaReceber.setIdVenda(venda.getId());
			resp = contaReceberDAO.inserirRecebimento(contaReceber);
			if (resp) {
				resp = vendaDAO.atualizarStatusVenda(contaReceber.getIdVenda());
				if (resp && venda.getProdutos() != null) {
					for (int i = 0; i < venda.getProdutos().size(); i++) {
						resp = estoqueDAO.subtrairProdutoEstoquePorIdProduto(1, venda.getProdutos().get(i).getId());
					}
				}
			}
		}

		return resp;
	}
}
