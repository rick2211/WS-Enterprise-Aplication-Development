package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

<<<<<<< HEAD
	//1- atributo est�tico que ser� �nico
	private static EntityManagerFactory emf;
	
	//2- construtor vazio e privado
	private EntityManagerFactorySingleton() {}
	
	//3- m�todo est�tico que retorna a �nica instancia
	public static EntityManagerFactory getInstance() {
		if (emf == null) {
			emf = Persistence
				.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emf;
	}
	
}




=======
	private static EntityManagerFactory emf;

	private EntityManagerFactorySingleton() {

	}

	public static EntityManagerFactory getInstance() {
		if(emf==null) {
			emf =Persistence
					.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emf;
	}
}
>>>>>>> e77468f38a5b5728a72d7cdce95c0fa6e0c6a53d
