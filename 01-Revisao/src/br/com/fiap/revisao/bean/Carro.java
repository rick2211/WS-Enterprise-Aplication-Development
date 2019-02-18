package br.com.fiap.revisao.bean;

import java.util.Calendar;

public class Carro extends Veiculo {

	//Constante
	public static final String TESTE_CARRO = "Teste";
	
	private double peso; //valor default -> 0
	
	private boolean novo; //valor default -> false
	
	private Calendar dataFabricacao; //valor default -> null
	
	public Carro(String nome) {
		super(nome);
	}

	private Categoria categoria;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
}