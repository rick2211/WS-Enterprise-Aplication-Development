package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CarrinhoCompraDAO;
import br.com.fiap.entity.CarrinhoCompras;

public class CarrinhoComprasDAOImpl extends GenericDAOImpl<CarrinhoCompras, Integer>  implements CarrinhoCompraDAO {

	public CarrinhoComprasDAOImpl(EntityManager em) {
		super(em);
		
	}

}
