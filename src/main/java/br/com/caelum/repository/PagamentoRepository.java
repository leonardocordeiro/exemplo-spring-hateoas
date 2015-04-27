package br.com.caelum.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.caelum.model.Pagamento;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {
	
	public List<Pagamento> findAll();
	public Pagamento save(Pagamento pagamento);

}
