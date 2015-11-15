package br.com.salaodebeleza.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.model.Compra;
import br.com.salaodebeleza.model.ContaPagar;
import br.com.salaodebeleza.model.Produto;
import br.com.salaodebeleza.service.CompraService;

@RestController
@RequestMapping(value = "compra")
public class CompraController {
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public Boolean cadastrarCompra(@ModelAttribute Compra compra,
			HttpServletResponse response) {

		//OBJETO DE TESTE COMENTADO
		List<Produto> produtos = new ArrayList<Produto>();
		
		for(int i =0; i < 5; i++){
			Produto produto = new Produto(1, 1, "condicionador cabelos cacheados", "Fabricante", "Realça o cacheado do cabelo", 10f);
			produtos.add(produto);
		}
		
		Compra c = new Compra(null, 1, 1, 1, produtos, 10f, null);
		
		Boolean resp = new CompraService().compraAberta(c);
		
		//Boolean resp = new CompraService().compraAberta(compra);
		
		response.setStatus(resp ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);		
		
		return resp;
	}
	
	@RequestMapping(value = "pagar", method = RequestMethod.POST)
	public Boolean pagarCompra(@ModelAttribute ContaPagar contaPagar,
			HttpServletResponse response) {
		
		Boolean resp = new CompraService().pagarCompra(contaPagar);
		
		response.setStatus(resp ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);		
		
		return resp;
	}

}
