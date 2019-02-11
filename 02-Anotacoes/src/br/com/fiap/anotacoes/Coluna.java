package br.com.fiap.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Manter a anota��o at� a execu��o
@Retention(RetentionPolicy.RUNTIME)
//Para quem serve a anota��o?
@Target(ElementType.FIELD) //Atributos
public @interface Coluna {

	String nome();
	
	String tipo();
	
	boolean obrigatorio() default false;
	
}