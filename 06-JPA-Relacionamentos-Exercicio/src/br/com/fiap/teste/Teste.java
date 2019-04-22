package br.com.fiap.teste;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CasoTesteDAO;
import br.com.fiap.dao.impl.CasoTesteDAOImpl;
import br.com.fiap.entity.CasoTeste;
import br.com.fiap.entity.ItemTeste;
import br.com.fiap.entity.Sistema;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {

	@Test
	void test() {
		
		EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
		
		CasoTesteDAO dao = new CasoTesteDAOImpl(em);
		
		CasoTeste caso = new CasoTeste();
		caso.setNome("Teste de cadastro de usuário");
		
		Sistema sistema = new Sistema();
		sistema.setNome("Sistema de compras");
		
		caso.setSistema(sistema);
		
		ItemTeste item1 = new ItemTeste();
		item1.setDescricao("Cadastro de usuário sem CPF");
		
		ItemTeste item2 = new ItemTeste();
		item2.setDescricao("Cadastro de usuário com mesmo CPF");
		
		caso.addItem(item1);
		caso.addItem(item2);
		
		Usuario usuario = new Usuario();
		usuario.setNome("Leo");
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario);
		
		item1.setUsuarios(usuarios);
		item2.setUsuarios(usuarios);
		
		try {
			dao.cadastrar(caso);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

}