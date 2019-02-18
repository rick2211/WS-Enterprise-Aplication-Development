package br.com.fiap.revisao.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.revisao.bean.Carro;
import br.com.fiap.revisao.bean.Categoria;

public class Teste {

	public static void main(String args[]) {
		//Instanciar um carro
		Carro carro = new Carro("Golf GTI");
		//Atribuir um valor para a categoria
		carro.setCategoria(Categoria.HATCH_ESPORTIVO);
		//Atribuir um valor para a data de fabricação
		Calendar data = Calendar.getInstance(); //Data atual
		
		Calendar data2 = new GregorianCalendar(2010, Calendar.JANUARY, 15);  
		carro.setDataFabricacao(data2);
		
		//Exibir a data de fabricação
		//Objeto para formatar a data                padrão de formatação
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(
				formatador.format(carro.getDataFabricacao().getTime()));
		
		//testar se a categoria é A
		if (carro.getCategoria() == Categoria.A) {
			System.out.println("Categoria A");
		}
		
		/*
		String teste = "";
		String teste2 = "";
		if (teste == teste2) {
			System.out.println("Entrou!");
		}*/
		
		System.out.println("FIM");
	}
	
}




