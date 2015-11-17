package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.TipoProdutoDAO;
import br.com.salaodebeleza.model.TipoProduto;

@RestController
@RequestMapping(value = "tipo_produto")
public class TipoProdutoController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarTipoProduto(@ModelAttribute TipoProduto tipoProduto,
			HttpServletResponse response) {

		Boolean resp = new TipoProdutoDAO().criarTipoProduto(tipoProduto);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public Boolean alterarTipoProduto(@ModelAttribute TipoProduto tipoProduto,
			HttpServletResponse response) {

		Boolean resp = new TipoProdutoDAO().alterarTipoProduto(tipoProduto);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(method = RequestMethod.GET)
	public TipoProduto buscarTipoProduto(@RequestParam Integer id/*,
			HttpServletResponse response*/) {

		TipoProduto tipoProduto = new TipoProdutoDAO().buscarTipoProduto(id);
		/*response.setStatus(tipoProduto != null ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_CONFLICT);*/

		return tipoProduto;
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<TipoProduto> buscarTipoProdutos(/*HttpServletResponse response*/) {

		List<TipoProduto> lista = new TipoProdutoDAO().buscarTipoProdutos();
		/*response.setStatus(lista != null ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_CONFLICT);*/

		return lista;
	}

}
