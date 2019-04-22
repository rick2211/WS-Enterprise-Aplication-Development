package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{
	
	List<Pacote> buscarPorPrecoMaximo(double preco);
	
	double somarPrecoPorTransporte(Transporte transporte);

	List<Pacote> buscarPorTransporte(Transporte transporte);
	
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
}
