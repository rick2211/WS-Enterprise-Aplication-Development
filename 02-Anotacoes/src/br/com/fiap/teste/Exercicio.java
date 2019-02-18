package br.com.fiap.teste;

import br.com.fiap.anotacao.Tabela;
import br.com.fiap.bean.Pessoa;

public class Exercicio {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		//Recuperar a anotação @Tabela
		Tabela anotacao = p.getClass().getAnnotation(Tabela.class);
		//Exibir o SQL
		System.out.println("SELECT * FROM " + anotacao.nome());
	}
	
}






