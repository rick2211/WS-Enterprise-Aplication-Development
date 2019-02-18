package br.com.fiap.bean;

import java.util.Date;

public class Crianca extends Pessoa {

	@Override
	@Deprecated //método obsoleto
	public void falar() {
		new Date("");
	}
	
}