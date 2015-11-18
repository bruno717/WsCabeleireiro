package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.ServicoFuncionarioDAO;
import br.com.salaodebeleza.model.ServicoFuncionario;

@RestController
@RequestMapping(value = "atividade")
public class ServicoFuncionarioController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarServicoFuncionario(@ModelAttribute ServicoFuncionario servicoFuncionario, HttpServletResponse response) {

		Boolean resp = new ServicoFuncionarioDAO().criarServicoFuncionario(servicoFuncionario);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public Boolean alterarServicoFuncionario(@ModelAttribute ServicoFuncionario servicoFuncionario, HttpServletResponse response) {

		Boolean resp = new ServicoFuncionarioDAO().alterarServicoFuncionario(servicoFuncionario);
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return resp;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ServicoFuncionario buscarServicoFuncionario(@RequestParam Integer id) {

		ServicoFuncionario servicoFuncionario = new ServicoFuncionarioDAO().buscarServicoFuncionario(id);

		return servicoFuncionario;
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<ServicoFuncionario> buscarServicoFuncionarios() {

		List<ServicoFuncionario> lista = new ServicoFuncionarioDAO().buscarServicoFuncionarios();

		return lista;
	}
	
}
