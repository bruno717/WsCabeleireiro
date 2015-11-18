package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.HorarioDAO;
import br.com.salaodebeleza.model.Horario;

@RestController
@RequestMapping(value = "horario")
public class HorarioController {
	
	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarHorario(@ModelAttribute Horario horario, HttpServletResponse response) {

		Boolean resp = new HorarioDAO().criarHorario(horario);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public Boolean alterarHorario(@ModelAttribute Horario horario, HttpServletResponse response) {

		Boolean resp = new HorarioDAO().alterarHorario(horario);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Horario buscarHorario(@RequestParam Integer id) {

		Horario horario = new HorarioDAO().buscarHorario(id);

		return horario;
	}
	
	@RequestMapping(value = "lista_por_tipo_horario", method = RequestMethod.GET)
	public List<Horario> buscarTipoHorarios(Integer idTipoHorario) {

		List<Horario> lista = new HorarioDAO().buscarHorarios(idTipoHorario);

		return lista;
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<Horario> buscarTipoHorarios() {

		List<Horario> lista = new HorarioDAO().buscarHorarios();

		return lista;
	}

}
