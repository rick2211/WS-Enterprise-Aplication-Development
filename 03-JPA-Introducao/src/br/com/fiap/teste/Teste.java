package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		//Criar um entity manager (gerenciador de entidades)
		//Primeiro, criar a fabrica de entity manager
		EntityManagerFactory fabrica = //nome que está no persistence.xml
			Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		//Criar o entity manager utilizando a fábrica
		EntityManager em = fabrica.createEntityManager();
	
		em.close();
		fabrica.close();
	}
	
}




