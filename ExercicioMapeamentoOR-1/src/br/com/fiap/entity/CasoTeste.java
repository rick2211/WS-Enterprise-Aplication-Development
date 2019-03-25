package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "TAB_CASO_TESTE")
@SequenceGenerator(name="caso_teste", sequenceName= "SEQ_CASO_TESTE", allocationSize=1)
public class CasoTeste {
	
	@Id
	@GeneratedValue(generator="caso_teste", strategy=GenerationType.SEQUENCE)
	@Column(name="cod_caso_teste")
	private Integer codigo;
	@Column(name="nom_caso_teste")
	private String nome;
	@Column(name="des_caso_teste")
	private String descricao;


}
