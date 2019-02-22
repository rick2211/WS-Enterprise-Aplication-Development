package br.com.fiap.dao;

import br.com.fiap.entity.Farmacia;
import br.com.fiap.exception.CommitException;

public interface FarmaciaDAO {
	
	void cadastrar(Farmacia farmacia);
	void deletar (Integer codigo);
	void atualizar(Farmacia farmacia);
	Farmacia buscar(Integer codigo);
	
	void commit() throws CommitException;
	

}
