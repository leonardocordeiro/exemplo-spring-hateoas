package br.com.caelum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caelum.model.Pagamento;

//@Controller
public class PagamentoController2 {
	
	@RequestMapping(value="/pagamento", method=RequestMethod.POST)
	public void criarPagamento(Pagamento pagamento) { 
		System.out.println(pagamento.getTotal());
		
	}
}
