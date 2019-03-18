package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SEQ_T_CLIENTE", allocationSize=1)
public class Cliente {
	
	@Id
	@Column(name="cd_cliente")
	@GeneratedValue(generator = "cliente", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name= "nm_cliente", nullable= false, length= 50)
	private String nome;
	@Column(name= "nr_cpf", nullable= false, length= 11)
	private String cpf;
	
	@OneToOne(mappedBy="cliente")
	private CarrinhoCompras carrinhoCompras;

}
