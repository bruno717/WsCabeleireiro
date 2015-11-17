package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.TipoContaDAO;
import br.com.salaodebeleza.model.TipoConta;

@RestController
@RequestMapping(value = "tipo_conta")
public class TipoContaController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarTipoConta(@ModelAttribute TipoConta tipoConta,
			HttpServletResponse response) {

		Boolean resp = new TipoContaDAO().inserirTipoConta(tipoConta);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public Boolean alterarTipoConta(@ModelAttribute TipoConta tipoConta,
			HttpServletResponse response) {

		Boolean resp = new TipoContaDAO().alterarTipoConta(tipoConta);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<TipoConta> buscarTipoContas() {

		List<TipoConta> lista = new TipoContaDAO().buscarTipoContas();

		return lista;
	}

}
