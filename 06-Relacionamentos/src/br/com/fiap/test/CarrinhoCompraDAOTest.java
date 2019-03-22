package br.com.fiap.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CarrinhoCompraDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.impl.CarrinhoComprasDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.CarrinhoCompras;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.ItemCarrinho;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class CarrinhoCompraDAOTest {
	
	private static ClienteDAO clienteDao;
	private static CarrinhoCompraDAO carrinhoDao;
	
	@BeforeAll
	public static void inicializar() {
		EntityManager em = 
				EntityManagerFactorySingleton.getInstance().createEntityManager();
		clienteDao = new ClienteDAOImpl(em);
		carrinhoDao = new CarrinhoComprasDAOImpl(em);
	}

	@Test
	void test() {
		
		Cliente cliente = new Cliente("Sergio","12345678900");
		CarrinhoCompras compras = new CarrinhoCompras(cliente, 100);
		
		ItemCarrinho item1 = new ItemCarrinho();
		item1.setValor(100);
		

		ItemCarrinho item2 = new ItemCarrinho();
		item2.setValor(500);
		
		compras.addItem(item1);
		compras.addItem(item2);
		try {
		clienteDao.cadastrar(cliente);
		carrinhoDao.cadastrar(compras);
		
			carrinhoDao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Falha no teste");
		}
		assertNotEquals(0, cliente.getCodigo());
		assertNotEquals(0, compras.getCodigo());
		
		try {
			CarrinhoCompras busca = carrinhoDao.buscar(compras.getCodigo());
			assertNotNull(busca);
			assertNotNull(busca.getCliente());
			
		} catch (CodigoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Falha no teste");
		}
				
	}

}
