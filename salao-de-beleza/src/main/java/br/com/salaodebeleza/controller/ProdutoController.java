package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.ProdutoDAO;
import br.com.salaodebeleza.model.Produto;

@RestController
@RequestMapping(value = "produto")
public class ProdutoController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarProduto(@ModelAttribute Produto produto,
			HttpServletResponse response) {

		Boolean resp = new ProdutoDAO().criarProduto(produto);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.PUT)
	public Boolean alterarProduto(@ModelAttribute Produto produto,
			HttpServletResponse response) {

		Boolean resp = new ProdutoDAO().alterarProduto(produto);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Produto buscarProduto(@RequestParam Integer id,
			HttpServletResponse response) {

		Produto produto = new ProdutoDAO().buscarProduto(id);
		response.setStatus(produto != null ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_CONFLICT);

		return produto;
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<Produto> buscarProdutos(HttpServletResponse response) {

		List<Produto> lista = new ProdutoDAO().buscarProdutos();
		response.setStatus(lista != null ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_CONFLICT);

		return lista;
	}

}
