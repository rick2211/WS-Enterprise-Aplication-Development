package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.bean.Pessoa;

public class Teste {

	public static void main(String[] args) {
		//Instanciar uma pessoa
		Pessoa p = new Pessoa();
		
		//API Reflection -> obter o nome da classe
		String nome = p.getClass().getName();
		System.out.println(nome);
		
		//Obter os métodos da classe
		System.out.println("Métodos:");
		Method[] metodos = p.getClass().getDeclaredMethods();
		for (Method item : metodos) {
			System.out.println(item.getName());
		}
		
		//Obter os atributos da classe
		System.out.println("Atributos:");
		Field[] atributos = p.getClass().getDeclaredFields();
		for (int i=0; i < atributos.length; i++) {
			System.out.println(atributos[i].getName());
			//Recuperar a anotação @Coluna
			Coluna anotacao = 
					atributos[i].getAnnotation(Coluna.class);
			System.out.println("Nome: " + anotacao.nome());
			System.out.println("Tipo: " + anotacao.tipo());
			System.out.println("Tamanho: " + anotacao.tamanho());
		}
	}
}





