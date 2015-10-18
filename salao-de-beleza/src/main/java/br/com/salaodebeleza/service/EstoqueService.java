package br.com.salaodebeleza.service;

import br.com.salaodebeleza.dao.EstoqueDAO;
import br.com.salaodebeleza.dao.ProdutoDAO;
import br.com.salaodebeleza.model.Produto;

public class EstoqueService {

	public Boolean insereProdutoEstoqueService(Produto produto) {

		Boolean resp = false;

		resp = new ProdutoDAO().criarProduto(produto);

		if (resp) {
			Produto p = new ProdutoDAO().buscarUltimoProduto();
			resp = new EstoqueDAO().inserirProdutoEstoque(p.getId());
		}

		return resp;
	}

}
