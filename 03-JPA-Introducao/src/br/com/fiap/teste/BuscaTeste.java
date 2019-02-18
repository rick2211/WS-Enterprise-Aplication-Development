package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Pastel;

public class BuscaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		Pastel pastel = em.find(Pastel.class, 1);
		
		System.out.println(pastel.getSabor());
		pastel.setSabor("Queijo");
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		fabrica.close();
	}
}
