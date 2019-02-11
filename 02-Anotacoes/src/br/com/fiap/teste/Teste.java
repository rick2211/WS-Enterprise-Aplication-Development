package br.com.fiap.teste;

import java.lang.reflect.Field;

import br.com.fiap.anotacoes.Coluna;
import br.com.fiap.anotacoes.Tabela;
import br.com.fiap.bean.Aluno;
import br.com.fiap.bean.Carro;

public class Teste {

	public static void main(String[] args) {
		// Instanciar um carro
		Carro carro = new Carro();
		criarTabela(carro);
		criarSelect(carro);
		
		Aluno aluno = new Aluno();
		criarSelect(aluno);		
	}
	
	public static void criarSelect(Object obj) {
		//Recuperar o nome configurado na anotação @Tabela
		Tabela anotacao = obj.getClass().getAnnotation(Tabela.class);
		//Exibir o SQL
		System.out.println("SELECT * FROM " + anotacao.nome());
	}

	public static  void criarTabela(Object obj) {
		// API Reflection vamos recuperar o nome da classe
		String nome = obj.getClass().getName();
		System.out.println(nome);
		
		//Recuperar os atributos da classe
		Field[] atributos = obj.getClass().getDeclaredFields();
		for (Field f : atributos) {
			System.out.println(f.getName());
			//Recuperar a anotação @Coluna
			Coluna anotacao = f.getAnnotation(Coluna.class);
			System.out.println("Nome: " + anotacao.nome());
			System.out.println("Tipo: " + anotacao.tipo());
			System.out.println("Obrigatório: " + anotacao.obrigatorio());
		}
	}

}





