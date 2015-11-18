package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.TipoHorarioDAO;
import br.com.salaodebeleza.model.TipoHorario;

@RestController
@RequestMapping(value = "tipo_horario")
public class TipoHorarioController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarTipoHorario(@ModelAttribute TipoHorario tipoHorario, HttpServletResponse response) {

		Boolean resp = new TipoHorarioDAO().criarTipoHorario(tipoHorario);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public Boolean alterarTipoHorario(@ModelAttribute TipoHorario tipoHorario, HttpServletResponse response) {

		Boolean resp = new TipoHorarioDAO().alterarTipoHorario(tipoHorario);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(method = RequestMethod.GET)
	public TipoHorario buscarTipoHorario(@RequestParam Integer id) {

		TipoHorario tipoProduto = new TipoHorarioDAO().buscarTipoHorario(id);

		return tipoProduto;
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<TipoHorario> buscarTipoHorarios() {

		List<TipoHorario> lista = new TipoHorarioDAO().buscarTipoHorarios();

		return lista;
	}

}