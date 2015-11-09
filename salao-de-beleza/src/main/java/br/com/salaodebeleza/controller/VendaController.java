package br.com.salaodebeleza.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.model.ContaReceber;
import br.com.salaodebeleza.model.Venda;
import br.com.salaodebeleza.service.VendaService;

@RestController
@RequestMapping(value = "venda")
public class VendaController {

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public Boolean cadastrarCompra(@ModelAttribute Venda venda, @ModelAttribute ContaReceber contaReceber,
			HttpServletResponse response) {
		
		Boolean resp = new VendaService().registrarVenda(venda, contaReceber);
		
		response.setStatus(resp ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);		
		
		return resp;
	}
	
	
}
