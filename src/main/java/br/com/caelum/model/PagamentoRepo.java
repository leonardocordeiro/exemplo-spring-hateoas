package br.com.caelum.model;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PagamentoRepo extends CrudRepository<Pagamento, Integer> {
	
	public Pagamento save(Pagamento pagamento);
	public List<Pagamento> findAll();

}
