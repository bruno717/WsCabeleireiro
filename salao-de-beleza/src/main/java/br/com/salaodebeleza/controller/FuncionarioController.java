package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.FuncionarioDAO;
import br.com.salaodebeleza.dto.FuncionarioDTO;

@RestController
@RequestMapping(value = "funcionario")
public class FuncionarioController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarFuncionario(@ModelAttribute FuncionarioDTO dto, HttpServletResponse response) {

		Boolean resp = new FuncionarioDAO().criarFuncionario(dto);
		if (!resp) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}

		return resp;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public FuncionarioDTO alterarFuncionario(
			@ModelAttribute FuncionarioDTO dto, HttpServletResponse response) {

		FuncionarioDTO funcionario = new FuncionarioDAO().alterarFuncionario(dto);

		response.setStatus(funcionario == null ? HttpServletResponse.SC_CONFLICT: HttpServletResponse.SC_OK);

		return funcionario;
	}

	@RequestMapping(method = RequestMethod.GET)
	public FuncionarioDTO getFuncionario(@RequestParam String email) {
		
		FuncionarioDTO funcionario = new FuncionarioDAO().buscarFuncionario(email);

		return funcionario;
	}
	
	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<FuncionarioDTO> getListaFuncionarios() {
		
		List<FuncionarioDTO> funcionarios = new FuncionarioDAO().buscarFuncionarios();

		return funcionarios;
	}
	
	@RequestMapping(value = "lista_funcionarios_disponiveis", method = RequestMethod.GET)
	public List<FuncionarioDTO> getListaFuncionariosDisponiveis(@RequestParam String data, @RequestParam String horaInicio, @RequestParam String horaFim ) {
		
		List<FuncionarioDTO> funcionarios = new FuncionarioDAO().buscarFuncionarioDisponivel(data, horaInicio, horaFim);

		return funcionarios;
	}

}
