package hello;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {
	
	private int idPagamento;

	@RequestMapping(value="/pagamento", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Resource<Pagamento>> criarPagamento(@RequestBody Pagamento pagamento) {
		pagamento.setId(idPagamento++);
		
		System.out.println("Pagamento " + pagamento.getId() + " criado com sucesso!");
		
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
