package br.com.salaodebeleza.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.ClienteDAO;
import br.com.salaodebeleza.dto.ClienteDTO;
import br.com.salaodebeleza.dto.UsuarioDTO;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public UsuarioDTO CriarCliente(@ModelAttribute ClienteDTO dto,
			HttpServletResponse response) {

		UsuarioDTO usuario = new ClienteDAO().criarCliente(dto);

		if (usuario == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

		return usuario;
	}

}
