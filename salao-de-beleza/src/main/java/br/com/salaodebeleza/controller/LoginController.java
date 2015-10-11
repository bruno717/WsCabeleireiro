package br.com.salaodebeleza.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.LoginDAO;
import br.com.salaodebeleza.dto.UsuarioDTO;

@RestController
@RequestMapping(value = "login")
public class LoginController {

	@RequestMapping(method = RequestMethod.POST)
	public UsuarioDTO login(@RequestParam String email,
			@RequestParam String senha, HttpServletResponse response) {

		UsuarioDTO dto = null;
		dto = new LoginDAO().loginWeb(email, senha);

		if (dto == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return dto;
	}

}
