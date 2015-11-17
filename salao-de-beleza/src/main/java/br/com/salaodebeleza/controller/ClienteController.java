package br.com.salaodebeleza.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.ClienteDAO;
import br.com.salaodebeleza.dto.ClienteDTO;
import br.com.salaodebeleza.util.FormatDateString;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public ClienteDTO criarCliente(@ModelAttribute ClienteDTO dto,
			HttpServletResponse response) {

		ClienteDTO usuario = new ClienteDAO().criarCliente(dto);

		if (usuario == null) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}

		return usuario;
	}

	@RequestMapping(value = "criar_completo", method = RequestMethod.POST)
	public Boolean criarClienteCompleto(@ModelAttribute ClienteDTO dto,
			HttpServletResponse response) {
		
		dto.setDtNascimento(FormatDateString.formataDataBanco(FormatDateString.RetiraCaracteres(dto.getDtNascimento())));

		Boolean resp = new ClienteDAO().criarClienteCompleto(dto);

		response.setStatus(resp ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);

		return true;
	}

	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public ClienteDTO alterarCliente(@ModelAttribute ClienteDTO dto,
			HttpServletResponse response) {

		ClienteDTO usuario = new ClienteDAO().alterarCliente(dto);

		if (usuario == null) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}

		return usuario;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ClienteDTO getCliente(@RequestParam String email) {
		return new ClienteDAO().getCliente(email);
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public List<ClienteDTO> getListaCliente() {
		return new ClienteDAO().buscarClientes();
	}

}
