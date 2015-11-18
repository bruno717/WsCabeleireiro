package br.com.salaodebeleza.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dto.RelatorioDTO;
import br.com.salaodebeleza.service.RelatorioService;

@RestController
@RequestMapping(value = "relatorio")
public class RelatorioController {
	
	@RequestMapping(method = RequestMethod.GET)
	public RelatorioDTO dia() {

		RelatorioDTO relatorioDTO = new RelatorioService().relatorioPeriodo();

		return relatorioDTO;
	}


}
