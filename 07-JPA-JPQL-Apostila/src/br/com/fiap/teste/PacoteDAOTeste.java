package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

class PacoteDAOTeste {

	private static PacoteDAO pacoteDao;
	private static TransporteDAO transporteDao;
	
	@BeforeAll
	public static void init() {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		pacoteDao = new PacoteDAOImpl(em);
		transporteDao = new TransporteDAOImpl(em);
	}
	
	@Test
	void buscarPorTransporteTest() {
		Transporte transporte = transporteDao.pesquisar(1);
		List<Pacote> lista = pacoteDao.buscarPorTransporte(transporte);

		for (Pacote pacote : lista) {
			assertEquals(transporte.getId(), 
						pacote.getTransporte().getId());
		}
		
	}

}








