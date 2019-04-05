package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listarClientes() {
		
		TypedQuery<Cliente> query =
				em.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
	
	}

	@Override
	public List<Cliente> buscarClientesPorNome(String name) {
		TypedQuery<Cliente> query =
				em.createQuery("from Cliente c where nome like :n", Cliente.class);
		query.setParameter("n", name);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPacotesPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query =
				em.createQuery("from Pacote p where transporte = :t", Pacote.class);
		query.setParameter("n", transporte);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarClientesPorEstado(Endereco end) {
		TypedQuery<Cliente> query =
				em.createQuery("from Cliente c where endereco.cidade.uf = :u", Cliente.class);
	      query.setParameter("u", end);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarClientesPorDias(Integer num) {
		TypedQuery<Cliente> query =
				em.createQuery("from Cliente c where pacotes.qtdDias = :n", Cliente.class);
	      query.setParameter("n", num);
		return query.getResultList();
	}
	

}
