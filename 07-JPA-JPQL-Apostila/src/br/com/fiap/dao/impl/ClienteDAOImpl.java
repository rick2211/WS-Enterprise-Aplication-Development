package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		TypedQuery<Cliente> query = 
			em.createQuery("from Cliente",Cliente.class);
		query.setMaxResults(3);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		return em.createQuery("from Cliente c where upper(c.nome) "
				+ "like :name",Cliente.class)
				.setParameter("name", "%" + nome + "%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		return em.createQuery("from Cliente c where"
			+ " c.endereco.cidade.uf = :P",Cliente.class)
			.setParameter("P", estado)
			.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReserva(int dias) {
		return em.createQuery("select r.cliente from Reserva r where "
				+ "r.numeroDias = :d",Cliente.class)
				.setParameter("d", dias)
				.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		
		return em.createNamedQuery("Cliente.porNomeECidade", Cliente.class)
				.setParameter("S","%" + nome +"%")
				.setParameter("C","%" + cidade +"%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {
	
		return em.createNamedQuery("Cliente.porEstados", Cliente.class)
				.setParameter("e", estados)
				.getResultList();
	}

	@Override
	public long contarPorEstado(String estado) {
		return em.createQuery("select count (c) from Cliente c where c.endereco.cidade.uf = :e", Long.class)
				.setParameter("e", estado)
				.getSingleResult();
	}

	

}




