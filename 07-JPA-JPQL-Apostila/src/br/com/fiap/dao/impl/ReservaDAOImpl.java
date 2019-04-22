package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> listar() {
		//Cria a query
		TypedQuery<Reserva> query = em.createQuery(
						"from Reserva",Reserva.class);
		//Executa a query
		return query.getResultList();
	}

	@Override
	public List<Reserva> buscarPorData(Calendar data) {
		//Criar a TypedQuery
		TypedQuery<Reserva> query = em.createQuery(
			"from Reserva r where r.dataReserva = :d",
			Reserva.class);
		//Setar o parametro na query
		query.setParameter("d", data.getTime(), TemporalType.DATE);
		//Executar a TypedQuery
		return query.getResultList();
	}

}






