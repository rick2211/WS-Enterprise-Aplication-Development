package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	
	
	long contarPorEstado(String estado);
	
	List<Cliente> buscarPorEstados(List<String> estados);

	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> listar();
	
	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscarPorEstado(String estado);
	
	List<Cliente> buscarPorDiasReserva(int dias);
	
}