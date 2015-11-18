package br.com.salaodebeleza.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dto.MovimentacaoDiaDTO;
import br.com.salaodebeleza.service.FinanceiroService;

@RestController
@RequestMapping(value = "financeiro")
public class FinanceiroController {
	
	@RequestMapping(value = "dia", method = RequestMethod.GET)
	public MovimentacaoDiaDTO dia(@RequestParam String data) {

		MovimentacaoDiaDTO diaDTO = new FinanceiroService().movimentacaoDia(data);

		return diaDTO;
	}
	
	@RequestMapping(value = "periodo", method = RequestMethod.GET)
	public MovimentacaoDiaDTO periodo(@RequestParam String dataInicio, String dataFim) {

		MovimentacaoDiaDTO diaDTO = new FinanceiroService().movimentacaoPeriodo(dataInicio, dataFim);

		return diaDTO;
	}


}
