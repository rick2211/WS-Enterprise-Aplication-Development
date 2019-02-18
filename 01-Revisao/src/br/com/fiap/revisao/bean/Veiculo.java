package br.com.fiap.revisao.bean;

public class Veiculo {

	private String cor;
	
	private String nome;
	
	public Veiculo(String nome) {		
		this.nome = nome;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}