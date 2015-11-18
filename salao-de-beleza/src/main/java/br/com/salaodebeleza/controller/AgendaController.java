package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.AgendaDAO;
import br.com.salaodebeleza.model.Agenda;

@RestController
@RequestMapping(value = "agenda")
public class AgendaController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarAgenda(@ModelAttribute Agenda agenda, HttpServletResponse response) {

		Boolean resp = new AgendaDAO().criarAgenda(agenda);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public Boolean alterarAgenda(@ModelAttribute Agenda agenda, HttpServletResponse response) {

		Boolean resp = new AgendaDAO().alterarAgenda(agenda);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Agenda buscarAgenda(@RequestParam Integer id) {

		Agenda agenda = new AgendaDAO().buscarAgenda(id);

		return agenda;
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<Agenda> buscarAgendas() {

		List<Agenda> lista = new AgendaDAO().buscarAgenda();

		return lista;
	}
	
}
