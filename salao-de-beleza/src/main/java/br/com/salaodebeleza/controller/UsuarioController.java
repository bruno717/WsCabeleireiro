package br.com.salaodebeleza.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.UsuarioDAO;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {
	
	@RequestMapping(value = "inativar", method = RequestMethod.PUT)
	public Boolean inativarUsuario(@RequestParam String email, HttpServletResponse response){
		
		Boolean resp = new UsuarioDAO().inativarUsuario(email);
		
		response.setStatus(resp == true ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);
		
		return resp;
	}

}
