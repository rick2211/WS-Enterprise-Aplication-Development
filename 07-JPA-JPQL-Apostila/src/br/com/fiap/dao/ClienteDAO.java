package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	 List<Cliente> listarClientes();

	List<Cliente> buscarClientesPorNome(String name);
	
	List<Pacote> buscarPacotesPorTransporte(Transporte transporte);
	
	List<Cliente> buscarClientesPorEstado(Endereco end);
	
	List<Cliente> buscarClientesPorDias(Integer num);
	

}
