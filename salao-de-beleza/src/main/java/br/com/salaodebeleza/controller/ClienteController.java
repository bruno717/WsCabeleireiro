package br.com.salaodebeleza.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.ClienteDAO;
import br.com.salaodebeleza.dto.UsuarioDTO;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public UsuarioDTO CriarCliente(@RequestParam String inputNome, @RequestParam Integer inputTelefone,
			@RequestParam String inputEmail, @RequestParam String inputSenha, HttpServletResponse response){
		
		UsuarioDTO dto = new UsuarioDTO(inputNome, inputTelefone, inputEmail, inputSenha);
		
		dto = new ClienteDAO().criarCliente(dto);
		
		if(dto == null){
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
		return dto;
	}
	
}
