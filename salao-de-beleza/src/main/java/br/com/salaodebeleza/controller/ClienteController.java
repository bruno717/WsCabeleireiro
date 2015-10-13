package br.com.salaodebeleza.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.ClienteDAO;
import br.com.salaodebeleza.dto.ClienteDTO;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public ClienteDTO CriarCliente(@ModelAttribute ClienteDTO dto,
			HttpServletResponse response) {

		ClienteDTO usuario = new ClienteDAO().criarCliente(dto);

		if (usuario == null) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}

		return usuario;
	}

}
