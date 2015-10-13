package br.com.salaodebeleza.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.util.RefactorString;

@RestController
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(method = RequestMethod.GET)
	public String test(@RequestParam String telefone){
		return RefactorString.refactorTel(telefone);
	}
	
}
