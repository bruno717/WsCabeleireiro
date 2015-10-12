package br.com.salaodebeleza.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.FuncionarioDAO;
import br.com.salaodebeleza.dto.FuncionarioDTO;
import br.com.salaodebeleza.model.FuncionarioModel;

@RestController
@RequestMapping(value = "funcionario")
public class FuncionarioController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarFuncionario(@ModelAttribute FuncionarioDTO dto, HttpServletResponse response) {
		
		FuncionarioModel funcionario = new FuncionarioModel().toFuncionario(dto);
		Boolean resp = new FuncionarioDAO().criarFuncionario(funcionario);
		if(!resp){
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

}
