package br.com.salaodebeleza.controller;

import java.sql.Connection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.dao.Connect;

@RestController
//@RequestMapping(value = "/")
public class HomeController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String[] hello() {

		return new String[] { "teste 1", "teste 2" };
	}

	@RequestMapping(value = "/conecta", method = RequestMethod.GET)
	@ResponseBody
	public boolean conecta() {
		Connection con;
		try {
			con = Connect.getConexao();
			if (con.isValid(0)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
