package br.com.caelum.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.model.Pagamento;
import br.com.caelum.model.PagamentoRepo;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	private PagamentoRepo repo;
	
	@Transactional
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Resource<Pagamento>> criarPagamento(@RequestBody Pagamento pagamento) {
		System.out.println(pagamento.getTotal());
		
		Resource<Pagamento> resource = new Resource<>(pagamento);
		resource.add(
				linkTo(
					methodOn(PagamentoController.class)
						.cancelarPagamento(pagamento)).withRel("cancelar"));
		
		repo.save(pagamento);
		System.out.println(repo.findAll());
		
		return new ResponseEntity<Resource<Pagamento>>(resource, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/cancelar", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Pagamento cancelarPagamento(Pagamento pagamento) { 
		System.out.println("Pagamento cancelado");
		
		return pagamento;
	}

}
