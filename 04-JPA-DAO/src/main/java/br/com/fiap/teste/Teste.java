package br.com.fiap.teste;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.FarmaciaDAO;
import br.com.fiap.dao.impl.FarmaciaDAOImpl;
import br.com.fiap.entity.Farmacia;
import br.com.fiap.entity.TipoFarmacia;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica =  Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		FarmaciaDAO dao = new FarmaciaDAOImpl(em);
		
		Farmacia f = new Farmacia("Noia da Vila", new GregorianCalendar(2019,02,11), TipoFarmacia.COMUM, true);
		
		try {
			dao.cadastrar(f);
			dao.commit();
		} catch (CommitException e) {
			
			e.printStackTrace();
		}
		
		f.setNome("Boca do Cenôra");
		dao.atualizar(f);
		
		
		Farmacia buscar = dao.buscar(f.getCdFarmacia());
		System.out.println(buscar.getCdFarmacia());
		
		try {
			dao.deletar(buscar.getCdFarmacia());
			dao.commit();
		} catch (CodigoInvalidoException e) {
			
			e.printStackTrace();
		} catch (CommitException e) {
			
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();

	}

}
