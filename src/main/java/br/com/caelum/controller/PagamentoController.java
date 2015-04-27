package br.com.caelum.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.model.Pagamento;
import br.com.caelum.repository.PagamentoRepository;

@RestController
public class PagamentoController {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PagamentoRepository repo;
	
	@Transactional
	@RequestMapping(value="/pagamento", method=RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Resource<Pagamento>> criarPagamento(@RequestBody Pagamento pagamento) {
		repo.save(pagamento);
		
		System.out.println("Pagamento " + pagamento.getId() + " criado com sucesso!");
		
		List<Pagamento> pagamentos = repo.findAll();
		
		for (Pagamento pagamento2 : pagamentos) {
			System.out.println(pagamento2.getTotal());
		}		
		
		Resource<Pagamento> resource = new Resource<>(pagamento);
		resource.add(
			linkTo(
				methodOn(PagamentoController.class)
					.cancelarPagamento(pagamento.getId()))
						.withRel("cancelar"));
	
		return new ResponseEntity<Resource<Pagamento>>(resource, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/pagamento/{id}", method=RequestMethod.POST)
	public HttpEntity<Pagamento> cancelarPagamento(@PathVariable int id) {
		return null;
	}
}
