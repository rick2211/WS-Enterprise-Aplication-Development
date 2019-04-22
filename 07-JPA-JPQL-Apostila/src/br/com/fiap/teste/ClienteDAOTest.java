package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

class ClienteDAOTeste {

	private static ClienteDAO dao;
	
	@BeforeAll
	public static void init() {
		dao = new ClienteDAOImpl(
			EntityManagerFactorySingleton
				.getInstance().createEntityManager());
	}
	
	void contarPorEstadoTest() {
		long qtd = dao.contarPorEstado("SP");
		assertEquals(1, qtd);
	}
	
	@Test
	void buscarPorDiasReservaTest() {
		List<Cliente> lista = dao.buscarPorDiasReserva(10);
		assertNotEquals(0, lista.size());
	}
	
	@Test
	void buscarPorEstadoTest() {
		
		List<Cliente> lista = dao.buscarPorEstado("SP");
		
		for (Cliente cliente : lista) {
			assertEquals("SP", cliente.getEndereco()
									.getCidade().getUf());
		}
		
	}
	
	@Test
	void listarTest() {
		List<Cliente> lista = dao.listar();
		assertNotEquals(0, lista.size());
	}
	
	@Test
	void buscarPorNomeTest() {
		List<Cliente> lista = dao.buscarPorNome("Le");
		
		for (Cliente cliente : lista) {
			assertTrue(cliente.getNome().indexOf("Le") > -1);
			//assertTrue(cliente.getNome().contains("Le"));
		}
		
	}

}



