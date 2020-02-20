package br.com.gustavoantunes.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavoantunes.loja.model.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long>{

}
