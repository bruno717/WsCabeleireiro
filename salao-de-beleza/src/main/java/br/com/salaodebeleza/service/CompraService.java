package br.com.salaodebeleza.service;

import br.com.salaodebeleza.dao.CompraDAO;
import br.com.salaodebeleza.dao.ContaPagarDAO;
import br.com.salaodebeleza.dao.EstoqueDAO;
import br.com.salaodebeleza.dao.PedidoDAO;
import br.com.salaodebeleza.model.Compra;
import br.com.salaodebeleza.model.ContaPagar;
import br.com.salaodebeleza.model.Pedido;
import br.com.salaodebeleza.model.ProdutoCompradoCustomizado;

public class CompraService {

	private CompraDAO compraDAO;
	private PedidoDAO pedidoDAO;
	private ContaPagarDAO contaPagarDAO;
	private EstoqueDAO estoqueDAO;

	public Boolean compraAberta(Compra compra) {

		Boolean resp;
		compraDAO = new CompraDAO();
		pedidoDAO = new PedidoDAO();

		resp = compraDAO.inserirCompra(compra);

		if (resp) {
			resp = pedidoDAO.inserirPedido(compra);
		}

		return resp;
	}

	public Boolean pagarCompra(ContaPagar contaPagar) {

		Boolean resp;
		Pedido pedido = null;
		ProdutoCompradoCustomizado pcc = null;
		
		contaPagarDAO = new ContaPagarDAO();
		compraDAO = new CompraDAO();
		pedidoDAO = new PedidoDAO();
		estoqueDAO = new EstoqueDAO();

		resp = contaPagarDAO.inserirPagamento(contaPagar);

		if (resp) {
			resp = pedidoDAO.atualizarStatusPedido(contaPagar.getIdPedido());
			if (resp) {
				pedido = pedidoDAO.buscaPedido(contaPagar.getIdPedido());
				resp = compraDAO.atualizarStatusCompra(pedido.getCompra().getId());
				if (resp) {
					pcc = compraDAO.buscaQdtProdutosComprados(pedido.getCompra().getId());
					resp = estoqueDAO.somarProdutoEstoquePorIdProduto(pcc.getQtdProduto(), pcc.getIdProduto());
				}
			}
		}
		return resp;
	}
}
