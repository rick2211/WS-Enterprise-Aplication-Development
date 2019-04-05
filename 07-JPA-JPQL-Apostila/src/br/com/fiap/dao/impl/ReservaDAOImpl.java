package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> listar() {
		TypedQuery<Reserva> query = 
				em.createQuery("from Reserva",Reserva.class);
		return query.getResultList();
	}

	@Override
	public List<Reserva> buscarPorData(Calendar data) {
		TypedQuery<Reserva> query = 
				em.createQuery("from Reserva r where r.dataReserva = :d",Reserva.class);
		query.setParameter("d", data );
		return query.getResultList();
	}

}
