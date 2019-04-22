package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Predicate;

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
	void buscarPorPrecoMaximo() {
		List<Pacote> lista = pacoteDao.buscarPorPrecoMaximo(1000);
		assertTrue(lista.stream().map(Pacote::getPreco) != null);
	}
	
	@Test
	void somarPorTransporteTest() {
		Transporte  transporte = transporteDao.pesquisar(1);
		double total = pacoteDao.somarPrecoPorTransporte(transporte);
		assertEquals(4300,  total);
	}
	
	@Test
	void buscarPorDatasTest() {
		Calendar inicio = new GregorianCalendar(2017 , Calendar.JANUARY,1);
		Calendar fim = new GregorianCalendar(2018 , Calendar.JANUARY,1);
		
		List<Pacote> lista = pacoteDao.buscarPorDatas(inicio, fim);
		
		lista.stream().map(Pacote :: getDataSaida).filter(d -> d.after(inicio) && d.before(fim));
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








