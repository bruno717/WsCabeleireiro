package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.TipoServicoDAO;
import br.com.salaodebeleza.model.TipoServico;

@RestController
@RequestMapping(value = "tipo_servico")
public class TipoServicoController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarTipoConta(@ModelAttribute TipoServico tipoServico,
			HttpServletResponse response) {

		Boolean resp = new TipoServicoDAO().criarTipoServico(tipoServico);

		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public Boolean alterarTipoProduto(@ModelAttribute TipoServico tipoServico,
			HttpServletResponse response) {

		Boolean resp = new TipoServicoDAO().alterarTipoServico(tipoServico);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(method = RequestMethod.GET)
	public TipoServico buscarTipoProduto(@RequestParam Integer id) {

		TipoServico tipoServico = new TipoServicoDAO().buscarTipoServico(id);

		return tipoServico;
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<TipoServico> buscarTipoProdutos() {

		List<TipoServico> lista = new TipoServicoDAO().buscarTipoServicos();

		return lista;
	}

}
