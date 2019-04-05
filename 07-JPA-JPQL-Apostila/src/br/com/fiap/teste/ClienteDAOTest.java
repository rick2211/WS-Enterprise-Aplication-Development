package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;

public class ClienteDAOTest {
	
	private static ClienteDAO dao;
	
	@BeforeAll
	public static void iniciar() {
		dao = new ClienteDAOImpl(EntityManagerFactorySingleton
			.getInstance().createEntityManager());
	}

	@Test
	void buscarClientesPorNome() {
		List<Cliente> cs = 
				List<Cliente> lista = dao.buscarPorData(data);
			for (Reserva reserva : lista) {
				assertEquals(data, reserva.getDataReserva());
			}
				}
	
	@Test
	void buscarPacotesPorTransporte() {
		Calendar data = 
				new GregorianCalendar(2017, Calendar.MARCH, 20);
				List<Reserva> lista = dao.buscarPorData(data);
			for (Reserva reserva : lista) {
				assertEquals(data, reserva.getDataReserva());
			}
				}
	
	@Test
	void buscarClientesPorEstado() {
		Calendar data = 
				new GregorianCalendar(2017, Calendar.MARCH, 20);
				List<Reserva> lista = dao.buscarPorData(data);
			for (Reserva reserva : lista) {
				assertEquals(data, reserva.getDataReserva());
			}
				}
	
	@Test
	void buscarClientesPorDias() {
		Calendar data = 
				new GregorianCalendar(2017, Calendar.MARCH, 20);
				List<Reserva> lista = dao.buscarPorData(data);
			for (Reserva reserva : lista) {
				assertEquals(data, reserva.getDataReserva());
			}
				}

	
}
