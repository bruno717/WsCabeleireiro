package br.com.salaodebeleza.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.FuncionarioDAO;
import br.com.salaodebeleza.model.FuncionarioModel;

@RestController
@RequestMapping(value = "funcionario")
public class FuncionarioController {

	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public Boolean criarFuncionario(@RequestParam String inputNome,
			@RequestParam Integer inputTelefone,
			@RequestParam String inputEmail, @RequestParam String inputSenha,
			@RequestParam Integer inputTelefone2,
			@RequestParam String inputNascimento, @RequestParam Long inputCpf,
			@RequestParam String inputSexo, @RequestParam Integer inputCep,
			@RequestParam String inputLogradouro,
			@RequestParam String inputNumero, @RequestParam String inputBairro,
			@RequestParam String inputCidade, @RequestParam String inputEstado,
			@RequestParam String inputPais, HttpServletResponse response) {

		FuncionarioModel funcionario = new FuncionarioModel(inputNome,
				inputTelefone, inputEmail, inputSenha, inputTelefone2,
				inputNascimento, inputCpf, inputSexo, inputCep,
				inputLogradouro, inputNumero, inputBairro, inputCidade,
				inputEstado, inputPais);

		Boolean resp = new FuncionarioDAO().criarFuncionario(funcionario);
		
		if(!resp){
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

}
