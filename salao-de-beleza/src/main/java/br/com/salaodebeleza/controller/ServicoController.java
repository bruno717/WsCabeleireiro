package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.ServicoDAO;
import br.com.salaodebeleza.model.Servico;

@RestController
@RequestMapping(value = "servico")
public class ServicoController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarTipoConta(@ModelAttribute Servico servico,
			HttpServletResponse response) {

		Boolean resp = new ServicoDAO().criarServico(servico);

		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public Boolean alterarTipoProduto(@ModelAttribute Servico servico,
			HttpServletResponse response) {

		Boolean resp = new ServicoDAO().alterarServico(servico);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Servico buscarTipoProduto(@RequestParam Integer id) {

		Servico servico = new ServicoDAO().buscarServico(id);

		return servico;
	}

	@RequestMapping(value = "lista_por_tipo_servico", method = RequestMethod.GET)
	public List<Servico> buscarTipoProdutos(Integer idTipoServico) {

		List<Servico> lista = new ServicoDAO().buscarServicos(idTipoServico);

		return lista;
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<Servico> buscarTipoProdutos() {

		List<Servico> lista = new ServicoDAO().buscarServicos();

		return lista;
	}

}
