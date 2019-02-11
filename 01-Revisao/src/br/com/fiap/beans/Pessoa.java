package br.com.fiap.beans;

import java.util.Date;

//Toda classe herda de Object
public class Pessoa {

	//Modificador de acesso: public, private
	//protected -> pacote e nas classes filhas 
	//default/package -> pacote
	
	private String nome;

	private String cpf;
	
	private Genero sexo;
	
	@Deprecated //método obsoleto
	public void cadastrar() {
		new Date("");
	}
	
//	public Pessoa() {
//	}

	public Pessoa(String nome, String cpf) {
		super(); //chama o construtor do pai
		this.nome = nome;
		this.setCpf(cpf);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}
	
	
}