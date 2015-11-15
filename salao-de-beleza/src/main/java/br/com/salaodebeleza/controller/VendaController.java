package br.com.salaodebeleza.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaodebeleza.model.ContaReceber;
import br.com.salaodebeleza.model.Produto;
import br.com.salaodebeleza.model.Venda;
import br.com.salaodebeleza.service.VendaService;

@RestController
@RequestMapping(value = "venda")
public class VendaController {

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public Boolean cadastrarCompra(@ModelAttribute Venda venda, @ModelAttribute ContaReceber contaReceber,
			HttpServletResponse response) {
		
//		Boolean resp = new VendaService().registrarVenda(venda, contaReceber);
		List<Produto> produtos = new ArrayList<Produto>();
		Produto p = new Produto(1, 1, "gel", "teste","",10F);
		for (int i = 0; i < 3; i++) {
			produtos.add(p);
		}
		Venda v = new Venda(31, 1, null, produtos, 30F, true, 1);
		ContaReceber cr = new ContaReceber();
		cr.setIdTipoConta(1);
		cr.setParcelas(1);
		cr.setDataVencimento(new Date());
		cr.setDataRecebimento(new Date());
		cr.setDesconto(0D);
		cr.setJuros(0D);
		cr.setValorConta(10D);
		cr.setValorRecebido(10D);
		
		Boolean resp = new VendaService().registrarVenda(v, cr);
		
		response.setStatus(resp ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CONFLICT);		
		
		return resp;
	}
	
	
}
