package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.EstoqueDAO;
import br.com.salaodebeleza.model.Estoque;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {
	
	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public Boolean alterarProdutoEstoque(@ModelAttribute Estoque estoque, HttpServletResponse response) {

		Boolean resp = new EstoqueDAO().alterarProdutoEstoque(estoque);
		if (!resp) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}

		return resp;
	}
	
	@RequestMapping(value = "excluir", method = RequestMethod.POST)
	public Boolean excluirProdutoEstoque(@RequestParam Integer id, HttpServletResponse response) {

		Boolean resp = new EstoqueDAO().excluirProdutoEstoque(id);
		if (!resp) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}

		return resp;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Estoque getProdutoEstoque(@RequestParam Integer id) {

		return new EstoqueDAO().getProdutoEstoque(id);
	}
	
	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<Estoque> getListaProdutoEstoque() {

		return new EstoqueDAO().getListaProdutoEstoque();
	}

}
